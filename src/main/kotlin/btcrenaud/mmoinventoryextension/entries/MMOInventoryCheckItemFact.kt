package btcrenaud.mmoinventoryextension.entries

import com.typewritermc.core.books.pages.Colors
import com.typewritermc.core.entries.Ref
import com.typewritermc.core.entries.emptyRef
import com.typewritermc.core.extension.annotations.Entry
import com.typewritermc.engine.paper.entry.entries.ConstVar
import com.typewritermc.engine.paper.entry.entries.GroupEntry
import com.typewritermc.engine.paper.entry.entries.ReadableFactEntry
import com.typewritermc.engine.paper.entry.entries.Var
import com.typewritermc.engine.paper.facts.FactData
import net.Indyuce.mmoitems.api.Type
import io.lumine.mythic.lib.api.item.NBTItem
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.logging.Logger

@Entry(
    "mmoinventory_check_item_fact",
    "Check if player has specific MMOItem(s) in a MMOInventory",
    Colors.BLUE,
    "material-symbols:inventory"
)
class MMOInventoryCheckItemFact(
    override val id: String = "",
    override val name: String = "",
    override val comment: String = "",
    override val group: Ref<GroupEntry> = emptyRef(),
    val inventoryName: Var<String> = ConstVar(""),
    val itemsToCheck: Var<String> = ConstVar(""),
    val requireAllItems: Var<Boolean> = ConstVar(false),
) : ReadableFactEntry {

    override fun readSinglePlayer(player: Player): FactData {
        val logger = Logger.getLogger("MMOInventoryCheckItemFact")

        val invName = inventoryName.get(player).trim()
        val itemsString = itemsToCheck.get(player).trim()
        val requireAll = requireAllItems.get(player)

        if (invName.isBlank() || itemsString.isBlank()) {
            return FactData(0)
        }

        val plugin = Bukkit.getPluginManager().getPlugin("MMOInventory")
            ?: return FactData(0)

        val items = try {
            val inventory = findInventory(plugin, player, invName, logger) ?: return FactData(0)
            retrieveItems(inventory, logger)
        } catch (ex: Exception) {
            logger.severe("Error accessing MMOInventory: ${ex.message}")
            return FactData(0)
        }

        if (items.isEmpty()) {
            return FactData(0)
        }

        val itemCounts = countItems(items.toTypedArray())
        val requirements = parseItemRequirements(itemsString)

        if (requirements.isEmpty()) {
            return FactData(0)
        }

        val success = requirements.map { req ->
            val count = itemCounts[req.type to req.id] ?: 0
            count >= req.requiredAmount
        }.let { matches ->
            if (requireAll) matches.all { it } else matches.any { it }
        }

        return FactData(if (success) 1 else 0)
    }

    private fun findInventory(plugin: org.bukkit.plugin.Plugin, player: OfflinePlayer, name: String, logger: Logger): Any? {
        val invManager = plugin.javaClass.getMethod("getInventoryManager").invoke(plugin)
        val customInventory = invManager.javaClass.getMethod("getCustom", String::class.java).invoke(invManager, name)
        if (customInventory == null) {
            logger.info("Inventory '$name' not found")
            return null
        }
        val dataManager = plugin.javaClass.getMethod("getDataManager").invoke(plugin)
        val playerData = dataManager.javaClass.getMethod("get", OfflinePlayer::class.java).invoke(dataManager, player)
        return playerData?.javaClass?.getMethod("getCustom", customInventory.javaClass)
            ?.invoke(playerData, customInventory)
    }

    private fun retrieveItems(inventory: Any, logger: Logger): List<ItemStack> {
        val invClass = inventory.javaClass
        // try getFilledSlots
        val items = mutableListOf<ItemStack>()
        try {
            val filledSlots = invClass.getMethod("getFilledSlots").invoke(inventory) as? Collection<*>
            if (filledSlots != null && filledSlots.isNotEmpty()) {
                val slotClass = filledSlots.first()!!.javaClass
                val retrieve = invClass.getMethod("retrieveItem", slotClass)
                for (slot in filledSlots) {
                    val item = retrieve.invoke(inventory, slot)
                    if (item is ItemStack) items.add(item)
                }
            }
        } catch (_: Exception) {}
        if (items.isEmpty()) {
            try {
                val retrieved = invClass.getMethod("retrieveItems").invoke(inventory) as? Collection<*>
                retrieved?.forEach { if (it is ItemStack) items.add(it) }
            } catch (_: Exception) {}
        }
        if (items.isEmpty()) {
            try {
                val getItem = invClass.getMethod("getItem", Int::class.javaPrimitiveType)
                for (i in 0 until 54) {
                    val item = getItem.invoke(inventory, i)
                    if (item is ItemStack) items.add(item)
                }
            } catch (_: Exception) {}
        }
        return items
    }

    private data class ItemRequirement(val type: String, val id: String, val requiredAmount: Int)

    private fun parseItemRequirements(input: String): List<ItemRequirement> {
        return input.split(',').mapNotNull { token ->
            val parts = token.trim().split(':')
            when (parts.size) {
                2 -> ItemRequirement(parts[0].trim().uppercase(), parts[1].trim().uppercase(), 1)
                3 -> parts[2].trim().toIntOrNull()?.let { amt ->
                    ItemRequirement(parts[0].trim().uppercase(), parts[1].trim().uppercase(), amt)
                }
                else -> null
            }
        }
    }

    private fun countItems(contents: Array<ItemStack?>): Map<Pair<String, String>, Int> {
        val counts = mutableMapOf<Pair<String, String>, Int>()
        for (item in contents) {
            val stack = item ?: continue
            if (stack.type.isAir) continue
            val nbt = NBTItem.get(stack)
            if (!nbt.hasType()) continue
            val type = Type.get(nbt.type) ?: continue
            val id = nbt.getString("MMOITEMS_ITEM_ID") ?: continue
            val key = type.id.uppercase() to id.uppercase()
            counts[key] = counts.getOrDefault(key, 0) + stack.amount
        }
        return counts
    }
}


# MMO Inventory Extension

![Java Version](https://img.shields.io/badge/Java-21-orange)
![Target](https://img.shields.io/badge/Target-Paper-blue)
![Typewriter](https://img.shields.io/badge/Typewriter-0.9.0--beta--177-purple)

**MMO Inventory Extension** is an integration module for **TypeWriter**, built for **BTC Studio** infrastructure. It connects [MMOInventory](https://docs.phoenixdevt.fr/mmoinventory/) to the Typewriter engine: one fact tells whether a player carries given MMOItems in a custom MMOInventory inventory.

---

## 🧩 Available Entries

| Type | Entry | Role |
|---|---|---|
| Fact | `mmoinventory_check_item_fact` | Reads 1 when the player holds the listed MMOItems, otherwise 0 |

Fields of `mmoinventory_check_item_fact`:

- `inventoryName`: name of the custom inventory defined in MMOInventory.
- `itemsToCheck`: comma-separated `TYPE:ID` or `TYPE:ID:amount` (amount defaults to 1), matched on the MMOItems type and ID; stacks of the same item are added together.
- `requireAllItems`: true = every listed item is required, false = any one is enough.

Only MMOItems are recognised. The fact reads 0 when MMOInventory is not installed, the inventory does not exist or a field is empty.

---

## 📋 Requirements

- **Typewriter** `0.9.0-beta-177` and its **Quest** extension
- **Paper** (no Folia support is promised)
- **MMOInventory**, **MMOItems** and MythicLib on the server (built against MythicLib `1.6.2` and MMOItems `6.9.2`)

## ⚙️ Configuration

Everything is configured from the Typewriter web panel through the fact entry. The extension declares no command and no permission.

## 🛠 Building & Deployment

Requires **Java 21**.

```bash
# Clone the repository
git clone https://github.com/RenaudRl/Typewriter-Mmoinventory.git
cd Typewriter-Mmoinventory

# Build the project
./gradlew clean build
```

Output: `build/libs/MMOInventoryExtension-<version>.jar`

---

## 🤝 Credits & Inspiration
- **[TypeWriter](https://github.com/gabber235/Typewriter)** - The engine this extension is built for.
- **[BTC Studio](https://github.com/RenaudRl)** - Maintenance and specialized optimizations.

## 📖 Documentation

Full documentation: [BTC Studio Docs](https://docs.borntocraftstudio.net/extensions/free/mmo-inventory/).

---

## 📜 Licence

**GNU General Public License v3.0 or later** — [LICENSE](LICENSE) — with a
**linking exception** for the Typewriter engine — [LICENSE-EXCEPTION.md](LICENSE-EXCEPTION.md).

| | |
|---|---|
| You may | Run it anywhere, **including on a monetised server**. Study it, modify it, use it as a base, and redistribute it — **even for a fee**. GPLv3 §4 explicitly allows charging for a copy. |
| You must | Publish the complete corresponding source of your version under GPLv3, preserve the copyright notices, and **state that you modified it and when** (§5(a)). |
| You may not | Ship a closed-source or proprietary version, relicense under stricter terms, or strip the attribution and present this work as your own — §8 terminates your rights automatically. |
| Marks | **"Born To Craft"** and **"BTC Studio"** are **not** covered by the GPL. Fork it freely, sell your fork if you like — but **rebrand it**. |

> Reselling this code is legally allowed and practically pointless: whoever buys a
> copy from you receives, under the GPL, the right to redistribute it for free.
> That is the protection — not a clause forbidding sale, which the GPL does not
> permit us to add.

### About Typewriter

This is a **third-party extension**. It uses the public extension API of the
[Typewriter](https://github.com/gabber235/Typewriter) engine by gabber235 and
contains none of its source. Born To Craft Studio is not affiliated with or
endorsed by the Typewriter project.

The engine itself is **not** free software — its licence forbids redistributing
it. **Get it from the Typewriter project, and never redistribute it**, including
inside a fork of this repository.

Full attribution, the statement of modifications required by §5(a), and the
trademark reservation are in **[NOTICE.md](NOTICE.md)**. Read it before
redistributing.

© 2026 Born To Craft Studio.

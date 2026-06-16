package btcrenaud.mmoinventoryextension

import com.typewritermc.core.extension.Initializable
import com.typewritermc.core.extension.annotations.Singleton
import com.typewritermc.engine.paper.logger
import com.typewritermc.engine.paper.plugin
@Singleton
object Initializer : Initializable {
    override suspend fun initialize() {
        logger.info("MmoInventoryExtension has been successfully initialized. By Renaud")
    }

    override suspend fun shutdown() {
        logger.info("MmoInventoryExtension has been successfully stopped.")
    }
}


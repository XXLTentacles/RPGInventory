package ru.endlesscode.inspector.bukkit

import org.bukkit.plugin.java.JavaPlugin
import ru.endlesscode.inspector.bukkit.report.DataType

class Inspector : JavaPlugin() {

    companion object {
        @JvmStatic
        lateinit var GLOBAL: InspectorConfig
    }

    init {
        GLOBAL = InspectorConfig(description.version)
        loadConfig()
    }

    private fun loadConfig() {
        config.options().copyDefaults(true)
        saveConfig()

        with (GLOBAL) {
            isEnabled = config.getBoolean("enabled", true)
            sendData[DataType.CORE] = config.getBoolean("data.core", true)
            sendData[DataType.PLUGINS] = config.getBoolean("data.plugins", true)
        }
    }
}

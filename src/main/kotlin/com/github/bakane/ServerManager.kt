package com.github.bakane

import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.PlayerLoginEvent

object ServerManager {
    fun run(args: Array<String>) {
        val minecraftServer = MinecraftServer.init()

        val instanceContainer = MinecraftServer.getInstanceManager().createInstanceContainer()

        instanceContainer.chunkGenerator = FlatWorldGenerator()

        val globalEventHandler = MinecraftServer.getGlobalEventHandler()

        globalEventHandler.addListener(PlayerLoginEvent::class.java) {
            it.setSpawningInstance(instanceContainer)
            it.player.respawnPoint = Pos(0.toDouble(), 42.toDouble(), 0.toDouble())
        }

        minecraftServer.start("0.0.0.0", 25565);
    }
}

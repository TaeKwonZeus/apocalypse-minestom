package com.github.bakane

import com.github.bakane.generators.FlatChunkGenerator
import com.github.bakane.items.TestItem
import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.item.ItemStack
import net.minestom.server.item.Material

object ApocalypseLoader {
    fun run() {
        val minecraftServer = MinecraftServer.init()

        val instanceContainer = MinecraftServer.getInstanceManager().createInstanceContainer()

        instanceContainer.chunkGenerator = FlatChunkGenerator()

        MinecraftServer.getGlobalEventHandler().addListener(PlayerLoginEvent::class.java) {
            it.player.inventory.addItemStack(TestItem().getItemStack())
            it.setSpawningInstance(instanceContainer)
            it.player.respawnPoint = Pos(0.0, 2.0, 0.0)
        }

        minecraftServer.start("0.0.0.0", 25565)
    }
}
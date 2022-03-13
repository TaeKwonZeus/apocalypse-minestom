package com.github.bakane

import com.github.bakane.generators.FlatChunkGenerator
import com.github.bakane.items.ApocalypseItems
import com.github.bakane.items.ItemTier
import com.github.bakane.items.weapons.Knife
import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.item.ItemStack
import net.minestom.server.item.Material

fun main() {
    val minecraftServer = MinecraftServer.init()

    val instanceContainer = MinecraftServer.getInstanceManager().createInstanceContainer()

    instanceContainer.chunkGenerator = FlatChunkGenerator()

    MinecraftServer.getGlobalEventHandler().addListener(PlayerLoginEvent::class.java) {
        with(it.player.inventory) {
            addItemStack(ApocalypseItems.KNIFE.item(ItemTier.V).getItemStack())
            addItemStack(ItemStack.of(Material.IRON_PICKAXE))
            addItemStack(ItemStack.of(Material.SANDSTONE, 64))
        }

        it.setSpawningInstance(instanceContainer)
        it.player.respawnPoint = Pos(0.0, 10.0, 0.0)
    }

    minecraftServer.start("0.0.0.0", 25565)
}
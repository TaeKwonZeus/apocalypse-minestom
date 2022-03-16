package com.github.bakane.events

import com.github.bakane.items.ApocalypseItems
import com.github.bakane.items.ItemTier
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.*
import net.minestom.server.event.player.PlayerBlockBreakEvent
import net.minestom.server.event.player.PlayerBlockInteractEvent
import net.minestom.server.event.player.PlayerBlockPlaceEvent
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.event.trait.PlayerEvent
import net.minestom.server.instance.InstanceContainer
import net.minestom.server.instance.block.Block
import net.minestom.server.inventory.Inventory
import net.minestom.server.inventory.InventoryType
import net.minestom.server.item.ItemStack
import net.minestom.server.item.Material

/**
 * [PlayerBlockPlaceEvent] handler.
 *
 * @param ctx The event object.
 * @author bakane
 */
fun onPlayerBlockPlace(ctx: PlayerBlockPlaceEvent) {
    // ctx.isCancelled = true
    // ctx.player.sendMessage(Component.text("Не ставь блоки долбаеб").color(NamedTextColor.RED))
}

/**
 * [PlayerBlockBreakEvent] handler.
 *
 * @param ctx The event object.
 * @author bakane
 */
fun onPlayerBlockBreak(ctx: PlayerBlockBreakEvent) {
    // ctx.isCancelled = true
    // ctx.player.sendMessage(Component.text("Не ломай блоки долбаеб").color(NamedTextColor.RED))
}

/**
 * [PlayerBlockInteractEvent] handler.
 *
 * @param ctx The event object.
 * @author bakane
 */
fun onPlayerBlockInteract(ctx: PlayerBlockInteractEvent) {
    if (ctx.block != Block.ANVIL) return

    val inventory = Inventory(InventoryType.ANVIL, "Апгрейд")
    ctx.player.openInventory(inventory)
}

/**
 * Gets a node with [PlayerEvent] handlers.
 *
 * @param instanceContainer The instance container, used to set the spawning instance.
 * @return A node with [PlayerEvent] handlers.
 * @author bakane
 */
fun getApocalypseEventNode(instanceContainer: InstanceContainer): EventNode<PlayerEvent> =
    EventNode.type("apocalypse-player-listener", EventFilter.PLAYER).apply {
        addListener(PlayerLoginEvent::class.java) {
            with(it.player.inventory) {
                addItemStack(ApocalypseItems.KNIFE.item(ItemTier.V).getItemStack())
                addItemStack(ApocalypseItems.UPGRADE_CORE.item(ItemTier.V).getItemStack())
                addItemStack(ItemStack.of(Material.ANVIL))
                addItemStack(ItemStack.of(Material.IRON_PICKAXE))
                addItemStack(ItemStack.of(Material.SANDSTONE, 64))
            }

            it.setSpawningInstance(instanceContainer)
            it.player.respawnPoint = Pos(0.0, 10.0, 0.0)
        }
        addListener(PlayerBlockPlaceEvent::class.java) { onPlayerBlockPlace(it) }
        addListener(PlayerBlockBreakEvent::class.java) { onPlayerBlockBreak(it) }
        addListener(PlayerBlockInteractEvent::class.java) { onPlayerBlockInteract(it) }
    }

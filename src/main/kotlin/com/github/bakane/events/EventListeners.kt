package com.github.bakane.events

import com.github.bakane.items.ApocalypseItems
import com.github.bakane.items.ItemTier
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.coordinate.Pos
import net.minestom.server.event.*
import net.minestom.server.event.inventory.InventoryClickEvent
import net.minestom.server.event.inventory.InventoryPreClickEvent
import net.minestom.server.event.player.PlayerBlockBreakEvent
import net.minestom.server.event.player.PlayerBlockInteractEvent
import net.minestom.server.event.player.PlayerBlockPlaceEvent
import net.minestom.server.event.player.PlayerLoginEvent
import net.minestom.server.event.trait.PlayerEvent
import net.minestom.server.instance.InstanceContainer
import net.minestom.server.instance.block.Block
import net.minestom.server.inventory.Inventory
import net.minestom.server.inventory.InventoryType
import net.minestom.server.inventory.type.AnvilInventory
import net.minestom.server.item.ItemStack
import net.minestom.server.item.Material
import net.minestom.server.tag.Tag

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
 * [InventoryClickEvent] handler.
 *
 * @param ctx The event object.
 * @author bakane
 */
fun onInventoryClick(ctx: InventoryClickEvent) {
    val inventory = ctx.inventory ?: return
    if (inventory.inventoryType != InventoryType.ANVIL) return

    val mainItem = ApocalypseItems.getItem(inventory.getItemStack(0)) ?: return
    val upgradeItem = ApocalypseItems.getItem(inventory.getItemStack(1)) ?: return

    if (upgradeItem.id != ApocalypseItems.UPGRADE_CORE.item(ItemTier.V).id) {
        ctx.player.sendMessage("Апгрейд недоступен")
        return
    }

    if (!mainItem.upgrade()) {
        ctx.player.sendMessage("Апгрейд недоступен")
        return
    }

    inventory.setItemStack(2, mainItem.getItemStack())
}

/**
 * Gets a node with [Event] handlers.
 *
 * @param instanceContainer The instance container, used to set the spawning instance.
 * @return A node with [Event] handlers.
 * @author bakane
 */
fun getApocalypseEventNode(instanceContainer: InstanceContainer): EventNode<Event> =
    EventNode.all("apocalypse-player-listener").apply {
        addListener(PlayerLoginEvent::class.java) {
            it.player.inventory.run {
                addItemStack(ApocalypseItems.KNIFE.item(ItemTier.I).getItemStack())
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
        addListener(InventoryClickEvent::class.java) { onInventoryClick(it) }
    }

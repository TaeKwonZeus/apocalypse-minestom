package com.github.bakane.items

import net.kyori.adventure.text.Component
import net.minestom.server.item.*
import net.minestom.server.item.attribute.ItemAttribute
import net.minestom.server.utils.NamespaceID

/**
 * An apocalypse item.
 *
 * @param displayName The name of an item.
 * @param material The material of an item (icon/block)
 * @param rarity The rarity of an item.
 * @param attributes The attributes of an item.
 * @author bakane
 */
open class ApocalypseItem(
    val displayName: String,
    val namespaceID: NamespaceID,
    private val material: Material,
    protected var rarity: ItemRarity,
    protected val attributes: MutableList<ItemAttribute>
) {
    /**
     * Gets the [ItemStack] of an item.
     *
     * @return An item's [ItemStack].
     */
    open fun getItemStack() = ItemStack.builder(material)
        .displayName(Component.text(displayName).color(rarity.getDisplayName().color()))
        .lore(rarity.getDisplayName())
        .meta { metaBuilder: ItemMetaBuilder -> metaBuilder.attributes(attributes) }
        .build()

    /**
     * Upgrades an item.
     *
     * @return Whether an item has been upgraded or not.
     */
    open fun upgrade(): Boolean {
        val nextRarity = rarity.getNextRarity() ?: return false

        rarity = nextRarity

        return true
    }
}
package com.github.bakane.items

import net.kyori.adventure.text.Component
import net.minestom.server.item.*
import net.minestom.server.item.attribute.ItemAttribute

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
    private val displayName: String,
    private val material: Material,
    private val rarity: ItemRarity,
    private val attributes: List<ItemAttribute>
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
     * Gets the upgraded item.
     *
     * @return An upgraded item with improved stats.
     */
    open fun getUpgradedItem(): ApocalypseItem? {
        val nextRarity = rarity.getNextRarity() ?: return null

        return ApocalypseItem(displayName, material, nextRarity, attributes)
    }
}
package com.github.bakane.items

import net.kyori.adventure.text.Component
import net.minestom.server.item.*
import net.minestom.server.item.attribute.ItemAttribute

/**
 * An apocalypse item.
 *
 * @author bakane
 */
abstract class ApocalypseItem(
    val displayName: String,
    val material: Material,
    val rarity: ItemRarity,
    val attributes: List<ItemAttribute>
) {
    open fun getItemStack() = ItemStack.builder(material)
        .displayName(Component.text(displayName).color(rarity.getDisplayName().color()))
        .lore(rarity.getDisplayName())
        .meta { metaBuilder: ItemMetaBuilder -> metaBuilder.attributes(attributes) }
        .build()

    abstract fun getUpgradedItem(): ApocalypseItem?
}
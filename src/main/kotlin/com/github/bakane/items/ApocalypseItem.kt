package com.github.bakane.items

import net.kyori.adventure.text.Component
import net.minestom.server.item.*
import net.minestom.server.item.attribute.ItemAttribute
import net.minestom.server.tag.Tag
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
    private val displayName: String,
    val namespaceID: NamespaceID,
    private val material: Material,
    protected val rarity: ItemRarity,
    protected val attributes: MutableList<ItemAttribute>,
    protected var tier: ItemTier = ItemTier.I,
    ) {
    /**
     * Gets the [ItemStack] of an item.
     *
     * @return An item's [ItemStack].
     */
    open fun getItemStack() = ItemStack.builder(material)
        .displayName(Component.text(displayName).color(rarity.getComponent().color()))
        .lore(rarity.getComponent(), tier.getComponent())
        .meta { metaBuilder: ItemMetaBuilder -> metaBuilder.attributes(attributes).set(Tag.String("tier"), tier.name) }
        .build()

    /**
     * Upgrades an item.
     *
     * @return Whether an item has been upgraded or not.
     */
    open fun upgrade(): Boolean {
        val nextTier = tier.getNextTier() ?: return false

        tier = nextTier

        return true
    }
}
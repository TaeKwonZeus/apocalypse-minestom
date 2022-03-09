package com.github.bakane.items

/**
 * An apocalypse item.
 *
 * @author bakane
 */
interface ApocalypseItem {
    val rarity: ItemRarity

    /**
     * Returns an upgraded item.
     *
     * @return An upgraded item.
     * @throws IllegalStateException Item cannot be upgraded or already has max rarity.
     */
    fun getUpgradedItem(): ApocalypseItem
}
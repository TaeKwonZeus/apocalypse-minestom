package com.github.bakane.items

import com.github.jenya705.cmscore.module.item.CustomItem

/**
 * An apocalypse item.
 *
 * @author bakane
 */
interface ApocalypseItem : CustomItem {
    /**
     * An item's rarity.
     */
    var rarity: ItemRarity

    /**
     * Upgrades an item to another rarity.
     *
     * @param finalRarity A rarity an item is upgraded to.
     */
    fun upgrade(finalRarity: ItemRarity)
}
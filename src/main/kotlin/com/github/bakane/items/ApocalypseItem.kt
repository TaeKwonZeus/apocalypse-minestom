package com.github.bakane.items

import com.github.jenya705.cmscore.module.item.CustomItem

/**
 * An apocalypse item.
 *
 * @param defaultRarity An item's default rarity.
 * @author bakane
 */
abstract class ApocalypseItem(defaultRarity: ItemRarity = ItemRarity.COMMON): CustomItem {
    /**
     * An item's rarity.
     */
    var rarity: ItemRarity = defaultRarity
        private set

    /**
     * Upgrades an item to another rarity.
     *
     * @param finalRarity A rarity an item is upgraded to.
     */
    open fun upgrade(finalRarity: ItemRarity? = null) {
        if (finalRarity == null) {
            rarity = when (rarity) {
                ItemRarity.COMMON -> ItemRarity.UNCOMMON
                ItemRarity.UNCOMMON -> ItemRarity.RARE
                ItemRarity.RARE -> ItemRarity.EPIC
                ItemRarity.EPIC -> ItemRarity.MYTHIC
                ItemRarity.MYTHIC -> ItemRarity.LEGENDARY
                ItemRarity.LEGENDARY -> throw Exception("Can't upgrade, rarity already at legendary")
            }
            return
        }

        if (finalRarity < rarity) throw IllegalArgumentException("Final rarity is more than current rarity")

        rarity = finalRarity
    }
}
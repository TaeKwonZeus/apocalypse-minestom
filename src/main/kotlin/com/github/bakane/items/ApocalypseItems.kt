package com.github.bakane.items

import net.minestom.server.item.ItemStack

enum class ApocalypseItems(val item: (rarity: ItemRarity) -> ApocalypseItem) {
    TEST_ITEM({ TestItem(it) });

    fun getItem(displayName: String): ((rarity: ItemRarity) -> ApocalypseItem)? {
        for (item in values()) {
            if (item.item(ItemRarity.COMMON).displayName == displayName)
                return item.item
        }

        return null
    }

    fun getItem(itemStack: ItemStack): ApocalypseItem? = null
}
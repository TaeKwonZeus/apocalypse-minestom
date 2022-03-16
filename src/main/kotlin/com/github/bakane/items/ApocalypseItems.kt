package com.github.bakane.items

import com.github.bakane.items.upgrades.UpgradeCore
import com.github.bakane.items.weapons.Knife
import net.minestom.server.item.ItemStack
import net.minestom.server.tag.Tag

/**
 * All apocalypse items and methods for accessing them.
 *
 * @author bakane
 */
enum class ApocalypseItems(val item: (tier: ItemTier) -> ApocalypseItem) {
    KNIFE({ Knife(it) }), UPGRADE_CORE({ UpgradeCore() });

    companion object {
        /**
         * A map of IDs to corresponding [ApocalypseItem] constructor functions.
         */
        private val items = values().map { it.item }.associateBy { it(ItemTier.I).id }

        /**
         * Gets an item with the id and [ItemTier] from [itemStack] tags.
         *
         * @param itemStack An item stack to get an item from.
         * @return An item corresponding to [itemStack].
         */
        fun getItem(itemStack: ItemStack): ApocalypseItem? {
            val id = itemStack.getTag(Tag.String("id"))
            val tier = itemStack.getTag(Tag.String("tier"))

            if (id == null || tier == null) return null

            return items[id]?.invoke(ItemTier.valueOf(tier))
        }
    }
}
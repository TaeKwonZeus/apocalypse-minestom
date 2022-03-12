package com.github.bakane.items.weapons

import com.github.bakane.items.ItemRarity
import com.github.bakane.items.ItemTier
import net.minestom.server.item.Material

/**
 * A knife. Has a rarity of [ItemRarity.RARE]. Its damage per tier is 1.5.
 *
 * @author bakane
 */
class Knife(tier: ItemTier = ItemTier.I) : Weapon(
    "Нож",
    "knife",
    Material.IRON_SWORD,
    ItemRarity.RARE,
    1.5,
    tier
)
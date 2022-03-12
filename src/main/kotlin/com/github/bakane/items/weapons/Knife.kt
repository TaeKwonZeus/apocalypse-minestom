package com.github.bakane.items.weapons

import com.github.bakane.items.ItemRarity
import com.github.bakane.items.ItemTier
import net.minestom.server.item.Material
import net.minestom.server.utils.NamespaceID

class Knife(tier: ItemTier = ItemTier.I) : Weapon(
    "Нож",
    "knife",
    Material.IRON_SWORD,
    ItemRarity.RARE,
    1.0,
    tier
)
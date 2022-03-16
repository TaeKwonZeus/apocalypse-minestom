package com.github.bakane.items.upgrades

import com.github.bakane.items.ApocalypseItem
import com.github.bakane.items.ItemRarity
import com.github.bakane.items.ItemTier
import net.minestom.server.item.Material

/**
 * An upgrade core. Can be used with an anvil to upgrade the tier of an item. Cannot be upgraded.
 *
 * @author bakane
 */
class UpgradeCore : ApocalypseItem(
    "Ядро Апгрейда",
    "upgrade_core",
    Material.CONDUIT,
    ItemRarity.LEGENDARY,
    mutableListOf(),
    ItemTier.V
) {
    override fun upgrade() = false
}
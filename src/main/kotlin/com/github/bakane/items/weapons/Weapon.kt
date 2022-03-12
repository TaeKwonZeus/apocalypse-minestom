package com.github.bakane.items.weapons

import com.github.bakane.items.ApocalypseItem
import com.github.bakane.items.ItemRarity
import com.github.bakane.items.ItemTier
import net.minestom.server.attribute.Attribute
import net.minestom.server.attribute.AttributeOperation
import net.minestom.server.item.Material
import net.minestom.server.item.attribute.AttributeSlot
import net.minestom.server.item.attribute.ItemAttribute
import net.minestom.server.utils.NamespaceID
import java.util.*

/**
 * A base class for weapons. Right now supports basic damage upgrades per tier.
 *
 * @param displayName The name of an item.
 * @param id The unique identifier of an item.
 * @param material The material of an item (icon/block)
 * @param rarity The rarity of an item.
 * @param damagePerTier An item's damage for each tier, e.g. for tier [ItemTier.II] the damage would be [damagePerTier] * 2.
 * @param tier The tier of an item.
 * @author bakane
 */
abstract class Weapon(
    displayName: String,
    id: String,
    material: Material,
    rarity: ItemRarity,
    private val damagePerTier: Double,
    tier: ItemTier
) : ApocalypseItem(
    displayName,
    id,
    material,
    rarity,
    mutableListOf(
        ItemAttribute(
            UUID.randomUUID(),
            "damage",
            Attribute.ATTACK_DAMAGE,
            AttributeOperation.ADDITION,
            (tier.ordinal + 1) * damagePerTier,
            AttributeSlot.MAINHAND
        )
    ),
    tier
) {
    override fun upgrade(): Boolean {
        val res = super.upgrade()
        if (!res) return false

        val attribute = attributes[0]
        attributes[0] = ItemAttribute(
            attribute.uuid,
            attribute.name,
            attribute.attribute,
            attribute.operation,
            (tier.ordinal + 1) * damagePerTier,
            attribute.slot
        )

        return true
    }
}
package com.github.bakane.items

import net.minestom.server.attribute.Attribute
import net.minestom.server.attribute.AttributeOperation
import net.minestom.server.item.Material
import net.minestom.server.item.attribute.AttributeSlot
import net.minestom.server.item.attribute.ItemAttribute
import net.minestom.server.utils.NamespaceID
import java.util.*

class TestItem(tier: ItemTier = ItemTier.I) : ApocalypseItem(
    "Нож",
    NamespaceID.from("apocalypse:knife"),
    Material.IRON_SWORD,
    ItemRarity.RARE,
    mutableListOf(
        ItemAttribute(
            UUID.randomUUID(),
            "Урон",
            Attribute.ATTACK_DAMAGE,
            AttributeOperation.ADDITION,
            tier.ordinal + 1.0,
            AttributeSlot.MAINHAND
        )
    )
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
            tier.ordinal + 1.0,
            attribute.slot
        )

        return true
    }
}
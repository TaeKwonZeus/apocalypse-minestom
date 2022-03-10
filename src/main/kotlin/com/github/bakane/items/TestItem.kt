package com.github.bakane.items

import net.minestom.server.attribute.Attribute
import net.minestom.server.attribute.AttributeOperation
import net.minestom.server.item.Material
import net.minestom.server.item.attribute.AttributeSlot
import net.minestom.server.item.attribute.ItemAttribute
import java.util.*

class TestItem : ApocalypseItem(
    "Нож",
    Material.IRON_SWORD,
    ItemRarity.RARE,
    listOf(
        ItemAttribute(
            UUID.randomUUID(),
            "Урон",
            Attribute.ATTACK_DAMAGE,
            AttributeOperation.ADDITION,
            2.0,
            AttributeSlot.MAINHAND
        )
    )
)
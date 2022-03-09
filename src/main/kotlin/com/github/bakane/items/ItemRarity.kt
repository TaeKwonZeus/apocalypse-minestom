package com.github.bakane.items

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor

/**
 * Item rarity from common to legendary.
 *
 * @author bakane
 */
enum class ItemRarity {
    COMMON, UNCOMMON, RARE, EPIC, MYTHIC, LEGENDARY;

    /**
     * Gets the [Component] of a rarity.
     */
    val displayName
        get() = when (this) {
            COMMON -> Component.text("Обычный").color(NamedTextColor.GRAY)
            UNCOMMON -> Component.text("Необычный").color(NamedTextColor.GREEN)
            RARE -> Component.text("Редкий").color(NamedTextColor.BLUE)
            EPIC -> Component.text("Эпический").color(NamedTextColor.DARK_PURPLE)
            MYTHIC -> Component.text("Мифический").color(NamedTextColor.DARK_RED)
            LEGENDARY -> Component.text("Легендарный").color(NamedTextColor.GOLD)
        }
}
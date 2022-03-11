package com.github.bakane.items

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration

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
    fun getComponent() = when (this) {
        COMMON -> Component.text("ОБЫЧНЫЙ").color(NamedTextColor.WHITE)
        UNCOMMON -> Component.text("НЕОБЫЧНЫЙ").color(NamedTextColor.GREEN)
        RARE -> Component.text("РЕДКИЙ").color(NamedTextColor.BLUE)
        EPIC -> Component.text("ЭПИЧЕСКИЙ").color(NamedTextColor.DARK_PURPLE)
        MYTHIC -> Component.text("МИФИЧЕСКИЙ").color(NamedTextColor.DARK_RED)
        LEGENDARY -> Component.text("ЛЕГЕНДАРНЫЙ").color(NamedTextColor.GOLD)
    }.decorate(TextDecoration.BOLD)
}
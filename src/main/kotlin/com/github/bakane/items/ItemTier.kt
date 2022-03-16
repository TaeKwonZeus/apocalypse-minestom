package com.github.bakane.items

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration

/**
 * Item tiers from I to V.
 *
 * @author bakane
 */
enum class ItemTier {
    I, II, III, IV, V;

    /**
     * Gets the next tier. Returns null if already tier V.
     *
     * @return The next tier or null.
     */
    fun getNextTier() = when (this) {
        I -> II
        II -> III
        III -> IV
        IV -> V
        V -> null
    }

    fun getComponent() = Component.text("Уровень ${this.name}")
        .color(NamedTextColor.LIGHT_PURPLE)
        .decoration(TextDecoration.ITALIC, false)
}
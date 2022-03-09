package com.github.bakane.items

import net.minestom.server.utils.NamespaceID

/**
 * An item container.
 *
 * @author bakane
 */
object ItemContainer {
    /**
     * Stores all items.
     */
    val items = setOf<ApocalypseItem>()

    /**
     * Gets an item of the given type [T].
     *
     * @param T The type of item to find.
     * @return An item of the given type.
     */
    inline fun <reified T : ApocalypseItem> withType(): T? = items.firstOrNull { it is T } as T?

    /**
     * Gets an item with the given [namespace] then casts it to the given type [T].
     *
     * @param T The type to cast the item to.
     * @param namespace The namespace of item to find.
     * @return An item with the given namespace.
     */
    inline fun <reified T : ApocalypseItem> getByNamespace(namespace: String): T? =
        items.firstOrNull { it.key() == NamespaceID.from(namespace) } as T?

    /**
     * Registers all [items].
     */
    fun registerAll() {
        for (item in items) {
            item.fastRegister()
        }
    }
}
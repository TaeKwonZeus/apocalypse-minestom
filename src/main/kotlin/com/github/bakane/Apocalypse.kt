package com.github.bakane

import com.github.bakane.items.ItemContainer
import com.github.jenya705.cmscore.loader.CoreServerLoader

fun main(args: Array<String>) {
    ItemContainer.registerAll()

    CoreServerLoader.main(args)
}
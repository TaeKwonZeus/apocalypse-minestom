package com.github.bakane

import com.github.bakane.events.getApocalypseEventNode
import com.github.bakane.generators.FlatChunkGenerator
import net.minestom.server.MinecraftServer

fun main() {
    val minecraftServer = MinecraftServer.init()

    val instanceContainer = MinecraftServer.getInstanceManager().createInstanceContainer()

    instanceContainer.chunkGenerator = FlatChunkGenerator()

    MinecraftServer.getGlobalEventHandler().addChild(getApocalypseEventNode(instanceContainer))

    minecraftServer.start("0.0.0.0", 25565)
}
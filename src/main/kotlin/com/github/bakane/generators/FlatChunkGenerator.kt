package com.github.bakane.generators

import net.minestom.server.instance.Chunk
import net.minestom.server.instance.ChunkGenerator
import net.minestom.server.instance.ChunkPopulator
import net.minestom.server.instance.batch.ChunkBatch
import net.minestom.server.instance.block.Block

class FlatChunkGenerator : ChunkGenerator {
    override fun generateChunkData(batch: ChunkBatch, chunkX: Int, chunkZ: Int) {
        for (x in 0..Chunk.CHUNK_SIZE_X)
            for (z in 0..Chunk.CHUNK_SIZE_Z)
                batch.setBlock(x, 0, z, Block.SANDSTONE)
    }

    override fun getPopulators(): MutableList<ChunkPopulator>? = null
}
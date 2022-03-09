package com.github.bakane

import net.minestom.server.instance.Chunk
import net.minestom.server.instance.ChunkGenerator
import net.minestom.server.instance.ChunkPopulator
import net.minestom.server.instance.batch.ChunkBatch
import net.minestom.server.instance.block.Block

class FlatWorldGenerator : ChunkGenerator {
    override fun generateChunkData(batch: ChunkBatch, chunkX: Int, chunkZ: Int) {
        for (x in 0..Chunk.CHUNK_SIZE_X) {
            for (z in 0..Chunk.CHUNK_SIZE_Z) {
                for (y in 0..40) {
                    batch.setBlock(x, y, z, Block.SANDSTONE);
                }
            }
        }
    }

    override fun getPopulators(): MutableList<ChunkPopulator>? = null
}
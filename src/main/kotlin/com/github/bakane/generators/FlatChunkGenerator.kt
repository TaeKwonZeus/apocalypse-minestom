package com.github.bakane.generators

import net.minestom.server.instance.Chunk
import net.minestom.server.instance.ChunkGenerator
import net.minestom.server.instance.ChunkPopulator
import net.minestom.server.instance.batch.ChunkBatch
import net.minestom.server.instance.block.Block

/**
 * A flat world chunk generator. Consists of:
 * 4 layers of [Block.SANDSTONE];
 * 3 layers of [Block.STONE];
 * 1 layer of [Block.BEDROCK].
 *
 * @author bakane
 */
class FlatChunkGenerator : ChunkGenerator {
    override fun generateChunkData(batch: ChunkBatch, chunkX: Int, chunkZ: Int) {
        val blocks = listOf(
            Block.BEDROCK,
            Block.STONE,
            Block.STONE,
            Block.STONE,
            Block.SANDSTONE,
            Block.SANDSTONE,
            Block.SANDSTONE,
            Block.SANDSTONE
        )

        for (x in 0..Chunk.CHUNK_SIZE_X) {
            for (z in 0..Chunk.CHUNK_SIZE_Z) {
                for (i in blocks.indices) {
                    batch.setBlock(x, i, z, blocks[i])
                }
            }
        }
    }

    override fun getPopulators(): MutableList<ChunkPopulator>? = null
}
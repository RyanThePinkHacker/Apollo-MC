package com.ryangar46.apollo.registry.tag;

import com.ryangar46.apollo.Apollo;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ApolloBlockTags {
    public static final TagKey<Block> FLUID_PIPE_CONNECTABLE_BLOCKS = register("fluid_pipe_connectable_blocks");
    public static final TagKey<Block> LAUNCHPADS = register("launchpads");
    public static final TagKey<Block> LUNAR_ORE_REPLACEABLES = register("lunar_ore_replaceables");
    
    private static TagKey<Block> register(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier(Apollo.MOD_ID, id));
    }
}
package com.lothrazar.examplemod;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, ModMain.MODID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, ModMain.MODID);
  public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ModMain.MODID);
  //  public static final DeferredHolder<Item, Item> OVERWORLD_KEY = ITEMS.register("whatever", () -> new Item(new Item.Properties()));
  //  public static final DeferredHolder<Block, Block> STUFF_BLOCK = BLOCKS.register("stuff", () -> new Block(Block.Properties.of()));
  //  public static final DeferredHolder<Item, Item> STUFF_ITEM = ITEMS.register("stuff", () -> new BlockItem(STUFF_BLOCK.get(), new Item.Properties()));
}

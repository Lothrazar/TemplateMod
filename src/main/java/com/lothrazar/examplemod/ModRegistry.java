package com.lothrazar.examplemod;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MODID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModMain.MODID);
  public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ModMain.MODID);
  //  public static final RegistryObject<Item> OVERWORLD_KEY = ITEMS.register("whatever", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
  //  public static final RegistryObject<Block> STUFF_BLOCK = BLOCKS.register("stuff", () -> new Block(Block.Properties.of(Material.STONE)));
  //  public static final RegistryObject<Item> STUFF_ITEM = ITEMS.register("stuff", () -> new BlockItem(STUFF_BLOCK.get(), new Item.Properties()));
  //  @SubscribeEvent
  //  public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
  //    // IForgeRegistry<ContainerType<?>> r = event.getRegistry();
  //  }
}

package com.lothrazar.examplemod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistry {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MODID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModMain.MODID);
  public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ModMain.MODID);
  //  public static final RegistryObject<Item> OVERWORLD_KEY = ITEMS.register("whatever", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
  //  @SubscribeEvent
  //  public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
  //    // IForgeRegistry<ContainerType<?>> r = event.getRegistry();
  //  }
}

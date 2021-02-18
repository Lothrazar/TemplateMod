package com.lothrazar.examplemod;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleRegistry {
  //change Object to your Block/Item/whatever 
  //  @ObjectHolder(ExampleMod.MODID + ":anything")
  //  public static Item anything;

  @SubscribeEvent
  public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
    //IForgeRegistry<Block> r = event.getRegistry();
    //    r.register(  );
  }

  @SubscribeEvent
  public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
    //   IForgeRegistry<TileEntityType<?>> r = event.getRegistry();
  }

  @SubscribeEvent
  public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
    // IForgeRegistry<ContainerType<?>> r = event.getRegistry();
  }

  @SubscribeEvent
  public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
    //  IForgeRegistry<Item> r = event.getRegistry();
    //  r.register(new ItemTest(new Item.Properties().maxStackSize(1)));
  }

  @SubscribeEvent
  public static void onEnchantRegister(final RegistryEvent.Register<Enchantment> event) {
    //  IForgeRegistry<Enchantment> r = event.getRegistry();
  }

  @SubscribeEvent
  public static void registerEntity(RegistryEvent.Register<EntityType<?>> e) {
    // IForgeRegistry<EntityType<?>> r = e.getRegistry();
  }

  @SubscribeEvent
  public static void onPotEffectRegistry(RegistryEvent.Register<Effect> event) {
    //  IForgeRegistry<Effect> r = event.getRegistry();
  }

  @SubscribeEvent
  public static void onPotRegistry(RegistryEvent.Register<Potion> event) {
    //   IForgeRegistry<Potion> r = event.getRegistry();
  }

  @SubscribeEvent
  public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
    //  IForgeRegistry<SoundEvent> r = event.getRegistry();
  }
}

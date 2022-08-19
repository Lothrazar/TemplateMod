package com.lothrazar.examplemod;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ModMain.MODID)
public class ModMain {

  public static final String MODID = "examplemod";
  public static final Logger LOGGER = LogManager.getLogger();

  public ModMain() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    ModRegistry.BLOCKS.register(eventBus);
    ModRegistry.ITEMS.register(eventBus);
    ModRegistry.BLOCK_ENTITIES.register(eventBus);
    ConfigManager.setup();
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
  }

  private void setup(final FMLCommonSetupEvent event) {
    //    MinecraftForge.EVENT_BUS.register(new WhateverEvents()); 
  }

  private void setupClient(final FMLClientSetupEvent event) {
    //for client side only setup
  }
}

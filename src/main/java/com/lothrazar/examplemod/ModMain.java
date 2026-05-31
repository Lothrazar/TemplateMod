package com.lothrazar.examplemod;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(ModMain.MODID)
public class ModMain {

  public static final String MODID = "examplemod";
  public static final Logger LOGGER = LogManager.getLogger();

  public ModMain(IEventBus eventBus, ModContainer modContainer) {
    ModRegistry.BLOCKS.register(eventBus);
    ModRegistry.ITEMS.register(eventBus);
    ModRegistry.TILE_ENTITIES.register(eventBus);
    modContainer.registerConfig(ModConfig.Type.COMMON, ConfigManager.CONFIG);
    eventBus.addListener(this::setup);
    eventBus.addListener(this::setupClient);
  }

  private void setup(final FMLCommonSetupEvent event) {
    //    NeoForge.EVENT_BUS.register(new WhateverEvents());
  }

  private void setupClient(final FMLClientSetupEvent event) {
    //for client side only setup
  }
}

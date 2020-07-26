package com.lothrazar.examplemod.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber
public class CommonProxy {

  public EntityPlayer getClientPlayer() {
    return null;
  }

  public void preInit(FMLPreInitializationEvent event) {}

  public void init(FMLInitializationEvent event) {}
}

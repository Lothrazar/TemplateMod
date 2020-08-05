package com.lothrazar.examplemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lothrazar.examplemod.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MODID, certificateFingerprint = ExampleMod.certificateFingerprint)
public class ExampleMod {

  public Logger logger;
  public static final String MODID = "examplemod";
  public static final String certificateFingerprint = "@FINGERPRINT@";
  public static final Logger LOGGER = LogManager.getLogger();
  @Instance(ExampleMod.MODID)
  public ExampleMod instance;
  @SidedProxy(clientSide = "com.lothrazar.examplemod.proxy.ClientProxy", serverSide = "com.lothrazar.examplemod.proxy.CommonProxy")
  public static CommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger = event.getModLog();
    MinecraftForge.EVENT_BUS.register(new ExampleEvents());
    proxy.preInit(event);
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
    proxy.init(event);
  }
}

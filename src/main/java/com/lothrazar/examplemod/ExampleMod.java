package com.lothrazar.examplemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lothrazar.examplemod.config.ConfigClientManager;
import com.lothrazar.examplemod.config.ConfigManager;
import com.lothrazar.examplemod.event.ItemEvents;
import com.lothrazar.examplemod.setup.ClientProxy;
import com.lothrazar.examplemod.setup.IProxy;
import com.lothrazar.examplemod.setup.ServerProxy;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// TODO: The value here should match an entry in the META-INF/mods.toml file
// TODO: Also search and replace it in build.gradle
@Mod(ExampleMod.MODID)
public class ExampleMod {

  public static final String MODID = "examplemod";
  public static final IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
  public static final Logger LOGGER = LogManager.getLogger();

  public ExampleMod() {
    ConfigManager.setup();
    ConfigClientManager.setup();
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    SheepEntity y;
  }

  private void setup(final FMLCommonSetupEvent event) {
    //now all blocks/items exist 
    proxy.setup();
    MinecraftForge.EVENT_BUS.register(new ItemEvents());
    //  MinecraftForge.EVENT_BUS.register(new WorldGenEvents());
  }
}

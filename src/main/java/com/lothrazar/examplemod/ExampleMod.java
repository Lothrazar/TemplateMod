package com.lothrazar.examplemod;
import com.lothrazar.examplemod.setup.ClientProxy;
import com.lothrazar.examplemod.setup.ConfigHandler;
import com.lothrazar.examplemod.setup.IProxy;
import com.lothrazar.examplemod.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("examplemod")
public class ExampleMod {

  private String certificateFingerprint = "@FINGERPRINT@";
  public static final IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
  public static final String MODID = "examplemod";
  private static final Logger LOGGER = LogManager.getLogger();

  public ExampleMod() {
    // Register the setup method for modloading
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    //only for server starting
    MinecraftForge.EVENT_BUS.register(this);

    ConfigHandler.loadConfig(ConfigHandler.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + ".toml"));
  }

  private void setup(final FMLCommonSetupEvent event) {
    // some preinit code
    LOGGER.info("HELLO FROM PREINIT");
    TileEntity bob;
  }

  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onServerStarting(FMLServerStartingEvent event) {
    // do something when the server starts
    LOGGER.info("HELLO from server starting");
  }

  // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
  // Event bus for receiving Registry Events)
  @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class RegistryEvents {

    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
      // register a new block here
      LOGGER.info("HELLO from Register Block");
//      event.getRegistry().register(new BlockRequest());
    }


    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> event) {
//      Item.Properties properties = new Item.Properties().group(SsnRegistry.itemGroup);
//      event.getRegistry().register(new BlockItem(SsnRegistry.master, properties).setRegistryName("master"));
    }
  }

  @SubscribeEvent
  public static void onFingerprintViolation(FMLFingerprintViolationEvent event) {
    // https://tutorials.darkhax.net/tutorials/jar_signing/
    String source = (event.getSource() == null) ? "" : event.getSource().getName() + " ";
    String msg = MODID + "Invalid fingerprint detected! The file " + source + "may have been tampered with. This version will NOT be supported by the author!";
    System.out.println(msg);
  }
}

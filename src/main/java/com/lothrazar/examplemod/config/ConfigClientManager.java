package com.lothrazar.examplemod.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.lothrazar.examplemod.ExampleMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.fml.loading.FMLPaths;

public class ConfigClientManager {

  private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
  private static ForgeConfigSpec CFG;
  public static BooleanValue ATTEST;
  static {
    initConfig();
  }

  private static void initConfig() {
    BUILDER.comment("Client settings").push(ExampleMod.MODID);
    String category = "clientstuff.";
    ATTEST = BUILDER.comment("Testing client-config this currently prints an accesstransformer.cfg test in log for examplemod").define(category + "attest", true);
    BUILDER.pop();
    CFG = BUILDER.build();
  }

  public static void setup() {
    final CommentedFileConfig configDataClient = CommentedFileConfig.builder(FMLPaths.CONFIGDIR.get().resolve(ExampleMod.MODID + "-client.toml"))
        .sync()
        .autosave()
        .writingMode(WritingMode.REPLACE)
        .build();
    configDataClient.load();
    CFG.setConfig(configDataClient);
  }
}

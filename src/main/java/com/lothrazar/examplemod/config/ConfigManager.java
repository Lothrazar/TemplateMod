package com.lothrazar.examplemod.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.lothrazar.examplemod.ExampleMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.fml.loading.FMLPaths;

public class ConfigManager {

  private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
  private static ForgeConfigSpec CFG;
  public static BooleanValue TESTING;
  static {
    initConfig();
  }

  private static void initConfig() {
    BUILDER.comment("General settings").push(ExampleMod.MODID);
    String category = "testing.";
    TESTING = BUILDER.comment("Testing mixin spam log if holding filled map").define(category + "serverTest", true);
    BUILDER.pop();
    CFG = BUILDER.build();
  }

  public static void setup() {
    final CommentedFileConfig configData = CommentedFileConfig.builder(FMLPaths.CONFIGDIR.get().resolve(ExampleMod.MODID + ".toml"))
        .sync()
        .autosave()
        .writingMode(WritingMode.REPLACE)
        .build();
    configData.load();
    CFG.setConfig(configData);
  }
}

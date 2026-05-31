package com.lothrazar.examplemod;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;

public class ConfigManager  {

  static ModConfigSpec CONFIG;
  public static BooleanValue TESTING;
  static {
    final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    BUILDER.comment("Mod settings").push(ModMain.MODID);
    TESTING = BUILDER.comment("Testing boolean config").define("doesNothing", true);
    BUILDER.pop(); // one pop for every push
    CONFIG = BUILDER.build();
  }

}

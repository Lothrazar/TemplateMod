package com.lothrazar.examplemod.setup;

import com.lothrazar.examplemod.ExampleMod;
import com.lothrazar.examplemod.config.ConfigClientManager;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

  @Override
  public World getClientWorld() {
    return Minecraft.getInstance().world;
  }

  @Override
  public void setup() {
    if (ConfigClientManager.ATTEST.get()) {
      float test = Blocks.BEDROCK.getDefaultState().hardness;
      ExampleMod.LOGGER.info("accesstransformer.cfg test bedrock hardness = " + test);
    }
  }

  @Override
  public PlayerEntity getClientPlayer() {
    return Minecraft.getInstance().player;
  }
}

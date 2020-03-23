package com.lothrazar.examplemod.setup;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ServerProxy implements IProxy {

  @Override
  public World getClientWorld() {
    throw new IllegalStateException("Client side only code on the server");
  }

  @Override
  public void setup() {}

  @Override
  public PlayerEntity getClientPlayer() {
    return null;
  }
}

package com.lothrazar.examplemod.setup;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface IProxy {

  void setup();

  PlayerEntity getClientPlayer();

  World getClientWorld();
}

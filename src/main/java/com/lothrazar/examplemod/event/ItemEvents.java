package com.lothrazar.examplemod.event;

import com.lothrazar.examplemod.ExampleMod;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemEvents {

  /**
   * 1. dont let baby zombies spawn
   * 
   * 2.
   */
  @SubscribeEvent
  public void onLivingSpawnEvent(LivingSpawnEvent event) {
    //    ExampleMod.LOGGER.info(event.getEntity() + " spawn ");
    LivingEntity living = event.getEntityLiving();
    if (!(living instanceof PlayerEntity)) {
      //EquipmentSlotType
      for (EquipmentSlotType slot : EquipmentSlotType.values()) {
        //first check for exceptions 
        if (slot == EquipmentSlotType.MAINHAND) {
          //wait, is it a bow
          if (living.getType() == EntityType.SKELETON) {
            //allowed
            return;
          }
        }
        //nuke it
        if (!living.getItemStackFromSlot(slot).isEmpty()) {
          // 
          ExampleMod.LOGGER.info(living + " NUKE  from" + slot + "::" + living.getItemStackFromSlot(slot));
          living.setItemStackToSlot(slot, ItemStack.EMPTY);
        }
      }
    }
  }

  @SubscribeEvent
  public void onLivingDropsEvent(LivingDropsEvent event) {
    EntityJoinWorldEvent test;
    ExampleMod.LOGGER.info(event.getEntity() + " drops" + event.getDrops().size());
  }

  @SubscribeEvent
  public void onLivingDeathEvent(LivingDeathEvent event) {
    LivingEntity liv = event.getEntityLiving();
    ExampleMod.LOGGER.info("death of " + liv);
  }

  @SubscribeEvent
  public void onRightClickBlock(RightClickBlock event) {
    if (!event.getItemStack().isEmpty()) {
      return;
    }
    World world = event.getWorld();
    BlockPos p = event.getPos();
    BlockState bs = world.getBlockState(p);
  }

  @SubscribeEvent
  public void onEntityInteractEvent(EntityInteract event) {}

  @SubscribeEvent
  public void onHit(PlayerInteractEvent.LeftClickBlock event) {
    PlayerEntity player = event.getPlayer();
    ItemStack held = player.getHeldItem(event.getHand());
    if (held.isEmpty()) {
      return;
    }
    World world = player.getEntityWorld();
  }
}

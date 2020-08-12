package com.lothrazar.examplemod;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.Entity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mixin(FilledMapItem.class)
public class FilledMapItemRefreshMixin {

  @Inject(at = @At("HEAD"), method = "inventoryTick(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;I;Z)V")
  public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected,
      CallbackInfo info) {
    //TESTING MIXINS.  
    //when holding map and updating it should print
    // but this does not print
    //break points do not hit
    System.out.println("map inventory tick mixin");
  }
}

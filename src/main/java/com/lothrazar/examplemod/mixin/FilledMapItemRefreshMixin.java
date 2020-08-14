package com.lothrazar.examplemod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.entity.Entity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@Mixin(FilledMapItem.class)
public class FilledMapItemRefreshMixin {

  // put a map in your inventory, this will trigger every time inventoryTick is triggered 
  @Inject(at = @At("HEAD"), method = "inventoryTick(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;IZ)V")
  public void inventoryTickMixin(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected, CallbackInfo info) {
    FilledMapItem map = (FilledMapItem) (Object) this;
    //proof is not null
    Item test = map.asItem();
    System.out.println("TEST");
  }
}

package com.lothrazar.examplemod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemTest extends Item {

  public ItemTest(Properties properties) {
    super(properties);
    //    this.onItemUse(context)
  }

  @Override
  public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    //
    return super.onItemRightClick(worldIn, playerIn, handIn);
  }
}

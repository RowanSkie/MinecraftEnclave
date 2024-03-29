package net.mineclave.fabric.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DebugItem extends Item
{
    public DebugItem(final Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity playerEntity, final Hand hand)
    {
        playerEntity.playSound(SoundEvents.BLOCK_CHEST_OPEN, 1.0F, 1.0F);
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }
}
package com.aqutheseal.celestisynth.item;

import com.aqutheseal.celestisynth.registry.CSItemRegistry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CelestialCoreItem extends Item {
    public CelestialCoreItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return new ItemStack(CSItemRegistry.CELESTIAL_CORE.get());
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if (this == CSItemRegistry.CELESTIAL_CORE_HEATED.get()) {
            if (pEntity instanceof Player player) {
                if (player.isCreative() || player.isSpectator()) {
                    return;
                }
            }
            pEntity.setSecondsOnFire(3);
        }
    }
}

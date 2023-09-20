package dev.kurykat.cool_stuff.base;

import dev.kurykat.cool_stuff.CoolStuff;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public record CoolArmorMaterial(
        String name,
        int durabilityMultiplier,
        int[] protection,
        int enchantability,
        SoundEvent equipSound,
        float toughness,
        float knockbackResistance,
        Supplier<Ingredient> repairMaterial
) implements ArmorMaterial {

    private static final int[] DURABILITY_PER_SLOT = new int[] { 13, 15, 16, 11 };

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return DURABILITY_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.protection[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public @NotNull String getName() {
        return CoolStuff.COOL_MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

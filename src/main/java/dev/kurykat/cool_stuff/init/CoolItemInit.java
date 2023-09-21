package dev.kurykat.cool_stuff.init;

import dev.kurykat.cool_stuff.CoolStuff;
import dev.kurykat.cool_stuff.base.CoolArmorMaterial;
import dev.kurykat.cool_stuff.base.CoolFuelItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoolItemInit {
    public static final DeferredRegister<Item> COOL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CoolStuff.COOL_MOD_ID);
    public static final RegistryObject<Item> COOL_ITEM = COOL_ITEMS.register(
            "cool_item",
            () -> new Item(
                    CoolStuff.defaultProps()
            )
    );

    public static final RegistryObject<Item> COOL_FUEL = COOL_ITEMS.register(
            "cool_fuel",
            () -> new CoolFuelItem(
                    CoolStuff.defaultProps(), 600
            )
    );

    public static final RegistryObject<Item> COOL_FOOD = COOL_ITEMS.register(
            "cool_food",
            () -> new Item(
                    CoolStuff.defaultProps()
                            .food(CoolFoods.COOL_FOOD)
            )
    );

    public static final RegistryObject<SwordItem> COOL_SWORD = COOL_ITEMS.register(
            "cool_sword",
            () -> new SwordItem(
                    CoolToolTiers.COOL_TIER,
                    5,
                    3.5f,
                    CoolStuff.defaultProps()
            )
    );

    public static final RegistryObject<PickaxeItem> COOL_PICKAXE = COOL_ITEMS.register(

            "cool_pickaxe",
            () -> new PickaxeItem(
                    CoolToolTiers.COOL_TIER,
                    4,
                    3.5f,
                    CoolStuff.defaultProps()
            )
    );

    public static final RegistryObject<AxeItem> COOL_AXE = COOL_ITEMS.register(
            "cool_axe",
            () -> new AxeItem(
                    CoolToolTiers.COOL_TIER,
                    6,
                    3.5f,
                    CoolStuff.defaultProps()
            )
    );

    public static final RegistryObject<ShovelItem> COOL_SHOVEL = COOL_ITEMS.register(
            "cool_shovel",
            () -> new ShovelItem(
                    CoolToolTiers.COOL_TIER,
                    3,
                    3.5f,
                    CoolStuff.defaultProps()
            )
    );

    public static final RegistryObject<HoeItem> COOL_HOE = COOL_ITEMS.register(
            "cool_hoe",
            () -> new HoeItem(
                    CoolToolTiers.COOL_TIER,
                    1,
                    3.5f,
                    CoolStuff.defaultProps()
            )
    );
    
    public static final RegistryObject<ArmorItem> COOL_HELMET = COOL_ITEMS.register(
            "cool_helmet",
            () -> new ArmorItem(
                    CoolArmorTiers.COOL_ARMOR_MATERIAL,
                    EquipmentSlot.HEAD,
                    CoolStuff.defaultProps()
            )
    );
    
    public static final RegistryObject<ArmorItem> COOL_CHESTPLATE = COOL_ITEMS.register(
            "cool_chestplate",
            () -> new ArmorItem(
                    CoolArmorTiers.COOL_ARMOR_MATERIAL,
                    EquipmentSlot.CHEST,
                    CoolStuff.defaultProps()
            )
    );
    
    public static final RegistryObject<ArmorItem> COOL_LEGGINGS = COOL_ITEMS.register(
            "cool_leggings",
            () -> new ArmorItem(
                    CoolArmorTiers.COOL_ARMOR_MATERIAL,
                    EquipmentSlot.LEGS,
                    CoolStuff.defaultProps()
            )
    );
    
    public static final RegistryObject<ArmorItem> COOL_BOOTS = COOL_ITEMS.register(
            "cool_boots",
            () -> new ArmorItem(
                    CoolArmorTiers.COOL_ARMOR_MATERIAL,
                    EquipmentSlot.FEET,
                    CoolStuff.defaultProps()
            )
    );

    public static class CoolArmorTiers {
        public static final ArmorMaterial COOL_ARMOR_MATERIAL = new CoolArmorMaterial(
                "cool",
                20,
                new int[] {5, 8, 10, 5},
                30,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                5,
                0.5f,
                () -> Ingredient.of(COOL_ITEM.get())
        );
    }

    public static class CoolToolTiers {

        public static final Tier COOL_TIER = new ForgeTier(
                6,
                1250,
                6,
                5,
                40,
                CoolStuff.CoolTags.NEEDS_COOL_TOOL,
                () -> Ingredient.of(COOL_ITEM.get())
        );
    }

    public static class CoolFoods {
        public static final FoodProperties COOL_FOOD = new FoodProperties.Builder()
                .nutrition(8)
                .saturationMod(0.5f)
                .fast()
                .meat()
                .effect(
                        () -> new MobEffectInstance(
                                MobEffects.FIRE_RESISTANCE, 600, 1
                        ), 1f
                )
                .build();
    }
}

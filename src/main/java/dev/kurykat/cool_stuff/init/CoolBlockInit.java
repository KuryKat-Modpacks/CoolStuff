package dev.kurykat.cool_stuff.init;

import dev.kurykat.cool_stuff.CoolStuff;
import dev.kurykat.cool_stuff.blocks.CoolAdvancedBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CoolBlockInit {
    public static final DeferredRegister<Block> COOL_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CoolStuff.COOL_MOD_ID);

    public static final RegistryObject<Block> COOL_OVERWORLD_ORE = register(
            "cool_ore",
            () -> new Block(
                    BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)
            ),
            CoolStuff.defaultItemProps()
    );

    public static final RegistryObject<Block> COOL_DEEPSLATE_OVERWORLD_ORE = register(
            "cool_deepslate_ore",
            () -> new Block(
                    BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)
            ),
            CoolStuff.defaultItemProps()
    );

    public static final RegistryObject<Block> COOL_NETHER_ORE = register(
            "cool_nether_ore",
            () -> new Block(
                    BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE)
            ),
            CoolStuff.defaultItemProps()
    );

    public static final RegistryObject<Block> COOL_END_ORE = register(
            "cool_end_ore",
            () -> new Block(
                    BlockBehaviour.Properties.copy(Blocks.END_STONE)
            ),
            CoolStuff.defaultItemProps()
    );

    public static final RegistryObject<Block> COOL_BLOCK = register(
            "cool_block",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.STONE)
                            .strength(6, 50)
                            .requiresCorrectToolForDrops()
                            .sound(ForgeSoundType.GLASS)
            ),
            CoolStuff.defaultItemProps()
    );

    public static final RegistryObject<Block> COOL_ANIMATED_BLOCK = register(
            "cool_animated_block",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.WOOD)
                            .strength(6, 50)
                            .requiresCorrectToolForDrops()
                            .sound(ForgeSoundType.GRASS)
            ),
            CoolStuff.defaultItemProps()
    );

    public static final RegistryObject<CoolAdvancedBlock> COOL_ADVANCED_BLOCK = register(
            "cool_advanced_block",
            () -> new CoolAdvancedBlock(
                    BlockBehaviour.Properties.copy(Blocks.STONE).randomTicks()
            ),
            CoolStuff.defaultItemProps()
    );


    public static final RegistryObject<FlowerBlock> COOL_FLOWER = register(
        "cool_flower",
            () -> new FlowerBlock(
                    () -> MobEffects.MOVEMENT_SPEED,
                    300,
                    BlockBehaviour.Properties.copy(Blocks.POPPY)
            ),
            CoolStuff.defaultItemProps()
    );

    public static final RegistryObject<FlowerPotBlock> COOL_POTTED_FLOWER = COOL_BLOCKS.register(
            "cool_potted_flower",
            () -> new FlowerPotBlock(
                    () -> (FlowerPotBlock) Blocks.FLOWER_POT,
                    CoolBlockInit.COOL_FLOWER,
                    BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)
            )
    );

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = COOL_BLOCKS.register(name, supplier);
        CoolItemInit.COOL_ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}

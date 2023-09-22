package dev.kurykat.cool_stuff.init;

import com.google.common.base.Suppliers;
import dev.kurykat.cool_stuff.CoolStuff;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class CoolConfiguredFeatureInit {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> COOL_CONFIGURED_FEATURES = DeferredRegister.create(
            Registry.CONFIGURED_FEATURE_REGISTRY,
            CoolStuff.COOL_MOD_ID
    );

    private static final Supplier<List<OreConfiguration.TargetBlockState>> COOL_OVERWORLD_REPLACEMENT = Suppliers.memoize(
            () -> List.of(
                    OreConfiguration.target(
                            OreFeatures.STONE_ORE_REPLACEABLES,
                            CoolBlockInit.COOL_OVERWORLD_ORE.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                            CoolBlockInit.COOL_DEEPSLATE_OVERWORLD_ORE.get().defaultBlockState()
                    )
            )
    );

    private static final Supplier<List<OreConfiguration.TargetBlockState>> COOL_NETHER_REPLACEMENT = Suppliers.memoize(
            () -> List.of(
                    OreConfiguration.target(
                            OreFeatures.NETHER_ORE_REPLACEABLES,
                            CoolBlockInit.COOL_NETHER_ORE.get().defaultBlockState()
                    )
            )
    );

    private static final Supplier<List<OreConfiguration.TargetBlockState>> COOL_END_REPLACEMENT = Suppliers.memoize(
            () -> List.of(
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.END_STONE),
                            CoolBlockInit.COOL_END_ORE.get().defaultBlockState()
                    )
            )
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> COOL_OVERWORLD_ORE = COOL_CONFIGURED_FEATURES.register(
            "cool_overworld_ore",
            () -> new ConfiguredFeature<>(
                    Feature.ORE,
                    new OreConfiguration(COOL_OVERWORLD_REPLACEMENT.get(), 15)
            )
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> COOL_NETHER_ORE = COOL_CONFIGURED_FEATURES.register(
            "cool_nether_ore",
            () -> new ConfiguredFeature<>(
                    Feature.ORE,
                    new OreConfiguration(COOL_NETHER_REPLACEMENT.get(), 10)
            )
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> COOL_END_ORE = COOL_CONFIGURED_FEATURES.register(
            "cool_end_ore",
            () -> new ConfiguredFeature<>(
                    Feature.ORE,
                    new OreConfiguration(COOL_END_REPLACEMENT.get(), 20)
            )
    );

}

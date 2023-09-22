package dev.kurykat.cool_stuff.init;

import dev.kurykat.cool_stuff.CoolStuff;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class CoolPlacedFeatureInit {
    public static final DeferredRegister<PlacedFeature> COOL_PLACED_FEATURES = DeferredRegister.create(
            Registry.PLACED_FEATURE_REGISTRY,
            CoolStuff.COOL_MOD_ID
    );

    public static final RegistryObject<PlacedFeature> COOL_OVERWORLD_ORE = COOL_PLACED_FEATURES.register(
            "cool_overworld_ore",
            () -> new PlacedFeature(
                    CoolConfiguredFeatureInit.COOL_OVERWORLD_ORE.getHolder().get(),
                    commonOrePlacement(
                            7,
                            HeightRangePlacement.triangle(
                                    VerticalAnchor.bottom(),
                                    VerticalAnchor.absolute(50)
                            )
                    )
            )
    );

    public static final RegistryObject<PlacedFeature> COOL_NETHER_ORE = COOL_PLACED_FEATURES.register(
            "cool_nether_ore",
            () -> new PlacedFeature(
                    CoolConfiguredFeatureInit.COOL_NETHER_ORE.getHolder().get(),
                    commonOrePlacement(
                            7,
                            HeightRangePlacement.uniform(
                                    VerticalAnchor.bottom(),
                                    VerticalAnchor.top()
                            )
                    )
            )
    );

    public static final RegistryObject<PlacedFeature> COOL_END_ORE = COOL_PLACED_FEATURES.register(
            "cool_end_ore",
            () -> new PlacedFeature(
                    CoolConfiguredFeatureInit.COOL_END_ORE.getHolder().get(),
                    commonOrePlacement(
                            7,
                            HeightRangePlacement.triangle(
                                    VerticalAnchor.bottom(),
                                    VerticalAnchor.belowTop(100)
                            )
                    )
            )
    );

    public static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
        return orePlacement(CountPlacement.of(countPerChunk), height);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }
}

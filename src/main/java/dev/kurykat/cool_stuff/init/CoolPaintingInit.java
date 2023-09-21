package dev.kurykat.cool_stuff.init;

import dev.kurykat.cool_stuff.CoolStuff;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CoolPaintingInit {
    public static final DeferredRegister<PaintingVariant> COOL_PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, CoolStuff.COOL_MOD_ID);

    public static final RegistryObject<PaintingVariant> COOL_PAINTING = COOL_PAINTINGS.register(
            "cool_painting",
            () -> new PaintingVariant(64, 64)
    );
}

package dev.kurykat.cool_stuff.events;

import dev.kurykat.cool_stuff.CoolStuff;
import dev.kurykat.cool_stuff.init.CoolBlockInit;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = CoolStuff.COOL_MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CoolCommonEvent {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(CoolBlockInit.COOL_FLOWER.getId(), CoolBlockInit.COOL_POTTED_FLOWER);
        });
    }
}

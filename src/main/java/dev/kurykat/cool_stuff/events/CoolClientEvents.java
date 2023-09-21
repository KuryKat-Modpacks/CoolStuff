package dev.kurykat.cool_stuff.events;

import dev.kurykat.cool_stuff.CoolStuff;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CoolStuff.COOL_MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CoolClientEvents {

}

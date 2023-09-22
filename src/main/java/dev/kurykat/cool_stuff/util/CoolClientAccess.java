package dev.kurykat.cool_stuff.util;

import dev.kurykat.cool_stuff.CoolStuff;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

import java.util.List;

public class CoolClientAccess {
    public static void coolAdvancedItemTooltip(Level level, List<Component> components) {
        assert Minecraft.getInstance().player != null;
        if(Screen.hasShiftDown()) {
            components.add(
                    Component.translatable(CoolStuff.COOL_MOD_ID + ".cool_advanced_item.tooltip.shift")
            );
        } else {
            components.add(
                    Component.translatable(
                            CoolStuff.COOL_MOD_ID + ".cool_advanced_item.tooltip"
                    )
            );
        }
    }
}

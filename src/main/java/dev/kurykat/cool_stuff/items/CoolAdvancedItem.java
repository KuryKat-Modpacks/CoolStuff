package dev.kurykat.cool_stuff.items;

import dev.kurykat.cool_stuff.util.CoolClientAccess;
import dev.kurykat.cool_stuff.CoolStuff;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CoolAdvancedItem extends Item {

    public CoolAdvancedItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if(hand == InteractionHand.MAIN_HAND && !level.isClientSide()) {
            player.sendSystemMessage(
                    Component.translatable(
                            CoolStuff.COOL_MOD_ID + ".cool_advanced_item.right_click"
                    )
            );
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemStack, level, components, flag);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> CoolClientAccess.coolAdvancedItemTooltip(level, components));
    }
}

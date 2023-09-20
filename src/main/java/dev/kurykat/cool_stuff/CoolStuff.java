package dev.kurykat.cool_stuff;

import dev.kurykat.cool_stuff.init.CoolBlockInit;
import dev.kurykat.cool_stuff.init.CoolItemInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

@Mod(CoolStuff.COOL_MOD_ID)
public class CoolStuff {
    public static final String COOL_MOD_ID = "cool_stuff";

    public CoolStuff() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        CoolItemInit.COOL_ITEMS.register(bus);
        CoolBlockInit.COOL_BLOCKS.register(bus);
    }

    public static final CreativeModeTab COOL_CREATIVE_TAB = new CreativeModeTab(COOL_MOD_ID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return CoolItemInit.COOL_ITEM.get().getDefaultInstance();
        }
    };

    public static Item.Properties defaultProps() {
        return new Item.Properties().tab(COOL_CREATIVE_TAB);
    }

    public static class CoolTags {
        public static final TagKey<Block> NEEDS_COOL_TOOL = createCoolTag("needs_cool_tool");

        private static TagKey<Block> createCoolTag(String location) {
            return BlockTags.create(new ResourceLocation(CoolStuff.COOL_MOD_ID, location));
        }

        private static TagKey<Block> createForgeTag(String location) {
            return BlockTags.create(new ResourceLocation("forge", location));
        }

        private static TagKey<Block> createMinecraftTag(String location) {
            return BlockTags.create(new ResourceLocation("minecraft", location));
        }
    }
}

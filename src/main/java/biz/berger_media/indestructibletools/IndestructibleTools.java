package biz.berger_media.indestructibletools;

import biz.berger_media.indestructibletools.item.IndestructibleItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Main class of the mod
 */
@Mod(IndestructibleTools.MOD_ID)
public class IndestructibleTools {
    /**
     * Id of the mod
     */
    public static final String MOD_ID = "indestructibletools";

    /**
     * Creates an instance of the mod
     */
    public IndestructibleTools() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        IndestructibleItems.ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    /**
     * Item group for the Creative tab
     */
    public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(IndestructibleItems.INDESTRUCTIBLE_INGOT.get());
        }
    };
}

package biz.berger_media.indestructibletools;

import biz.berger_media.indestructibletools.events.RightClickBlockEventListener;
import biz.berger_media.indestructibletools.item.IndestructibleItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * Main class of the mod
 */
@Mod(IndestructibleTools.MOD_ID)
public class IndestructibleTools {
    /**
     * Id of the mod
     */
    public static final String MOD_ID = "indestructibletools";

    public static final BlockState DirtPathState = Blocks.DIRT_PATH.defaultBlockState();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    /**
     * Creates an instance of the mod
     */
    public IndestructibleTools() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        IndestructibleItems.ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new RightClickBlockEventListener());

        bus.addListener(this::addCreative);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    /**
     * Tab for the creative mode
     */
    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("indestructible_tools_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SEARCH)
            .title(Component.translatable("itemGroup.indestructibletools"))
            .icon(() -> IndestructibleItems.INDESTRUCTIBLE_INGOT.get().getDefaultInstance())
            .displayItems((params, output) -> {
                output.accept(IndestructibleItems.INDESTRUCTIBLE_INGOT.get());
                output.accept(IndestructibleItems.INDESTRUCTIBLE_AXE.get());
                output.accept(IndestructibleItems.INDESTRUCTIBLE_HOE.get());
                output.accept(IndestructibleItems.INDESTRUCTIBLE_PICKAXE.get());
                output.accept(IndestructibleItems.INDESTRUCTIBLE_SHOVEL.get());
                output.accept(IndestructibleItems.INDESTRUCTIBLE_SWORD.get());
                output.accept(IndestructibleItems.INDESTRUCTIBLE_MULTITOOL.get());
            })
            .build());

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(IndestructibleItems.INDESTRUCTIBLE_SWORD);
            event.accept(IndestructibleItems.INDESTRUCTIBLE_AXE);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(IndestructibleItems.INDESTRUCTIBLE_SHOVEL);
            event.accept(IndestructibleItems.INDESTRUCTIBLE_PICKAXE);
            event.accept(IndestructibleItems.INDESTRUCTIBLE_AXE);
            event.accept(IndestructibleItems.INDESTRUCTIBLE_HOE);
            event.accept(IndestructibleItems.INDESTRUCTIBLE_MULTITOOL);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(IndestructibleItems.INDESTRUCTIBLE_INGOT);
        }
    }
}

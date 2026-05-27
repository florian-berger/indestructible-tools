package biz.berger_media.indestructibletools;

import biz.berger_media.indestructibletools.events.RightClickBlockEventListener;
import biz.berger_media.indestructibletools.item.IndestructibleItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import static biz.berger_media.indestructibletools.item.IndestructibleItems.*;

/**
 * Main class of the mod
 */
@Mod(IndestructibleTools.MOD_ID)
public class IndestructibleTools {
    /**
     * ID of the mod
     */
    public static final String MOD_ID = "indestructibletools";

    public static final BlockState DirtPathState = Blocks.DIRT_PATH.defaultBlockState();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Creates an instance of the mod
     */
    public IndestructibleTools(IEventBus bus) {
        bus.addListener(this::setup);
        bus.addListener(this::gatherData);

        ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);

        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(new RightClickBlockEventListener());

        bus.addListener(this::addCreative);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    /**
     * Tab for the creative mode
     */
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register("indestructible_tools_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.indestructibletools"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
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
            event.accept(new ItemStack(IndestructibleItems.INDESTRUCTIBLE_SWORD.get()));
            event.accept(new ItemStack(IndestructibleItems.INDESTRUCTIBLE_AXE.get()));
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(new ItemStack(IndestructibleItems.INDESTRUCTIBLE_SHOVEL.get()));
            event.accept(new ItemStack(IndestructibleItems.INDESTRUCTIBLE_PICKAXE.get()));
            event.accept(new ItemStack(IndestructibleItems.INDESTRUCTIBLE_AXE.get()));
            event.accept(new ItemStack(IndestructibleItems.INDESTRUCTIBLE_HOE.get()));
            event.accept(new ItemStack(IndestructibleItems.INDESTRUCTIBLE_MULTITOOL.get()));
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(new ItemStack(IndestructibleItems.INDESTRUCTIBLE_INGOT.get()));
        }
    }

    private void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();

        // Create an anonymous BlockTagsProvider abstraction class. We need one for
        // the ItemTagsProvider, even if it's empty
        BlockTagsProvider blockTagsProvider = new BlockTagsProvider(
                output,
                event.getLookupProvider(),
                MOD_ID,
                event.getExistingFileHelper()
        ) {
            @Override
            protected void addTags(HolderLookup.@NotNull Provider provider) {
                // We have no blocks in the mod, so the provider stays empty
            }
        };
        generator.addProvider(event.includeServer(), blockTagsProvider);

        generator.addProvider(event.includeServer(), new IndestructibleItemsTagsProvider(
                output,
                event.getLookupProvider(),
                blockTagsProvider,
                MOD_ID,
                event.getExistingFileHelper()
        ));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("IndestructibleTools: Server starting");
    }
}

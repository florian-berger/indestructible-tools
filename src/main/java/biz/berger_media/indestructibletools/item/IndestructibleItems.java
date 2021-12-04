package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.IndestructibleTools;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IndestructibleItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            IndestructibleTools.MOD_ID);

    public static final RegistryObject<Item> INDESTRUCTIBLE_INGOT =
            ITEMS.register("indestructible_ingot", ItemIndestructibleIngot::new);

    public static final RegistryObject<PickaxeItem> INDESTRUCTIBLE_PICKAXE =
            ITEMS.register("indestructible_pickaxe", ItemIndestructiblePickaxe::new);

    public static final RegistryObject<AxeItem> INDESTRUCTIBLE_AXE =
            ITEMS.register("indestructible_axe", ItemIndestructibleAxe::new);

    public static final RegistryObject<ShovelItem> INDESTRUCTIBLE_SHOVEL =
            ITEMS.register("indestructible_shovel", ItemIndestructibleShovel::new);

    public static final RegistryObject<SwordItem> INDESTRUCTIBLE_SWORD =
            ITEMS.register("indestructible_sword", ItemIndestructibleSword::new);

    public static final RegistryObject<HoeItem> INDESTRUCTIBLE_HOE =
            ITEMS.register("indestructible_hoe", ItemIndestructibleHoe::new);

}

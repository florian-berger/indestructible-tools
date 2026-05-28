package biz.berger_media.indestructibletools.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.crafting.Ingredient;

import static biz.berger_media.indestructibletools.IndestructibleTools.MOD_ID;

public class IndestructibleItems {
    public static final Tier INDESTRUCTIBLE_TIER = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            3046,
            13,
            5,
            44, // Double of gold
            () -> Ingredient.EMPTY
    );

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<Item> INDESTRUCTIBLE_INGOT =
            ITEMS.register("indestructible_ingot", resLoc -> new ItemIndestructibleIngot());

    public static final DeferredItem<Item> INDESTRUCTIBLE_PICKAXE =
            ITEMS.register("indestructible_pickaxe", resLoc -> new ItemIndestructiblePickaxe());

    public static final DeferredItem<Item> INDESTRUCTIBLE_AXE =
            ITEMS.register("indestructible_axe", resLoc -> new ItemIndestructibleAxe());

    public static final DeferredItem<Item> INDESTRUCTIBLE_SHOVEL =
            ITEMS.register("indestructible_shovel", resLoc -> new ItemIndestructibleShovel());

    public static final DeferredItem<Item> INDESTRUCTIBLE_SWORD =
            ITEMS.register("indestructible_sword", resLoc -> new ItemIndestructibleSword());

    public static final DeferredItem<Item> INDESTRUCTIBLE_HOE =
            ITEMS.register("indestructible_hoe", resLoc -> new ItemIndestructibleHoe());

    public static final DeferredItem<Item> INDESTRUCTIBLE_MULTITOOL =
            ITEMS.register("indestructible_multitool", resLoc -> new ItemIndestructibleMultiTool());
}

package biz.berger_media.indestructibletools;

import biz.berger_media.indestructibletools.item.IndestructibleItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class IndestructibleItemsTagsProvider extends ItemTagsProvider {
    public IndestructibleItemsTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            BlockTagsProvider blockTagsProvider,
            String modId,
            @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, blockTagsProvider.contentsGetter(), modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        Item[] miningItems = {
                IndestructibleItems.INDESTRUCTIBLE_AXE.get(),
                IndestructibleItems.INDESTRUCTIBLE_HOE.get(),
                IndestructibleItems.INDESTRUCTIBLE_MULTITOOL.get(),
                IndestructibleItems.INDESTRUCTIBLE_PICKAXE.get(),
                IndestructibleItems.INDESTRUCTIBLE_SHOVEL.get()
        };

        Item[] weaponItems = {
                IndestructibleItems.INDESTRUCTIBLE_SWORD.get(),
                IndestructibleItems.INDESTRUCTIBLE_AXE.get()
        };

        Item[] allItems = {
                IndestructibleItems.INDESTRUCTIBLE_AXE.get(),
                IndestructibleItems.INDESTRUCTIBLE_HOE.get(),
                IndestructibleItems.INDESTRUCTIBLE_MULTITOOL.get(),
                IndestructibleItems.INDESTRUCTIBLE_PICKAXE.get(),
                IndestructibleItems.INDESTRUCTIBLE_SHOVEL.get(),
                IndestructibleItems.INDESTRUCTIBLE_SWORD.get()
        };

        for (Item mining : miningItems) {
            this.tag(ItemTags.MINING_ENCHANTABLE).add(mining);
            this.tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(mining);
        }

        for (Item weapon : weaponItems) {
            this.tag(ItemTags.WEAPON_ENCHANTABLE).add(weapon);
            this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(weapon);
        }

        this.tag(ItemTags.SWORD_ENCHANTABLE).add(IndestructibleItems.INDESTRUCTIBLE_SWORD.get());

        this.tag(ItemTags.AXES).add(IndestructibleItems.INDESTRUCTIBLE_AXE.get());
        this.tag(ItemTags.AXES).add(IndestructibleItems.INDESTRUCTIBLE_MULTITOOL.get());

        this.tag(ItemTags.PICKAXES).add(IndestructibleItems.INDESTRUCTIBLE_PICKAXE.get());
        this.tag(ItemTags.PICKAXES).add(IndestructibleItems.INDESTRUCTIBLE_MULTITOOL.get());

        this.tag(ItemTags.SHOVELS).add(IndestructibleItems.INDESTRUCTIBLE_SHOVEL.get());
        this.tag(ItemTags.SHOVELS).add(IndestructibleItems.INDESTRUCTIBLE_MULTITOOL.get());

        this.tag(ItemTags.SWORDS).add(IndestructibleItems.INDESTRUCTIBLE_SWORD.get());

        this.tag(ItemTags.HOES).add(IndestructibleItems.INDESTRUCTIBLE_HOE.get());

        for (Item item : allItems) {
            this.tag(ItemTags.DURABILITY_ENCHANTABLE).remove(item);
        }
    }
}

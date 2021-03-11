package biz.berger_media.indestructibletools.helpers;

import biz.berger_media.indestructibletools.IndestructibleTools;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

/**
 * Class that provides helper functions for items
 */
public final class ItemHelper {
    /**
     * Gets the default properties for an unbreakable enchantment
     *
     * @param toolType Type of the tool. NULL if it should not be set
     * @return Item properties
     */
    public static Item.Properties getProperties(@Nullable ToolType toolType) {
        Item.Properties props = new Item.Properties()
                .group(IndestructibleTools.ITEM_GROUP)
                .maxStackSize(1)
                .maxDamage(-1)
                .rarity(Rarity.EPIC)
                .setNoRepair()
                .isImmuneToFire();

        if (toolType != null) {
            props.addToolType(toolType, 4);
        }

        return props;
    }
}

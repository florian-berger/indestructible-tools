package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.world.item.ShovelItem;

import static biz.berger_media.indestructibletools.item.IndestructibleItems.INDESTRUCTIBLE_TIER;

/**
 * Class that represents an indestructible shovel
 */
public class ItemIndestructibleShovel extends ShovelItem {
    /**
     * Constructor of the shovel
     */
    public ItemIndestructibleShovel() {
        super(
                INDESTRUCTIBLE_TIER,
                ItemHelper.getProperties(
                        ShovelItem.createAttributes(INDESTRUCTIBLE_TIER, 1.5F, -3.0F)
                )
        );
    }
}

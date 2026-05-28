package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.world.item.HoeItem;

import static biz.berger_media.indestructibletools.item.IndestructibleItems.INDESTRUCTIBLE_TIER;

/**
 * Class that represents an indestructible hoe
 */
public class ItemIndestructibleHoe extends HoeItem {
    /**
     * Constructor of the hoe
     */
    public ItemIndestructibleHoe() {
        super(
                INDESTRUCTIBLE_TIER,
                ItemHelper.getProperties(
                        HoeItem.createAttributes(INDESTRUCTIBLE_TIER, -5.0F, 1.0F)
                )
        );
    }
}

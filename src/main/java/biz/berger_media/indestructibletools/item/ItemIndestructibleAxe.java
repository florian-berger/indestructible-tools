package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.world.item.AxeItem;

import static biz.berger_media.indestructibletools.item.IndestructibleItems.INDESTRUCTIBLE_TIER;

/**
 * Class that represents an indestructible axe
 */
public class ItemIndestructibleAxe extends AxeItem {
    /**
     * Constructor of the axe
     */
    public ItemIndestructibleAxe() {
        super(
                INDESTRUCTIBLE_TIER,
                ItemHelper.getProperties(
                        AxeItem.createAttributes(INDESTRUCTIBLE_TIER, 5.0F, -3.0F)
                )
        );
    }
}

package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.world.item.SwordItem;

import static biz.berger_media.indestructibletools.item.IndestructibleItems.INDESTRUCTIBLE_TIER;

/**
 * Class that represents an indestructible sword
 */
public class ItemIndestructibleSword extends SwordItem {
    /**
     * Constructor of the sword
     */
    public ItemIndestructibleSword() {
        super(
                INDESTRUCTIBLE_TIER,
                ItemHelper.getProperties(
                        SwordItem.createAttributes(INDESTRUCTIBLE_TIER, 5.0F, -2.4F)
                )
        );
    }
}

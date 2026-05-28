package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.world.item.PickaxeItem;

import static biz.berger_media.indestructibletools.item.IndestructibleItems.INDESTRUCTIBLE_TIER;

/**
 * Class that represents an indestructible pickaxe
 */
public class ItemIndestructiblePickaxe extends PickaxeItem {
    /**
     * Constructor of the pickaxe
     */
    public ItemIndestructiblePickaxe() {
        super(
                INDESTRUCTIBLE_TIER,
                ItemHelper.getProperties(
                        PickaxeItem.createAttributes(INDESTRUCTIBLE_TIER, 1.0F, -2.8F)
                )
        );
    }
}

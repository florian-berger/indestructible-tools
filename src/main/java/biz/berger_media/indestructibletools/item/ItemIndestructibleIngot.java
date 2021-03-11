package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.IndestructibleTools;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

/**
 * Class that represents an indestructible ingot. This will be used for crafting other items only
 */
public class ItemIndestructibleIngot extends Item {
    /**
     * Constructor of the ingot
     */
    public ItemIndestructibleIngot() {
        super(new Properties().group(IndestructibleTools.ITEM_GROUP).rarity(Rarity.EPIC));
    }
}

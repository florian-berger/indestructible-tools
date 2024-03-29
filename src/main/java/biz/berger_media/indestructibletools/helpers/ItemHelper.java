package biz.berger_media.indestructibletools.helpers;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

/**
 * Class that provides helper functions for items
 */
public final class ItemHelper {
    /**
     * Gets the default properties for an unbreakable enchantment
     *
     * @return Item properties
     */
    public static Item.Properties getProperties() {
        return new Item.Properties()
                .stacksTo(1)
                .durability(-1)
                .rarity(Rarity.EPIC)
                .setNoRepair()
                .fireResistant();
    }
}

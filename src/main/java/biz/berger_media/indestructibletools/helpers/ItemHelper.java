package biz.berger_media.indestructibletools.helpers;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Unbreakable;

/**
 * Class that provides helper functions for items
 */
public final class ItemHelper {
    /**
     * Gets the default properties for an unbreakable enchantment
     *
     * @return Item properties
     */
    public static Item.Properties getProperties(ItemAttributeModifiers attributes) {
        return getProperties().attributes(attributes);
    }

    public static Item.Properties getProperties() {
        return new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.EPIC)
                .setNoRepair()
                .fireResistant()
                .component(DataComponents.UNBREAKABLE, new Unbreakable(true));
    }
}

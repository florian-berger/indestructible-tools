package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.EnchantmentHelper;
import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;

/**
 * Class that represents an indestructible hoe
 */
public class ItemIndestructibleHoe extends HoeItem {
    /**
     * Constructor of the hoe
     */
    public ItemIndestructibleHoe() {
        super(Tiers.NETHERITE, -4, 1, ItemHelper.getProperties());
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return !stack.isEnchanted();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (EnchantmentHelper.isInvalidEnchantment(enchantment)) {
            return false;
        }

        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        if (EnchantmentHelper.isBookEnchantedWithInvalidSpell(book)) {
            return false;
        }

        return super.isBookEnchantable(stack, book);
    }
}

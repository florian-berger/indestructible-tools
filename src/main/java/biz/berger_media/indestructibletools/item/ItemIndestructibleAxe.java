package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.EnchantmentHelper;
import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;

/**
 * Class that represents an indestructible axe
 */
public class ItemIndestructibleAxe extends AxeItem {
    /**
     * Constructor of the axe
     */
    public ItemIndestructibleAxe() {
        super(Tiers.NETHERITE, 6, -2.2f, ItemHelper.getProperties());
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

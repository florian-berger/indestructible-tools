package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.EnchantmentHelper;
import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraftforge.common.ToolType;

/**
 * Class that represents an indestructible hoe
 */
public class ItemIndestructibleHoe extends HoeItem {
    /**
     * Constructor of the hoe
     */
    public ItemIndestructibleHoe() {
        super(ItemTier.NETHERITE, -4, 1, ItemHelper.getProperties(ToolType.HOE));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return !stack.isEnchanted();
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return EnchantmentHelper.isUnbreakingEnchantment(enchantment);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return EnchantmentHelper.isBookEnchantmentAllowed(book);
    }
}

package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.EnchantmentHelper;
import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.common.ToolType;

/**
 * Class that represents an indestructible shovel
 */
public class ItemIndestructibleShovel extends ShovelItem {
    /**
     * Constructor of the shovel
     */
    public ItemIndestructibleShovel() {
        super(ItemTier.NETHERITE, 2, -2f, ItemHelper.getProperties(ToolType.SHOVEL));
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

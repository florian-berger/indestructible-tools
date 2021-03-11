package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.EnchantmentHelper;
import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;

/**
 * Class that represents an indestructible pickaxe
 */
public class ItemIndestructiblePickaxe extends PickaxeItem {
    /**
     * Constructor of the pickaxe
     */
    public ItemIndestructiblePickaxe() {
        super(ItemTier.NETHERITE, 1, -1.8f, ItemHelper.getProperties(ToolType.PICKAXE));
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

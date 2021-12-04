package biz.berger_media.indestructibletools.helpers;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DigDurabilityEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.MendingEnchantment;

import java.util.Map;

/**
 * Class providing helper functions for checking enchantments
 */
public class EnchantmentHelper {
    /**
     * Checks, if a book has an unbreaking enchantment
     *
     * @param book Book that should be checked
     * @return True if the book has an unbreaking enchantment
     */
    public static boolean isBookEnchantedWithInvalidSpell(ItemStack book) {
        Map<Enchantment, Integer> enchantments = net.minecraft.world.item.enchantment.EnchantmentHelper.getEnchantments(book);
        for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
            if (isInvalidEnchantment(entry.getKey())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if an enchantment is invalid for indestructible tools
     *
     * @param enchantment Enchantment that should be checked
     * @return True if the passed enchantment is an instance of UnbreakingEnchantment or MendingEnchantment
     */
    public static boolean isInvalidEnchantment(Enchantment enchantment) {
        return enchantment instanceof DigDurabilityEnchantment
                || enchantment instanceof MendingEnchantment;
    }
}

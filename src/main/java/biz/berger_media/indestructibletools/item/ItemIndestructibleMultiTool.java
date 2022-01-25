package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.EnchantmentHelper;
import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Class that represents the Multi-Tool (can be used as different tool)
 */
public class ItemIndestructibleMultiTool extends PickaxeItem {
    public ItemIndestructibleMultiTool() {
        super(Tiers.NETHERITE, 4, -1.5F, ItemHelper.getProperties());
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_AXE)) {
            return this.speed;
        }

        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            return this.speed;
        }

        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_AXE)) {
            return true;
        }

        if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            return true;
        }

        return super.isCorrectToolForDrops(stack, state);
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

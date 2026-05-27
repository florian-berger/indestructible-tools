package biz.berger_media.indestructibletools.item;

import biz.berger_media.indestructibletools.helpers.ItemHelper;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Tool;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static biz.berger_media.indestructibletools.item.IndestructibleItems.INDESTRUCTIBLE_TIER;

/**
 * Class that represents the Multi-Tool (can be used as different tool)
 */
public class ItemIndestructibleMultiTool extends Item {
    public ItemIndestructibleMultiTool() {
        super(
                ItemHelper.getProperties(
                        DiggerItem.createAttributes(INDESTRUCTIBLE_TIER, 3.0F, -1.8F)
                ).component(DataComponents.TOOL, createMultiToolComponent())
        );
    }

    @Override
    public int getEnchantmentValue() {
        return INDESTRUCTIBLE_TIER.getEnchantmentValue();
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return true;
    }

    // Override this so the game client plays the correct "swing" animations
    // and treats it like a harvesting tool in the player's hand.
    @Override
    public boolean canAttackBlock(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player) {
        return !player.isCreative();
    }

    /**
     * Builds a Tool component combining Pickaxe, Axe, Shovel, and Hoe rules.
     */
    private static Tool createMultiToolComponent() {
        float speed = IndestructibleItems.INDESTRUCTIBLE_TIER.getSpeed();

        return new Tool(
                List.of(
                        // Make it an effective tool and set mining speed for all 4 types
                        Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_PICKAXE, speed),
                        Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_AXE, speed),
                        Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_SHOVEL, speed),
                        Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_HOE, speed)
                ),
                5.0F,
                1
        );
    }
}

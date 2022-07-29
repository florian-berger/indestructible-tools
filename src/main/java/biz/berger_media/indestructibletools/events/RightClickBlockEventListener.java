package biz.berger_media.indestructibletools.events;

import biz.berger_media.indestructibletools.IndestructibleTools;
import biz.berger_media.indestructibletools.item.ItemIndestructibleMultiTool;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RightClickBlockEventListener {
    /**
     * Listener for the RightClick event on a block
     */
    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent.RightClickBlock event) {
        if (event.getResult() != Event.Result.DEFAULT || event.isCanceled()) {
            return;
        }

        Player player = event.getEntity();
        Level world = event.getLevel();
        InteractionHand hand = event.getHand();

        if (player.getItemInHand(hand).getItem() instanceof ItemIndestructibleMultiTool) {
            BlockPos pos = event.getPos();
            if (world.getBlockState(pos.above()).getMaterial() == Material.AIR) {
                BlockState state = world.getBlockState(pos);
                if (isConvertible(state)) {
                    convertToPath(world, pos, player, hand);
                }
            }
        }
    }

    /**
     * Checks if the target block can be converted to a Dirt Path
     */
    private static boolean isConvertible(BlockState state) {
        Block block = state.getBlock();
        return block == Blocks.COARSE_DIRT || block == Blocks.DIRT ||
               block == Blocks.MYCELIUM || block == Blocks.PODZOL ||
               block == Blocks.GRASS_BLOCK;
    }

    /**
     * Replaces a block at position with a dirt path and plays a sound
     *
     * @param world World where the block should be replaced
     * @param pos Position that should be replaced
     * @param player Player that is replacing the block
     * @param hand Hand that should swing
     */
    private static void convertToPath(Level world, BlockPos pos, Player player, InteractionHand hand) {
        world.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
        player.swing(hand);

        if (!world.isClientSide) {
            world.setBlock(pos, IndestructibleTools.DirtPathState, 11);
        }
    }
}

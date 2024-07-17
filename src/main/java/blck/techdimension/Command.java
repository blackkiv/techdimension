package blck.techdimension;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;

import static blck.techdimension.Dimension.TECH_DIMENSION;

@Mod.EventBusSubscriber(modid = TechDimensionMod.MODID)
public class Command {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("techdimension").executes(context -> {
            var source = context.getSource();
            var player = source.getPlayerOrException();
            var targetWorld = player.server.getLevel(TECH_DIMENSION);
            if (targetWorld == null) {
                return 0;
            }
            var targetPos = new BlockPos(0, 0, 0);

            if (!targetWorld.getBlockState(targetPos).hasBlockEntity()) {

                var accessor = targetWorld.getChunk(0, 0).getHeightAccessorForGeneration();
                int y = targetWorld.getChunkSource().getGenerator().getSpawnHeight(accessor);
                if (targetWorld.getBlockState(new BlockPos(targetPos.getX(), y - 1, targetPos.getZ())).is(Blocks.AIR)) {
                    targetWorld.setBlockAndUpdate(new BlockPos(targetPos.getX(), y - 1, targetPos.getZ()), Blocks.STONE.defaultBlockState());
                }
                player.teleportTo(targetWorld, 0.5D, y + 0.25D, 0.5D, 0, 0);
            }
            return 1;
        }));
    }
}

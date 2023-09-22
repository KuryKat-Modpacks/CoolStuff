package dev.kurykat.cool_stuff.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class CoolAdvancedBlock extends Block {
    public CoolAdvancedBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(
            @NotNull BlockState state,
            @NotNull Level level,
            @NotNull BlockPos pos,
            @NotNull Player player,
            @NotNull InteractionHand hand,
            @NotNull BlockHitResult hitResult
    ) {
        if (!level.isClientSide()) {
            boneMealBlocks((ServerLevel) level, pos);
        }

        return InteractionResult.sidedSuccess(!level.isClientSide());
    }

    private static void boneMealBlocks(ServerLevel level, BlockPos pos) {
        int radius = 1;
        int maxRadius = 10;
        int maxAttempts = 10;

        while (radius < maxRadius) {
            for (Direction direction : Direction.values()) {
                BlockPos newPos = pos.relative(direction, radius);
                BlockState blockState = level.getBlockState(newPos);
                if (blockState.getBlock() instanceof BonemealableBlock bonemealableBlock) {
                    for(int attempt = 0; attempt < maxAttempts; attempt++) {
                        bonemealableBlock.performBonemeal(level, level.getRandom(), newPos, blockState);
                        level.sendParticles(
                                ParticleTypes.COMPOSTER,
                                newPos.getX(),
                                newPos.getY() + 1,
                                newPos.getZ(),
                                1,
                                0,
                                0,
                                0,
                                0
                        );
                    }
                }
            }
            ++radius;
        }
    }

    @Override
    public void randomTick(
            @NotNull BlockState state,
            @NotNull ServerLevel level,
            @NotNull BlockPos pos,
            @NotNull RandomSource random
    ) {
        for (int i = 0; i < 1000; i++) {
            BlockPos particlePos = randomPointOnSphere(pos.above(20).offset(0.5, 0.5, 0.5), 10, random);
            level.sendParticles(
                    ParticleTypes.ENCHANT,
                    particlePos.getX(),
                    particlePos.getY(),
                    particlePos.getZ(),
                    1,
                    0,
                    0,
                    0,
                    0
            );
        }
    }

    private BlockPos randomPointOnSphere(BlockPos pos, int radius, RandomSource random) {
        double u = random.nextDouble();
        double v = random.nextDouble();
        double theta = 2 * Math.PI * u;
        double phi = Math.acos(2 * v - 1);
        double x = radius * Math.sin(phi) * Math.cos(theta);
        double y = radius * Math.sin(phi) * Math.sin(theta);
        double z = radius * Math.sin(phi);
        return pos.offset(x, y, z);
    }
}

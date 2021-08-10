package net.mcreator.smartfarming.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;

import net.mcreator.smartfarming.SmartFarmingModElements;
import net.mcreator.smartfarming.SmartFarmingMod;

import java.util.Map;

@SmartFarmingModElements.ModElement.Tag
public class RustProcedure extends SmartFarmingModElements.ModElement {
	public RustProcedure(SmartFarmingModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency x for procedure Rust!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency y for procedure Rust!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency z for procedure Rust!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency world for procedure Rust!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double randomchance = 0;
		if ((!(world.isRemote()))) {
			if ((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.FARMLAND.getDefaultState().getBlock()))) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
							new BlockPos((int) (x + 0.5), (int) (y + 0.5), (int) (z + 0.5)));
					world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
				}
			} else {
				randomchance = (double) Math.random();
			}
		}
	}
}

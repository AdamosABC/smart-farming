package net.mcreator.smartfarming.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.smartfarming.item.SuperkberryItem;
import net.mcreator.smartfarming.item.SeedsuperkytkaItem;
import net.mcreator.smartfarming.SmartFarmingModElements;
import net.mcreator.smartfarming.SmartFarmingMod;

import java.util.Map;

@SmartFarmingModElements.ModElement.Tag
public class SuperkytkaharvestProcedure extends SmartFarmingModElements.ModElement {
	public SuperkytkaharvestProcedure(SmartFarmingModElements instance) {
		super(instance, 44);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency x for procedure Superkytkaharvest!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency y for procedure Superkytkaharvest!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency z for procedure Superkytkaharvest!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency world for procedure Superkytkaharvest!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double randomSeedDropAmount = 0;
		if ((!(world.isRemote()))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
						new ItemStack(SuperkberryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			randomSeedDropAmount = (double) Math.random();
			if (((randomSeedDropAmount) >= 0.66)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
							new ItemStack(SeedsuperkytkaItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
							new ItemStack(SeedsuperkytkaItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			} else if (((randomSeedDropAmount) >= 0.33)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
							new ItemStack(SeedsuperkytkaItem.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}

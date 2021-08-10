package net.mcreator.smartfarming.procedures;

@SmartFarmingModElements.ModElement.Tag
public class SaladbreakProcedure extends SmartFarmingModElements.ModElement {

	public SaladbreakProcedure(SmartFarmingModElements instance) {
		super(instance, 25);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency x for procedure Saladbreak!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency y for procedure Saladbreak!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency z for procedure Saladbreak!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency world for procedure Saladbreak!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if ((!(world.isRemote()))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, (x + 0.5), (y + 0.5), (z + 0.5),
						new ItemStack(SaladseedItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}

	}

}

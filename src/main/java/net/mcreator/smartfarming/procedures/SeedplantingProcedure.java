package net.mcreator.smartfarming.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.smartfarming.block.Salatfaze1Block;
import net.mcreator.smartfarming.SmartFarmingModElements;
import net.mcreator.smartfarming.SmartFarmingMod;

import java.util.Map;

@SmartFarmingModElements.ModElement.Tag
public class SeedplantingProcedure extends SmartFarmingModElements.ModElement {
	public SeedplantingProcedure(SmartFarmingModElements instance) {
		super(instance, 22);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency direction for procedure Seedplanting!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency entity for procedure Seedplanting!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency itemstack for procedure Seedplanting!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency x for procedure Seedplanting!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency y for procedure Seedplanting!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency z for procedure Seedplanting!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SmartFarmingMod.LOGGER.warn("Failed to load dependency world for procedure Seedplanting!");
			return;
		}
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(world.isRemote()))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == (itemstack)
					.getItem())) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
				}
			}
		}
		if (((direction == Direction.UP)
				&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.FARMLAND.getDefaultState().getBlock()))) {
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)
					|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
							.getMaterial() == net.minecraft.block.material.Material.FIRE)
							|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
									.getMaterial() == net.minecraft.block.material.Material.TALL_PLANTS)
									|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
											.getMaterial() == net.minecraft.block.material.Material.STRUCTURE_VOID)
											|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
													.getMaterial() == net.minecraft.block.material.Material.SNOW_BLOCK)))))) {
				if ((!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity)))) {
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (itemstack);
						_setstack.setCount(
								(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))
										.getCount()) - 1));
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
				{
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					BlockState _bs = Salatfaze1Block.block.getDefaultState();
					world.setBlockState(_bp, _bs, 3);
				}
			}
		}
	}
}

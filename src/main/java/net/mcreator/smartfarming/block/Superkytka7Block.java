
package net.mcreator.smartfarming.block;

import net.minecraft.block.material.Material;

@SmartFarmingModElements.ModElement.Tag
public class Superkytka7Block extends SmartFarmingModElements.ModElement {

	@ObjectHolder("smart_farming:superkytka_7")
	public static final Block block = null;

	public Superkytka7Block(SmartFarmingModElements instance) {
		super(instance, 37);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(Block.Properties.create(Material.PLANTS).sound(SoundType.PLANT).hardnessAndResistance(1f, 1f).setLightLevel(s -> 0).notSolid()
					.setOpaque((bs, br, bp) -> false));

			setRegistryName("superkytka_7");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			Vector3d offset = state.getOffset(world, pos);
			return VoxelShapes.or(makeCuboidShape(0, 0.1, 0, 16, 16, 16)

			)

					.withOffset(offset.x, offset.y, offset.z);
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}


package net.mcreator.smartfarming.item;

@SmartFarmingModElements.ModElement.Tag
public class SulItem extends SmartFarmingModElements.ModElement {

	@ObjectHolder("smart_farming:sul")
	public static final Item block = null;

	public SulItem(SmartFarmingModElements instance) {
		super(instance, 18);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).isImmuneToFire().rarity(Rarity.COMMON));
			setRegistryName("sul");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 1;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 100F;
		}

		@Override
		public boolean canHarvestBlock(BlockState state) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("sul"));
		}

	}

}

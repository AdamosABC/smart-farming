
package net.mcreator.smartfarming.item;

@SmartFarmingModElements.ModElement.Tag
public class SmallpizaItem extends SmartFarmingModElements.ModElement {

	@ObjectHolder("smart_farming:smallpiza")
	public static final Item block = null;

	public SmallpizaItem(SmartFarmingModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(18).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.3f)

							.build()));
			setRegistryName("smallpiza");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("prost\u011B mal\u00E1 pizza"));
		}

	}

}

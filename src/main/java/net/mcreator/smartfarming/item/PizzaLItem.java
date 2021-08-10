
package net.mcreator.smartfarming.item;

@SmartFarmingModElements.ModElement.Tag
public class PizzaLItem extends SmartFarmingModElements.ModElement {

	@ObjectHolder("smart_farming:pizza_l")
	public static final Item block = null;

	public PizzaLItem(SmartFarmingModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(2).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(7).saturation(0.3f)

							.build()));
			setRegistryName("pizza_l");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("pizza se s\u00FDrem"));
		}

	}

}

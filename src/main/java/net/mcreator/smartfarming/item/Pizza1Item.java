
package net.mcreator.smartfarming.item;

@SmartFarmingModElements.ModElement.Tag
public class Pizza1Item extends SmartFarmingModElements.ModElement {

	@ObjectHolder("smart_farming:pizza_1")
	public static final Item block = null;

	public Pizza1Item(SmartFarmingModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(2).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(5).saturation(1.3f)

							.build()));
			setRegistryName("pizza_1");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("pizzza t\u011Bsto"));
		}

	}

}

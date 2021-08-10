
package net.mcreator.smartfarming.item;

@SmartFarmingModElements.ModElement.Tag
public class ChesseItem extends SmartFarmingModElements.ModElement {

	@ObjectHolder("smart_farming:chesse")
	public static final Item block = null;

	public ChesseItem(SmartFarmingModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(0.3f)

							.build()));
			setRegistryName("chesse");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("s\u00FDr"));
		}

	}

}

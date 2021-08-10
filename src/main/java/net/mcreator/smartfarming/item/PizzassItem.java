
package net.mcreator.smartfarming.item;

@SmartFarmingModElements.ModElement.Tag
public class PizzassItem extends SmartFarmingModElements.ModElement {

	@ObjectHolder("smart_farming:pizzass")
	public static final Item block = null;

	public PizzassItem(SmartFarmingModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(2).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(8).saturation(0.3f)

							.meat().build()));
			setRegistryName("pizzass");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("pizza normal"));
		}

	}

}

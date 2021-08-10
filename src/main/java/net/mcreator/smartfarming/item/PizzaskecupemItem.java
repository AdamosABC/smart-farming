
package net.mcreator.smartfarming.item;

@SmartFarmingModElements.ModElement.Tag
public class PizzaskecupemItem extends SmartFarmingModElements.ModElement {

	@ObjectHolder("smart_farming:pizzaskecupem")
	public static final Item block = null;

	public PizzaskecupemItem(SmartFarmingModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(2).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(0.3f).setAlwaysEdible().meat().build()));
			setRegistryName("pizzaskecupem");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("pizza s ke\u010Dupem"));
		}

	}

}

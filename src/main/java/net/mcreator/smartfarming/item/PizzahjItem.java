
package net.mcreator.smartfarming.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.smartfarming.SmartFarmingModElements;

import java.util.List;

@SmartFarmingModElements.ModElement.Tag
public class PizzahjItem extends SmartFarmingModElements.ModElement {
	@ObjectHolder("smart_farming:pizzahj")
	public static final Item block = null;
	public PizzahjItem(SmartFarmingModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(2).rarity(Rarity.RARE)
					.food((new Food.Builder()).hunger(8).saturation(0.3f).build()));
			setRegistryName("pizzahj");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("pizza"));
		}
	}
}

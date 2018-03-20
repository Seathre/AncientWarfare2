package net.shadowmage.ancientwarfare.vehicle.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.shadowmage.ancientwarfare.core.AncientWarfareCore;
import net.shadowmage.ancientwarfare.core.util.ModelLoaderHelper;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemAmmo extends ItemBaseVehicle {
	String tooltipName;

	public ItemAmmo(ResourceLocation registryName) {
		super(registryName.getResourcePath());

		setUnlocalizedName("ammo." + registryName.getResourcePath());
		tooltipName = "ammo." + registryName.getResourcePath() + ".tooltip";
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format(tooltipName));
	}

	@Override
	public void registerClient() {
		final Map<String, ModelResourceLocation> modelLocations = new HashMap<>();

		ModelLoaderHelper.registerItem(this, (i, m) -> new ModelResourceLocation(new ResourceLocation(AncientWarfareCore.modID, "vehicle/ammo"),
				"variant=" + getRegistryName().getResourcePath()));
	}
}
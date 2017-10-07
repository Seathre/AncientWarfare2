package net.shadowmage.ancientwarfare.core.render;

import codechicken.lib.render.CCModel;
import codechicken.lib.render.OBJParser;
import codechicken.lib.vec.RedundantTransformation;
import codechicken.lib.vec.uv.IconTransformation;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.shadowmage.ancientwarfare.core.AncientWarfareCore;

public class EngineeringStationRenderer extends BaseStationRenderer {

	public static final ModelResourceLocation MODEL_LOCATION = new ModelResourceLocation(AncientWarfareCore.modID + ":engineering_station", "normal");
	public static final EngineeringStationRenderer INSTANCE = new EngineeringStationRenderer();

	private static CCModel model;
	public static TextureAtlasSprite sprite;
	private static IconTransformation iconTransform;

	static {
		model = OBJParser.parseModels(new ResourceLocation(AncientWarfareCore.modID, "models/block/core/engineering_station.obj"), 7, new RedundantTransformation())
				.entrySet().iterator().next().getValue().backfacedCopy().computeNormals();
	}

	private EngineeringStationRenderer() {}

	public static void setSprite(TextureAtlasSprite textureAtlasSprite) {
		sprite = textureAtlasSprite;
		iconTransform = new IconTransformation(sprite);
	}

	@Override
	protected CCModel getModel() {
		return model;
	}

	@Override
	protected IconTransformation getIconTransform() {
		return iconTransform;
	}

	@Override
	protected EnumFacing getFacing(IExtendedBlockState state) {
		return state.getValue(BlockRenderProperties.UNLISTED_FACING);
	}
}
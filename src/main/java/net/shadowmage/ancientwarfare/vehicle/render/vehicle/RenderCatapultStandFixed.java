/**
 * Copyright 2012 John Cummens (aka Shadowmage, Shadowmage4513)
 * This software is distributed under the terms of the GNU General Public License.
 * Please see COPYING for precise license information.
 * <p>
 * This file is part of Ancient Warfare.
 * <p>
 * Ancient Warfare is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * Ancient Warfare is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with Ancient Warfare.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.shadowmage.ancientwarfare.vehicle.render.vehicle;

import net.shadowmage.ancientwarfare.vehicle.entity.VehicleBase;
import net.shadowmage.ancientwarfare.vehicle.helpers.VehicleFiringVarsHelper;
import net.shadowmage.ancientwarfare.vehicle.model.ModelCatapultStandFixed;
import net.shadowmage.ancientwarfare.vehicle.render.RenderVehicleBase;

public class RenderCatapultStandFixed extends RenderVehicleBase {

	ModelCatapultStandFixed model = new ModelCatapultStandFixed();

	@Override
	public void doRender(VehicleBase veh, double x, double y, double z, float yaw, float tick) {
		VehicleFiringVarsHelper var = veh.firingVarsHelper;
		model.setArmRotation(var.getVar1() + (tick * var.getVar2()));
		model.setCrankRotations(var.getVar3() + (tick * var.getVar4()));
		model.render(veh, 0, 0, 0, 0, 0, 0.0625f);
	}

	@Override
	public void renderVehicleFlag() {
		model.renderFlag();
	}

}

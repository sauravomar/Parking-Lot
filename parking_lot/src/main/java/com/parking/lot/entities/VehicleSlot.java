package com.parking.lot.entities;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.constant.VehicleType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleSlot {
	
	private String slotNo;
	private Vehicle vehicleInSlot;
	private VehicleType vehicleType;

	public boolean matchSlotNo(String slotNo) {
		if (this.slotNo.equals(slotNo))
			return true;
		return false;
	}

	public boolean isFree() {
		if (this.vehicleInSlot == null)
			return true;
		return false;
	}

	public boolean park(Vehicle vehicle, VehicleType veType) {

		if (vehicleInSlot == null && vehicleType.equals(veType)) {
			this.vehicleInSlot = vehicle;
			return true;
		}
		return false;
	}

	public boolean unParkICar() {
		if (vehicleInSlot != null) {
			this.vehicleInSlot = null;
			return true;
		}
		return false;
	}

	public String getStatus() {
		return String.format(ResponseUtil.STATUS_BODY_VEHCILE_SLOT, getSlotNo(), vehicleInSlot.status());
	}

}

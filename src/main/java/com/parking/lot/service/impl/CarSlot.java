package com.parking.lot.service.impl;

import com.parking.lot.model.Car;
import com.parking.lot.service.ICarSlot;
import com.parking.lot.util.ResponseUtil;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class CarSlot implements ICarSlot {

	private final String slotNo;
	private Car carInSlot;

	public CarSlot(String slotNo) {
		super();
		this.slotNo = slotNo;
	}

	@Override
	public boolean isFree() {
		if (this.carInSlot == null)
			return true;
		return false;
	}

	@Override
	public boolean parkCar(Car car) {

		if (carInSlot == null) {
			this.carInSlot = car;
			return true;
		}
		return false;
	}

	@Override
	public boolean unParkCar() {
		if (carInSlot != null) {
			this.carInSlot = null;
			return true;
		}
		return false;
	}

	@Override
	public boolean checkColorOfParkICar(String color) {
		if (carInSlot != null) {
			return carInSlot.matchColor(color);
		}
		return false;
	}

	@Override
	public boolean checkRegIdOfParkICar(String regId) {
		if (carInSlot != null) {
			return carInSlot.matchRegNo(regId);
		}
		return false;
	}

	@Override
	public String getParkCarRegId() {
		Car car = null;
		if (carInSlot != null) {
			car = carInSlot;
		}
		return car.getRegNo();
	}

	@Override
	public boolean matchSlotNo(String slotNo) {
		if (this.slotNo.equals(slotNo))
			return true;
		return false;
	}

	@Override
	public String getSlotNo() {
		return slotNo;
	}

	@Override
	public String getStatus() {
		return String.format(ResponseUtil.STATUS_BODY_CAR_SLOT, getSlotNo(), carInSlot.carStatus());
	}

}

package com.parking.lot.service;

import com.parking.lot.model.Car;

public interface ICarSlot {
	
	public boolean isFree();
	
	public boolean parkCar(Car car);
	
	public boolean unParkCar();
	
	public boolean checkColorOfParkICar(String color);
	
	public boolean checkRegIdOfParkICar(String regId);
	
	public String getParkCarRegId();
	
	public boolean matchSlotNo(String slotNo);

	public String getSlotNo();

	public String getStatus();

}

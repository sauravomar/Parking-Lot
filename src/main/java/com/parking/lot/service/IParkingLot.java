package com.parking.lot.service;

import com.parking.lot.model.Car;

public interface IParkingLot {
	
	public String park(Car car);
	
	public boolean unPark(String slotNo);
	

}
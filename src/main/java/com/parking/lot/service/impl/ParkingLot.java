package com.parking.lot.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.model.Car;
import com.parking.lot.service.IParkingLot;
import com.parking.lot.util.ResponseUtil;

public class ParkingLot implements IParkingLot {

	private static ParkingLot myParkingLot;

	private int parkingLotSize;

	private CarSlot[] carSlots;

	private ParkingLot(int parkingSize) {
		super();
		parkingLotSize = parkingSize;
		CarSlot[] carSlots = new CarSlot[parkingLotSize];
		for (int i = 0; i < parkingLotSize; i++) {
			carSlots[i] = new CarSlot(Integer.toString(i + 1));
		}
		this.carSlots = carSlots;
	}

	public static ParkingLot getMyParkingLotInstance() throws ParkingLotException {
		if (myParkingLot == null)
			throw new ParkingLotException(ResponseUtil.PARKING_LOT_DOES_NOT_EXIST);
		return myParkingLot;
	}

	public static boolean createParkingLot(int size) throws ParkingLotException {
		if (myParkingLot == null) {
			ParkingLot _pLot = new ParkingLot(size);
			myParkingLot = _pLot;
			return true;
		} else {
			throw new ParkingLotException(ResponseUtil.PARKING_LOT_ALREADY_EXISTS);
		}
	}

	@Override
	public String park(Car car) {

		for (CarSlot carSlot : carSlots) {
			if (carSlot.isFree()) {
				carSlot.parkCar(car);
				return carSlot.getSlotNo();
			}
		}
		return car.toString();
	}

	@Override
	public boolean unPark(String slotNo) {
		for (CarSlot carSlot : carSlots) {
			if (carSlot.matchSlotNo(slotNo) && !carSlot.isFree()) {
				carSlot.unParkCar();
				return true;
			}
		}
		return false;
	}

	public static int getParkingLotFreeStatus() {
		int count = 0;
		for (CarSlot carSlot : myParkingLot.carSlots) {
			if (carSlot.isFree())
				count++;
		}
		return count;
	}

	public static List<CarSlot>  getParkingLotFullStatus() {
		 List<CarSlot> fullSlots = new ArrayList<CarSlot>();
		for(CarSlot carSlot:myParkingLot.carSlots) {
			if(!carSlot.isFree())
				fullSlots.add(carSlot);		
		}		
		return fullSlots;
	}

}

package com.parking.lot.service;

import java.util.List;

import com.parking.lot.constant.VehicleType;
import com.parking.lot.entities.ParkingLotStatus;
import com.parking.lot.entities.Ticket;
import com.parking.lot.entities.Vehicle;
import com.parking.lot.exception.ParkingLotException;

public interface IParkingLotSvc {
	public boolean unPark(String parkingLotName, String slotNo) throws ParkingLotException;

	public List<ParkingLotStatus> getParkingLotStatus() throws ParkingLotException;

	public Ticket park(Vehicle vehicle, VehicleType vehicleType) throws ParkingLotException;

	public List<String> getRegIdsFromColor(String color) throws ParkingLotException;

	public String getSlotFromRegId(String regId) throws ParkingLotException;

	public List<String> getSlotsFromColor(String color) throws ParkingLotException;
}

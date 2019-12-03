package com.parking.lot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.constant.VehicleType;
import com.parking.lot.entities.ParkingLot;
import com.parking.lot.entities.ParkingLotStatus;
import com.parking.lot.entities.Ticket;
import com.parking.lot.entities.Vehicle;
import com.parking.lot.entities.VehicleSlot;
import com.parking.lot.exception.ParkingLotException;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ParkingLotSvc implements IParkingLotSvc {

	private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

	public boolean createParkingLot(int size, VehicleType vehType) throws ParkingLotException {

		if (size < 0)
			throw new ParkingLotException(ResponseUtil.INVALID_COMMAND);

		VehicleSlot vehcileSlots[] = new VehicleSlot[size];

		for (int i = 0; i < size; i++) {
			vehcileSlots[i] = new VehicleSlot();
			vehcileSlots[i].setSlotNo(Integer.toString(i + 1));
			vehcileSlots[i].setVehicleType(vehType);
		}

		String parkingLotName = new StringBuilder(parkingLots.size() + 1).toString();

		// Intially occupied would be zero
		parkingLots.add(new ParkingLot(parkingLotName, vehcileSlots, 0));
		return true;

	}

	@Override
	public Ticket park(Vehicle vehicle, VehicleType vehicleType) throws ParkingLotException {

		if (parkingLots.isEmpty())
			throw new ParkingLotException(ResponseUtil.SLOTS_UNDEFINED);

		ParkingLot parkingLot = getFreeParkingLot();

		for (VehicleSlot slots : parkingLot.getSlots()) {
			if (slots.isFree()) {
				slots.park(vehicle, vehicleType);
				parkingLot.setOccupied(parkingLot.getOccupied() + 1);
				return new Ticket(parkingLot.getName(), slots.getSlotNo());
			}
		}
		return null;
	}

	@Override
	public boolean unPark(String parkingLotName, String slotNo) throws ParkingLotException {

		if (parkingLots.isEmpty())
			throw new ParkingLotException(ResponseUtil.SLOTS_UNDEFINED);

		// Can be optimised
		// should be the part of ParkingLot

		for (ParkingLot parkingLot : parkingLots) {
			if (parkingLot.getName().equalsIgnoreCase(parkingLotName)) {

				// can be optmised as slotNo can be name
				if (parkingLot.getSlots().length <= Integer.parseInt(slotNo)) {
					throw new ParkingLotException(ResponseUtil.SLOTS_UNDEFINED);
				}

				VehicleSlot slots = parkingLot.getSlots()[Integer.parseInt(slotNo)];
				return slots.unParkICar();
			}

		}

		return false;
	}

	@Override
	public List<ParkingLotStatus> getParkingLotStatus() throws ParkingLotException {

		if (parkingLots == null || parkingLots.isEmpty())
			throw new ParkingLotException(ResponseUtil.SLOTS_UNDEFINED);

		List<ParkingLotStatus> result = new ArrayList<>();

		// should be the part of ParkingLot
		for (ParkingLot parkingLot : parkingLots) {

			for (VehicleSlot slots : parkingLot.getSlots()) {
				if (!slots.isFree())
					result.add(new ParkingLotStatus(parkingLot.getName(), slots.getStatus()));
			}
		}
		return result;
	}

	@Override
	public String getSlotFromRegId(String regId) throws ParkingLotException {

		// can be removed using util functions
		if (parkingLots == null || parkingLots.isEmpty())
			throw new ParkingLotException(ResponseUtil.SLOTS_UNDEFINED);

		// should be the part of ParkingLot
		for (ParkingLot parkingLot : parkingLots) {

			for (VehicleSlot slots : parkingLot.getSlots()) {
				if (!slots.isFree() && slots.getVehicleInSlot().getRegNo().equalsIgnoreCase(regId)) {
					return slots.getSlotNo();
				}
			}
		}

		return ResponseUtil.NOT_FOUND;
	}

	@Override
	public List<String> getRegIdsFromColor(String color) throws ParkingLotException {

		// can be removed using util functions
		if (parkingLots == null || parkingLots.isEmpty())
			throw new ParkingLotException(ResponseUtil.SLOTS_UNDEFINED);

		List<String> result = new ArrayList<>();

		// should be the part of ParkingLot
		for (ParkingLot parkingLot : parkingLots) {

			for (VehicleSlot slots : parkingLot.getSlots()) {
				if (!slots.isFree() && slots.getVehicleInSlot().getColour().equalsIgnoreCase(color)) {
					result.add(slots.getVehicleInSlot().getRegNo());
				}
			}
		}

		return result;
	}

	@Override
	public List<String> getSlotsFromColor(String color) throws ParkingLotException {

		// can be removed using util functions
		if (parkingLots == null || parkingLots.isEmpty())
			throw new ParkingLotException(ResponseUtil.SLOTS_UNDEFINED);

		List<String> result = new ArrayList<>();

		// should be the part of ParkingLot
		for (ParkingLot parkingLot : parkingLots) {

			for (VehicleSlot slots : parkingLot.getSlots()) {
				if (!slots.isFree() && slots.getVehicleInSlot().getColour().equalsIgnoreCase(color)) {
					result.add(slots.getSlotNo());
				}
			}
		}
		return result;
	}

	// Once Distribution strategy implemented it will moved out
	private ParkingLot getFreeParkingLot() throws ParkingLotException {

		for (ParkingLot parkingLot : parkingLots) {
			if (parkingLot.getOccupied() < parkingLot.getSlots().length)
				return parkingLot;
		}

		throw new ParkingLotException(ResponseUtil.SLOT_FULL);
	}
}

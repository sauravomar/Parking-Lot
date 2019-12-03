package com.parking.lot.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.constant.VehicleType;
import com.parking.lot.entities.Ticket;
import com.parking.lot.entities.Vehicle;
import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.ParkingLotSvc;

@Component
public class Park implements ICommand {

	private ParkingLotSvc parkingSvc;

	@Autowired
	public Park(ParkingLotSvc parkingSvc) {
		this.parkingSvc = parkingSvc;
	}

	@Override
	public String execute(List<String> params) throws ParkingLotException {
		if (params.size() == 2) {
			Vehicle vehicle = new Vehicle(params.get(0), params.get(1));
			Ticket ticket = parkingSvc.park(vehicle, VehicleType.CAR);
			if (ticket != null) {
				return String.format(ResponseUtil.SLOT_ALLOCATION_SUCCESS, ticket);
			}
			return ResponseUtil.SLOT_FULL;
		} else {
			throw new ParkingLotException(ResponseUtil.INCORRECT_COMMAND_PARAMS_NO);
		}

	}

}

package com.parking.lot.command;

import java.util.List;

import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.model.Car;
import com.parking.lot.service.IParkingLot;
import com.parking.lot.service.impl.ParkingLot;
import com.parking.lot.util.ResponseUtil;

public class ParkCar implements ICommand {

	@Override
	public String execute(List<String> params) throws ParkingLotException {
		IParkingLot myParkingLot = ParkingLot.getMyParkingLotInstance();
		if (params.size() == 2) {
			Car car = new Car(params.get(0), params.get(1));
			String parkedSlot = myParkingLot.park(car);
			if (parkedSlot != null) {
				return String.format(ResponseUtil.SLOT_ALLOCATION_SUCCESS, parkedSlot);
			}
			return ResponseUtil.PARKING_LOT_FULL;
		} else {
			throw new ParkingLotException(ResponseUtil.INCORRECT_COMMAND_PARAMS_NO);
		}

	}

}

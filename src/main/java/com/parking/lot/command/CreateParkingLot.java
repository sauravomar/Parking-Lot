package com.parking.lot.command;

import java.util.List;

import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.impl.ParkingLot;
import com.parking.lot.util.ResponseUtil;

public class CreateParkingLot implements ICommand {

	@Override
	public String execute(List<String> params) throws ParkingLotException {
		if (params.size() == 1) {
			int sizeOfParkingLot = Integer.parseInt(params.get(0));
			ParkingLot.createParkingLot(sizeOfParkingLot);

			return String.format(ResponseUtil.PARKING_LOT_CREATION_SUCCESS, sizeOfParkingLot);
		} else {
			throw new ParkingLotException(ResponseUtil.INCORRECT_COMMAND_PARAMS_NO);
		}

	}

}
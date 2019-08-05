package com.parking.lot.command;

import java.util.List;

import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.impl.CarSlot;
import com.parking.lot.service.impl.ParkingLot;
import com.parking.lot.util.ResponseUtil;

public class StatusOfSlots implements ICommand {

	@Override
	public String execute(List<String> params) throws ParkingLotException {
		if (params.size() == 1) {

			String status = params.get(0);

			if (status.equals("free")) {
				int count = ParkingLot.getParkingLotFreeStatus();
				return String.format(ResponseUtil.FREE_SLOTS, count);
			} else if (status.equals("allocated")) {

				List<CarSlot> carslots = ParkingLot.getParkingLotFullStatus();
				if (!carslots.isEmpty()) {
					return carslots.toString();
				} else {
					return ResponseUtil.PARKING_LOT_EMPTY;
				}

			} else {
				throw new ParkingLotException(ResponseUtil.NOT_A_VALID_COMMAND);
			}
		} else {
			throw new ParkingLotException(ResponseUtil.INCORRECT_COMMAND_PARAMS_NO);
		}

	}

}
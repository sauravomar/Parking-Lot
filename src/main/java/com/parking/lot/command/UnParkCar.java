package com.parking.lot.command;

import java.util.List;

import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.IParkingLot;
import com.parking.lot.service.impl.ParkingLot;
import com.parking.lot.util.ResponseUtil;

public class UnParkCar implements ICommand {

	@Override
	public String execute(List<String> params) throws ParkingLotException {
		IParkingLot myParkingLot = ParkingLot.getMyParkingLotInstance();
		if(params.size() == 1) {
			if(myParkingLot.unPark(params.get(0))) {
				return String.format(ResponseUtil.SLOT_FREED, params.get(0));
			} else {
				return String.format(ResponseUtil.SLOT_WITHOUT_CAR, params.get(0));
			}
					
		}
		return ResponseUtil.INCORRECT_COMMAND_PARAMS_NO;
	}

}
package com.parking.lot.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.constant.VehicleType;
import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.ParkingLotSvc;

@Component
public class CreateParkingLot implements ICommand {

	private static final VehicleType VEH_TYPE = VehicleType.CAR;

	private ParkingLotSvc parkingSvc;

	@Autowired
	public CreateParkingLot(ParkingLotSvc parkingSvc) {
		this.parkingSvc = parkingSvc;
	}

	@Override
	public String execute(List<String> params) throws ParkingLotException {
		if (params.size() == 1) {
			int sizeOfParkingLot = Integer.parseInt(params.get(0));
			boolean result = parkingSvc.createParkingLot(sizeOfParkingLot, VEH_TYPE);

			if (result)
				return String.format(ResponseUtil.PARKING_LOT_CREATION_SUCCESS, sizeOfParkingLot);
			else
				return String.format(ResponseUtil.PARKING_LOT_CREATION_FAILED, sizeOfParkingLot);
		} else {
			throw new ParkingLotException(ResponseUtil.INCORRECT_COMMAND_PARAMS_NO);
		}

	}
}

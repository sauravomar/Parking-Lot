package com.parking.lot.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.entities.ParkingLotStatus;
import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.ParkingLotSvc;

@Component
public class Status implements ICommand {

	private ParkingLotSvc parkingSvc;

	@Autowired
	public Status(ParkingLotSvc parkingSvc) {
		this.parkingSvc = parkingSvc;
	}

	@Override
	public String execute(List<String> params) throws ParkingLotException {
		String result = String.format(ResponseUtil.STATUS_HEADING);
		if (params.size() == 0) {
			List<ParkingLotStatus> parkingLotStatus = parkingSvc.getParkingLotStatus();

			for (ParkingLotStatus status : parkingLotStatus)
				result = String.format(ResponseUtil.STATUS_COMPLETE, result, status);
			return result.substring(0, result.length() - 1);
		} else {
			throw new ParkingLotException(ResponseUtil.INCORRECT_COMMAND_PARAMS_NO);
		}
	}
}

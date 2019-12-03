package com.parking.lot.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.ParkingLotSvc;

@Component
public class Leave implements ICommand {

	private ParkingLotSvc parkingSvc;

	@Autowired
	public Leave(ParkingLotSvc parkingSvc) {
		this.parkingSvc = parkingSvc;
	}

	@Override
	public String execute(List<String> params) throws ParkingLotException {
		if (params.size() == 1) {
			if (parkingSvc.unPark(params.get(0), params.get(1))) {
				return String.format(ResponseUtil.SLOT_FREED, params.get(0));
			} else {
				throw new ParkingLotException(String.format(ResponseUtil.SLOT_EMPTY, params.get(0)));
			}

		}
		return ResponseUtil.INCORRECT_COMMAND_PARAMS_NO;
	}

}

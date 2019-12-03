package com.parking.lot.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.ParkingLotSvc;

@Component
public class GetSlotFromColors implements ICommand {

	private ParkingLotSvc parkingSvc;

	@Autowired
	public GetSlotFromColors(ParkingLotSvc parkingSvc) {
		this.parkingSvc = parkingSvc;
	}

	@Override
	public String execute(List<String> params) throws ParkingLotException {
		if (params.size() == 1) {
			return ResponseUtil.getStringFromList(parkingSvc.getSlotsFromColor(params.get(0)));
		} else {
			throw new ParkingLotException(ResponseUtil.INCORRECT_COMMAND_PARAMS_NO);
		}
	}

}

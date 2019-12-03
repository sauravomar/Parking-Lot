package com.parking.lot.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.service.ParkingLotSvc;

@Component
public class GetSlotFromRegId implements ICommand {

	private ParkingLotSvc parkingSvc;

	@Autowired
	public GetSlotFromRegId(ParkingLotSvc parkingSvc) {
		this.parkingSvc = parkingSvc;
	}
	
	@Override
	public String execute(List<String> params) throws ParkingLotException {
		if (params.size() == 1) {
			return parkingSvc.getSlotFromRegId(params.get(0));
		} else {
			throw new ParkingLotException(ResponseUtil.INCORRECT_COMMAND_PARAMS_NO);
		}
	}

}

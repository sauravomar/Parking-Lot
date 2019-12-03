package com.parking.lot.command;

import java.util.List;

import org.springframework.stereotype.Component;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;

@Component
public class Exit implements ICommand{
	@Override
	public String execute(List<String> params) throws ParkingLotException {
		return ResponseUtil.EXIT;
	}
}

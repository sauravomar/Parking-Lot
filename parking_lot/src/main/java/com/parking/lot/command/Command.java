package com.parking.lot.command;

import java.util.List;

import com.parking.lot.exception.ParkingLotException;

public interface Command {
	public String execute(List<String> params) throws ParkingLotException;
}

package com.parking.lot.command;

import java.util.List;

import com.parking.lot.exception.ParkingLotException;

public interface ICommand {
	public String execute(List<String> params) throws ParkingLotException;
}

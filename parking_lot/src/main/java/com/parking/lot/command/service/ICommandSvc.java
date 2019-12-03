package com.parking.lot.command.service;

import com.parking.lot.command.ICommand;
import com.parking.lot.exception.ParkingLotException;

public interface ICommandSvc {

	public ICommand getCommand(String str) throws ParkingLotException;

}

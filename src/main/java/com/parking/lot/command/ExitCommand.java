package com.parking.lot.command;

import java.util.List;

import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.util.ResponseUtil;

public class ExitCommand implements ICommand {

    @Override
    public String execute(List<String> params) throws ParkingLotException {
            return ResponseUtil.EXIT;
    }

}

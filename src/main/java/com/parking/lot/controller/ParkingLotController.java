package com.parking.lot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.parking.lot.command.CommandEnum;
import com.parking.lot.exception.ParkingLotException;
import com.parking.lot.util.ResponseUtil;

public class ParkingLotController {

	public static String executeCommandFromString(String command) {
		List<String> params = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(command, " ");
		while (tokenizer.hasMoreElements()) {
			params.add(tokenizer.nextToken());
		}
		try {
			if (params.size() <= 0) {
				throw new ParkingLotException(ResponseUtil.NOT_A_VALID_COMMAND);
			}

			String commandStr = params.remove(0);

			return execute(commandStr, params);
		} catch (ParkingLotException e) {
			return e.getMessage();
		}
	}

	private static String execute(String command, List<String> params) throws ParkingLotException {

		CommandEnum com = CommandEnum.getConstants(command);
		
		if (com != null) {
			return com.getCommandAsICommandToExecute().execute(params);
		}else {
			throw new ParkingLotException("In valid Command");
		}

	}
}
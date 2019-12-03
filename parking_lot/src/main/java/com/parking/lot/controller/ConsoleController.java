package com.parking.lot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.lot.command.ICommand;
import com.parking.lot.command.service.ICommandSvc;
import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;

@Component
public class ConsoleController {
	
	private ICommandSvc commandSvc;
	
	private static final String COMMAND_SEPERATOR = " ";
	
	@Autowired
	public ConsoleController(ICommandSvc commandSvc) {
		this.commandSvc = commandSvc;
	}
	
	public String execute(String command) {
		
		List<String> params = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(command, COMMAND_SEPERATOR);
		
		// get all parameters  for commands
		while (tokenizer.hasMoreElements()) {
			params.add(tokenizer.nextToken());
		}
		
		try {
			if (params.size() <= 0) {
				throw new ParkingLotException(ResponseUtil.INVALID_COMMAND);
			}
			
			String commandStr = params.remove(0);
			ICommand commandToExecute = commandSvc.getCommand(commandStr);
			
			return commandToExecute.execute(params);
			
		} catch (ParkingLotException e) {
			return e.getMessage();
		}
	}

}

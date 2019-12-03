package com.parking.lot.command.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.parking.lot.command.ICommand;
import com.parking.lot.constant.Commands;
import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CommandSvc implements ICommandSvc {

	private ApplicationContext context;

	@Autowired
	public CommandSvc(ApplicationContext context) {
		this.context = context;
	}

	private static Map<String, Class> commandsMap = null;

	private void initialize() {
		commandsMap = new HashMap<>();
		for (Commands commandEnum : Commands.values()) {
			commandsMap.put(commandEnum.getConsoleCommand(), commandEnum.getCommand());
		}

	}

	@Override
	public ICommand getCommand(String str) throws ParkingLotException {
		if (commandsMap == null) {
			initialize();
		}
		if (!commandsMap.containsKey(str))
			throw new ParkingLotException(ResponseUtil.INVALID_COMMAND);

		return (ICommand) context.getBean(commandsMap.get(str));
	}

}

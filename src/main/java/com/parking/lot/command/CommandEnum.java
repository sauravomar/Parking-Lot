package com.parking.lot.command;

public enum CommandEnum {

	CREATE_PARKING_LOT_COMMAND("create_parking_lot", new CreateParkingLot()),

	PARK_CAR_COMMAND("park", new ParkCar()),

	UNPARK_CAR_COMMAND("leave", new UnParkCar()),

	GET_PARKING_LOT_STATUS_COMMAND("status",new StatusOfSlots()),
	
	EXIT("exit", new ExitCommand());

	private final String consoleCommand;
	private final ICommand commandToExecute;

	CommandEnum(String consoleCommand, ICommand commandToExecute) {
		this.consoleCommand = consoleCommand;
		this.commandToExecute = commandToExecute;
	}

	public String getConsoleCommandAsString() {
		return consoleCommand;
	}

	public ICommand getCommandAsICommandToExecute() {
		return commandToExecute;
	}

	public static CommandEnum getConstants(String command) {
		if (null == command)
			return null;
		for (CommandEnum sts : CommandEnum.values()) {
			if (command.equalsIgnoreCase(sts.consoleCommand)) {
				return sts;
			}
		}
		return null;
	}
}

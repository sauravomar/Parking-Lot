package com.parking.lot.constant;

import com.parking.lot.command.CreateParkingLot;
import com.parking.lot.command.Exit;
import com.parking.lot.command.GetRegNoFromColors;
import com.parking.lot.command.GetSlotFromColors;
import com.parking.lot.command.GetSlotFromRegId;
import com.parking.lot.command.Leave;
import com.parking.lot.command.Park;
import com.parking.lot.command.Status;

@SuppressWarnings("rawtypes")
public enum Commands {

	CREATE_PARKING_LOT_COMMAND("create_parking_lot", CreateParkingLot.class),

	PARK("park", Park.class),

	LEAVE("leave", Leave.class),

	STATUS("status", Status.class),

	GET_REG_NUM_FROM_COLOUR_COMMAND("registration_numbers_for_cars_with_colour", GetRegNoFromColors.class),

	GET_SLOT_NUM_FROM_COLOUR_COMMAND("slot_numbers_for_cars_with_colour", GetSlotFromColors.class),

	GET_SLOT_NUM_FROM_REG_NUM_COMMAND("slot_number_for_registration_number", GetSlotFromRegId.class),

	EXIT_COMMAND("exit", Exit.class);

	private final String consoleCommand;
	private final Class command;

	Commands(String consoleCommand, Class command) {
		this.consoleCommand = consoleCommand;
		this.command = command;
	}

	public String getConsoleCommand() {
		return consoleCommand;
	}

	public Class getCommand() {
		return command;
	}

}

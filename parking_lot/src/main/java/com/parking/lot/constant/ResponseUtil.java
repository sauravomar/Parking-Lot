package com.parking.lot.constant;

import java.util.List;

public class ResponseUtil {
	public static final String INVALID_COMMAND = "Not a valid command";

	public static final String PARKING_LOT_CREATION_SUCCESS = "Created a parking lot with %s slots";

	public static final String PARKING_LOT_CREATION_FAILED = "Failed to create a parking lot with %s slots";

	public static final String NOT_FOUND = "Not found";

	public static final String PARKING_LOT_ALREADY_EXISTS = "Parking lot already exists!";

	public static final String INCORRECT_COMMAND_PARAMS_NO = "Incorrect No of Params for Command";

	public static final String EXIT = "Shutting down Parking Lot App";

	public static final String PARKING_LOT_DOES_NOT_EXIST = "No Parking lot has been created";

	public static final String SLOT_EMPTY = "Slot number %s is already empty!!";

	public static final String SLOT_FREED = "Slot number %s is free";

	public static final String STATUS_COMPLETE = "%s%s";

	public static final String STATUS_HEADING = "Slot No.    Registration No    Colour%n";

	public static final String STATUS_BODY_VEHCILE_SLOT = "%-8s    %s%n";

	public static final String SLOT_FULL = "Sorry, parking lot is full";

	public static final String SLOT_ALLOCATION_SUCCESS = "Allocated slot number: %s";
	
    public static final String VEHICLE_STATUS = "%s      %s";
    
    public static final String FILE_NOT_FOUND = " File Not found %s";
    
    public static final String SLOTS_UNDEFINED = " Slots ae not defined, Please Create Parking Slots !!";


	public static <T> String getStringFromList(List<T> list) {
		if (list.isEmpty()) {
			return NOT_FOUND;
		}
		String result = "";
		StringBuffer sb = new StringBuffer();
		for (T item : list) {
			sb.append(item);
			sb.append(", ");
		}
		if (!list.isEmpty()) {
			result = sb.substring(0, sb.length() - 2);
		}
		return result;
	}
}

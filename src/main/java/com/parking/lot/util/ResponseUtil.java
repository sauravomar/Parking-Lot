package com.parking.lot.util;

import java.util.List;

public class ResponseUtil {

    public static final String SLOT_ALLOCATION_SUCCESS = "Allocated slot number: %s";
    
    public static final String PARKING_LOT_FULL = "Sorry, parking lot is full";
    
    public static final String SLOT_WITHOUT_CAR = "Slot number %s is without any car.";

    public static final String SLOT_FREED = "Slot number %s is free";
    
    public static final String STATUS_COMPLETE = "%s%s";

    public static final String STATUS_HEADING = "Slot No.    Registration No    Colour%n";
    
    public static final String STATUS_BODY_CAR_SLOT = "%-8s    %s%n";
    
    public static final String STATUS_BODY_CAR = "%s      %s";
    
    public static final String NOT_A_VALID_COMMAND = "Not a valid command";

    public static final String PARKING_LOT_DOES_NOT_EXIST = "No Parking lot has been created";
    
    public static final String PARKING_LOT_CREATION_SUCCESS = "Created a parking lot with %s slots";

    public static final String NOT_FOUND = "Not found";

    public static final String PARKING_LOT_ALREADY_EXISTS = "Parking lot already exists!";
    
    public static final String INCORRECT_COMMAND_PARAMS_NO = "Incorrect No of Params for Command";

	public static final String EXIT = "";

	public static final String ISSUE_IN_READING_FILE = "Issue in reading file name: %s";
	
	public static final String FREE_SLOTS = "Slots %d";
	
    public static final String PARKING_LOT_EMPTY = "Parking Lot is Empty";

    
    
    public static <T> String getStringFromList(List<T> list) {
    		if(list.isEmpty()) {
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
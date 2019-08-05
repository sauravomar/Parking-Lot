package com.parking.lot.exception;

public class ParkingLotException extends Exception {

	/**
	* 
	*/
	private static final long serialVersionUID = -213778617673967657L;

	public ParkingLotException(String errorMessage) {
		super(errorMessage);
	}

	public ParkingLotException(String errorMessage, Throwable ex) {
		super(errorMessage, ex);
	}

}

package com.parking.lot.exception;

public class ParkingLotException extends Exception {
	/**
	*
	*/
	private static final long serialVersionUID = 1163781632957333405L;

	public ParkingLotException(String message) {
		super(message);
	}

	public ParkingLotException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParkingLotException(Throwable cause) {
		super(cause);
	}

}

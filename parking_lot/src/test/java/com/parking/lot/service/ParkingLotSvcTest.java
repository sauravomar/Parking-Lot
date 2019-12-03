package com.parking.lot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.constant.VehicleType;
import com.parking.lot.entities.Vehicle;
import com.parking.lot.exception.ParkingLotException;

public class ParkingLotSvcTest {

	private ParkingLotSvc parkingLotSvc;

	@Before
	public void setup() {
		parkingLotSvc = new ParkingLotSvc();
	}

	@Test
	public void testCreateLotFailure() throws ParkingLotException {

		try {
			parkingLotSvc.createParkingLot(-1, VehicleType.CAR);
		} catch (ParkingLotException e) {
			assertEquals(ResponseUtil.INVALID_COMMAND, e.getMessage());
		}
	}

	@Test
	public void testCreateLotSuccess() throws ParkingLotException {
		boolean response = parkingLotSvc.createParkingLot(10, VehicleType.CAR);
		assertTrue(response);
	}

	@Test
	public void testCreateLotFailureAlreadyCreated() throws ParkingLotException {
		parkingLotSvc.createParkingLot(10, VehicleType.CAR);
		try {
			parkingLotSvc.createParkingLot(10, VehicleType.CAR);
		} catch (ParkingLotException e) {
			assertEquals(ResponseUtil.PARKING_LOT_ALREADY_EXISTS, e.getMessage());
		}
	}

//	@Test
//	public void testParkSuccess() throws ParkingLotException {
//		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
//		String response = parkingLotSvc.park(new Vehicle("KA-01-HH-1234", "White"), VehicleType.CAR);
//		assertEquals("1", response);
//	}

	@Test
	public void testParkFailure() throws ParkingLotException {
		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
		parkingLotSvc.park(new Vehicle("KA-01-HH-1234", "White"), VehicleType.CAR);

		try {
			parkingLotSvc.park(new Vehicle("KA-01-HH-1235", "White"), VehicleType.CAR);
		} catch (ParkingLotException e) {
			assertEquals(ResponseUtil.SLOT_FULL, e.getMessage());
		}
	}
	
//	@Test
//	public void testUnParkSuccess() throws ParkingLotException {
//		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
//		parkingLotSvc.park(new Vehicle("KA-01-HH-1234", "White"), VehicleType.CAR);
//		boolean response = parkingLotSvc.unPark("1", "1");
//		assertTrue(response);
//	}
	
	@Test
	public void testUnParkFailure() throws ParkingLotException {
		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
		boolean response = parkingLotSvc.unPark("1", "1");
		assertFalse(response);
	}
	
//	@Test
//	public void testGetParkingLotStatusSuccess() throws ParkingLotException {
//		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
//		parkingLotSvc.park(new Vehicle("KA-01-HH-1234", "White"), VehicleType.CAR);
//		List<String> response = parkingLotSvc.getParkingLotStatus();;
//		assertEquals(response.size(), 1);
//	}
//	
//	@Test
//	public void testGetParkingLotStatusFailure() throws ParkingLotException {
//		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
//		List<String> response = parkingLotSvc.getParkingLotStatus();;
//		assertEquals(response.size(), 0);
//	}
	
	@Test
	public void testGetSlotFromRegIdSuccess() throws ParkingLotException {
		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
		parkingLotSvc.park(new Vehicle("KA-01-HH-1234", "White"), VehicleType.CAR);
		String response = parkingLotSvc.getSlotFromRegId("KA-01-HH-1234");
		assertEquals(response, "1");
	}
	
	@Test
	public void testGetSlotFromRegIdFailure() throws ParkingLotException {
		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
		String response = parkingLotSvc.getSlotFromRegId("KA-01-HH-1234");
		assertEquals(response, ResponseUtil.NOT_FOUND);
	}
	
	@Test
	public void testGetRegIdsFromColorSuccess() throws ParkingLotException {
		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
		parkingLotSvc.park(new Vehicle("KA-01-HH-1234", "White"), VehicleType.CAR);
		List<String> response = parkingLotSvc.getRegIdsFromColor("White");
		assertEquals(response.size(), 1);
	}
	
	@Test
	public void testGetRegIdsFromColorFailure() throws ParkingLotException {
		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
		List<String> response = parkingLotSvc.getRegIdsFromColor("White");
		assertEquals(response.size(), 0);
	}
	
	@Test
	public void testGetSlotsFromColorSuccess() throws ParkingLotException {
		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
		parkingLotSvc.park(new Vehicle("KA-01-HH-1234", "White"), VehicleType.CAR);
		List<String> response = parkingLotSvc.getSlotsFromColor("White");
		assertEquals(response.size(), 1);
	}
	
	@Test
	public void testGetSlotsFromColorFailure() throws ParkingLotException {
		parkingLotSvc.createParkingLot(1, VehicleType.CAR);
		List<String> response = parkingLotSvc.getSlotsFromColor("White");
		assertEquals(response.size(), 0);
	}
	
	
}

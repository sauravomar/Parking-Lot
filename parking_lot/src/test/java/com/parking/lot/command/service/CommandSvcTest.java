package com.parking.lot.command.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.parking.lot.ParkingLotApplication;
import com.parking.lot.command.CreateParkingLot;
import com.parking.lot.command.ICommand;
import com.parking.lot.constant.ResponseUtil;
import com.parking.lot.exception.ParkingLotException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ParkingLotApplication.class })
public class CommandSvcTest {

	private CommandSvc commandSvc;

	@Autowired
	private ApplicationContext context;

	@Before
	public void setup() {
		commandSvc = new CommandSvc(context);
	}

	@Test
	public void testSucess() throws ParkingLotException {
		ICommand command = commandSvc.getCommand("create_parking_lot");
		assertTrue(command instanceof CreateParkingLot);
	}

	@Test
	public void testFailure() throws ParkingLotException {
		try {
			commandSvc.getCommand("test");
		} catch (ParkingLotException e) {
			assertEquals(ResponseUtil.INVALID_COMMAND, e.getMessage());
		}
	}
}

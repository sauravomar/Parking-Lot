package com.parking.lot.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.parking.lot.ParkingLotApplication;
import com.parking.lot.command.service.CommandSvc;
import com.parking.lot.constant.ResponseUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ParkingLotApplication.class })
public class ConsoleControllerTest {

	private ConsoleController consoleController;
	private CommandSvc commandSvc;

	@Autowired
	private ApplicationContext context;

	@Before
	public void setup() {
		commandSvc = new CommandSvc(context);
		consoleController = new ConsoleController(commandSvc); 
	}

	@Test
	public void testFailure() {
		String response  = consoleController.execute(" ");
		assertEquals(ResponseUtil.INVALID_COMMAND, response);
		
	}
	
	@Test
	public void testSuccess() {
		String response  = consoleController.execute("create_parking_lot 6");
		assertEquals("Created a parking lot with 6 slots", response);
		
	}

}

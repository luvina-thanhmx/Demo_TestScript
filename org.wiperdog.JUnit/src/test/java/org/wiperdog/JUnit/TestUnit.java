package org.wiperdog.JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUnit {
	
	String message;
	MessageJUnit meJUnit;
	
	@Before
	public void prepare() {
		// prepare step before a testcase run
		message = "Hello JUnit Test!";
		meJUnit = new MessageJUnit(message);
	}
	
	@After
	public void finish() {
		// finish step after a testcase run
	}
	
	@Test
	public void testMessafe() {
		assertEquals(message, meJUnit.printMessage());
	}
}

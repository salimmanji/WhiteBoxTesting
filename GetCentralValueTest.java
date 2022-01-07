package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetCentralValueTest {

	private Range actual;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}


	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetCentralValueNegToPos() {
		actual = new Range(-1, 1);
		assertEquals(0.0, actual.getCentralValue(), "The central value of (-1,1) is 0");
	}

	@Test
	void testGetCentralValuePos() {
		actual = new Range(1,10);
		assertEquals(5.5, actual.getCentralValue(), "The central value of (1,10) is 5.5");
	}

	@Test
	void testGetCentralValueNeg() {
		actual = new Range(-10, -1);
		assertEquals(-5.5, actual.getCentralValue(), "The central value of (-10,-1) is -5.5");
	}
	
	@Test
	void testGetCentralValueSame() {
		actual = new Range(0, 0);
		assertEquals(0, actual.getCentralValue(), "The central value of (0,0) is 0");
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}


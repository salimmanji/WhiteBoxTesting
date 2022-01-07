package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetLowerBoundsTest {
	
	private Range actual;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	
	
	@Test
	void testGetLowerBoundNeg() {
		actual = new Range(-10.0, -1.0);
		assertEquals(-10d, actual.getLowerBound(),"The lower bounds of (-10,-1) is -10");
	}

	@Test
	void testGetLowerBoundPos() {
		actual = new Range(1.0, 10.0);
		assertEquals(1d, actual.getLowerBound(), "The lower bounds of (1,10) is 1");
	}
	
	@Test
	void testGetLowerBoundSpanZero() {
		actual = new Range(-5, 5);
		assertEquals(-5d, actual.getLowerBound(), "The lower bounds of (-5,5) is -5");
	}
	
	@Test
	void testGetLowerBoundRangeSame() {
		actual = new Range(0,0);
		assertEquals(0d, actual.getLowerBound(), "The lower bounds of (0,0) is 0");
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}

package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetUpperBoundsTest {
	
	private Range actual;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}


	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testGetUpperBoundNeg() {
		actual = new Range(-10, -1);
		assertEquals(-1d, actual.getUpperBound(),"The upper bounds of (-10,-1) is -1");
	}
	
	@Test
	void testGetUpperBoundPos() {
		actual = new Range(1, 10);
		assertEquals(10d, actual.getUpperBound(),"The upper bounds of (1,10) is 10");
	}
	
	@Test
	void testGetUpperBoundNegToPos() {
		actual = new Range(-5, 5);
		assertEquals(5d, actual.getUpperBound(), "The upper bounds of (-5,5) is 5");
	}
	
	@Test
	void testGetUpperBoundRangeSame() {
		actual = new Range(0,0);
		assertEquals(0d, actual.getUpperBound(), "The upper bounds of (0,0) is 0");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}

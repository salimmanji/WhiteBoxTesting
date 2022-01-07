package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntersectsTest {

	private Range actual;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}


	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testIntersectsNegToPosLess() {
		actual = new Range(-1, 1);
		assertFalse(actual.intersects(-20, -5), "The range (-20,-5) does NOT intersect with range (-1,1)");
	}
	
	@Test
	void testIntersectsNegToPosWithin() {
		actual = new Range(-1, 1);
		assertTrue(actual.intersects(0,20), "The range (0,20) intersects with range (-1,1)");
	}
	
	@Test
	void testIntersectsNegToPosGreater() {
		actual = new Range(-1, 1);
		assertFalse(actual.intersects(5,20), "The range (5,20) does NOT intersect with range (-1,1)");
	}

	@Test
	void testIntersectsPosLess() {
		actual = new Range(1, 10);
		assertFalse(actual.intersects(-10, -2), "The range (-10,-2) does NOT intersect with range (1,10)");
	}
	
	@Test
	void testIntersectsPosWithin() {
		actual = new Range(1, 10);
		assertTrue(actual.intersects(0,20), "The range (0,20) intersects with range (1,10)");
	}
	
	@Test
	void testIntersectsPosWithinActual() {
		actual = new Range(1, 10);
		assertTrue(actual.intersects(5,7), "The range (5,7) intersects with range (1,10)");
	}
	
	@Test
	void testIntersectsPosLarger() {
		actual = new Range(1, 10);
		assertTrue(actual.intersects(7,20), "The range (7,20) intersects with range (1,10)");
	}
	
	@Test
	void testIntersectsPosSmaller() {
		actual = new Range(1, 10);
		assertTrue(actual.intersects(-10,5), "The range (-10,5) intersects with range (1,10)");
	}
	
	@Test
	void testIntersectsPosSwapped() {
		actual = new Range(1, 10);
		assertFalse(actual.intersects(5, -10), "The range (5, -10) intersects with range (1,10)");
	}
	
	@Test
	void testIntersectsPosGreater() {
		actual = new Range(1, 10);
		assertFalse(actual.intersects(15,25), "The range (15,25) does NOT intersect with range (1,10)");
	}
	
	@Test
	void testIntersectsNegLess() {
		actual = new Range(-10, -1);
		assertFalse(actual.intersects(-25,-15), "The range (-25,-15) does NOT intersect with range (-10,-1)");
	}
	
	@Test
	void testIntersectsNegWithin() {
		actual = new Range(-10, -1);
		assertTrue(actual.intersects(-5,20), "The range (-5,20) intersects with range (1,10)");
	}
	
	@Test
	void testIntersectsNegGreater() {
		actual = new Range(-10, -1);
		assertFalse(actual.intersects(5,20), "The range (5,25) does NOT intersect with range (-10,-1)");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}


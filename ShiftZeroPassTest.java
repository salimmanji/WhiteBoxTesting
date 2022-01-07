package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShiftZeroPassTest{
	
	private Range actual;
	private Range expected;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testPos() {
		actual = new Range(-1,9 );
		expected = new Range(1, 11);
		actual = Range.shift(actual,2);
		assertAll (() -> assertEquals(expected, actual, "The new range should be (1, 11)"),
				() -> assertEquals(1, actual.getLowerBound(), "The lower bound of the new range should be 1"),
				() -> assertEquals(11, actual.getUpperBound(), "The upper bound of the new range should be 11")
				);	
	}
	@Test
	void testNeg() {
		actual = new Range(1,10);
		expected = new Range(-1,8);
		actual = Range.shift(actual,-2);
		assertAll (() -> assertEquals(expected, actual, "The new range should be (-1, 8)"),
				() -> assertEquals(-1, actual.getLowerBound(), "The lower bound of the new range should be 1"),
				() -> assertEquals(8, actual.getUpperBound(), "The upper bound of the new range should be 8")
				);	
	}
	
	@Test
	void testNegRangeAllowZero() {
		actual = new Range(1,10);
		expected = new Range(-1,8);
		actual = Range.shift(actual,-2, true);
		assertAll (() -> assertEquals(expected, actual, "The new range should be (-1, 8)"),
				() -> assertEquals(-1, actual.getLowerBound(), "The lower bound of the new range should be 1"),
				() -> assertEquals(8, actual.getUpperBound(), "The upper bound of the new range should be 8")
				);	
	}
	

	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}

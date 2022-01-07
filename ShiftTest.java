package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShiftTest{
	
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
		actual = new Range(1, 10);
		expected = new Range(2, 11);
		actual = Range.shift(actual, 1);
		assertAll (() -> assertEquals(expected, actual, "The new range should be (2-11)"),
				() -> assertEquals(2, actual.getLowerBound(), "The lower bound of the new range should be 2"),
				() -> assertEquals(11, actual.getUpperBound(), "The upper bound of the new range should be 11")
				);	
	}
	@Test
	void testNeg() {
		actual = new Range(-10, -2);
		expected = new Range(-9,-1);
		actual = Range.shift(actual, 1);
		assertAll (() -> assertEquals(expected, actual, "The new range should be (-9,-1)"),
				() -> assertEquals(-9, actual.getLowerBound(), "The lower bound of the new range should be -9"),
				() -> assertEquals(-1, actual.getUpperBound(), "The upper bound of the new range should be -1")
				);	
	}
	@Test
	void testZeroLower() {
		actual = new Range(0, 10);
		expected = new Range(1, 11);
		actual = Range.shift(actual, 1);
		assertAll (() -> assertEquals(expected, actual, "The new range should be (1,11)"),
				() -> assertEquals(1, actual.getLowerBound(), "The lower bound of the new range should be 1"),
				() -> assertEquals(11, actual.getUpperBound(), "The upper bound of the new range should be 11")
				);	
	}
	@Test
	void testZeroShift() {
		actual = new Range(0, 10);
		expected = new Range(0, 10);
		actual = Range.shift(actual, 0);
		assertAll (() -> assertEquals(expected, actual, "The new range should be (0, 10)"),
				() -> assertEquals(0, actual.getLowerBound(), "The lower bound of the new range should be 0"),
				() -> assertEquals(10, actual.getUpperBound(), "The upper bound of the new range should be 10")
				);	
	}
	@Test
	void testNegShift() {
		actual = new Range(2, 11);
		expected = new Range(1, 10);
		actual = Range.shift(actual, -1);
		assertAll (() -> assertEquals(expected, actual, "The new range should be (1,10)"),
				() -> assertEquals(1, actual.getLowerBound(), "The lower bound of the new range should be 1"),
				() -> assertEquals(10, actual.getUpperBound(), "The upper bound of the new range should be 10")
				);	
	}

	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}

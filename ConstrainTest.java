package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstrainTest {

	private Range actual;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testConstrainNegMin() {
		actual = new Range(-10, -1);
		assertEquals(-10d, actual.constrain(-10), "The closest value to -10 (min) in the range is -10");
	}

	@Test
	void testConstrainNegMinPlus() {
		actual = new Range(-10, -1);
		assertEquals(-9d, actual.constrain(-9), "The closest value to -9 (min Plus) in the range is -9");
	}

	@Test
	void testConstrainNegNom() {
		actual = new Range(-10, -1);
		assertEquals(-5d, actual.constrain(-5), "The closest value to -5 in the range is -5");
	}

	@Test
	void testConstrainNegMaxMinus() {
		actual = new Range(-10, -1);
		assertEquals(-2d, actual.constrain(-2), "The closest value to -2 (max minus) in the range is -2");
	}

	@Test
	void testConstrainNegMax() {
		actual = new Range(-10, -1);
		assertEquals(-1d, actual.constrain(-1), "The closest value to -1 (max) in the range is -1");
	}

	@Test
	void testConstrainPosMin() {
		actual = new Range(1, 10);
		assertEquals(1d, actual.constrain(1), "The closest value to 1 in the range is 1");
	}

	@Test
	void testConstrainPosMinPlus() {
		actual = new Range(1, 10);
		assertEquals(2d, actual.constrain(2), "The closest value to 2 in the range is 2");
	}

	@Test
	void testConstrainPosNom() {
		actual = new Range(1, 10);
		assertEquals(5d, actual.constrain(5), "The closest value to 5 in the range is 5");
	}

	@Test
	void testConstrainPosMaxMinus() {
		actual = new Range(1, 10);
		assertEquals(9d, actual.constrain(9), "The closest value to 9 in the range is 9");
	}

	@Test
	void testConstrainMax() {
		actual = new Range(1, 10);
		assertEquals(10d, actual.constrain(10), "The closest value to 10 in the range is 10");
	}

	@Test
	void testConstrainNegtoPosMin() {
		actual = new Range(-10, 10);
		assertEquals(-10d, actual.constrain(-10), "The closest value to -10 in the range is -10");
	}
	
	@Test
	void testConstrainNegtoPosMinMinus() {
		actual = new Range(-10, 10);
		assertEquals(-9d, actual.constrain(-9), "The closest value to -9 in the range is -9");
	}
	
	@Test
	void testConstrainNegtoPosNom() {
		actual = new Range(-10, 10);
		assertEquals(0d, actual.constrain(0), "The closest value to 0 in the range is 0");
	}
	
	@Test
	void testConstrainNegtoPosMaxMinus() {
		actual = new Range(-10, 10);
		assertEquals(9d, actual.constrain(9), "The closest value to 9 in the range is 9");
	}
	
	@Test
	void testConstrainNegtoPosMax() {
		actual = new Range(-10, 10);
		assertEquals(10d, actual.constrain(10), "The closest value to 10 in the range is 10");
	}

	@Test
	void testConstrainSame() {
		actual = new Range(0, 0);
		assertEquals(0d, actual.constrain(0), "The closest value to 0 in the range is 0");
	}
	
	@Test
	void testOutOfBoundsGreater() {
		actual = new Range(1, 10);
		assertEquals(10d, actual.constrain(20.0), "The closest value to 20 in the range is 10");
	}
	
	@Test
	void testOutOfBoundsLower() {
		actual = new Range(1, 10);
		assertEquals(1d, actual.constrain(-5), "The closest value to -5 in the range is 1");
	}
	
	@Test
	void testCloseToLower() {
		actual = new Range(1, 10);
		assertEquals(1.75, actual.constrain(1.75), "The closest value to 1.75 in the range is 1");
	}
	
	void testConstrainNull() {
		actual = null;
		assertThrows(InvalidParameterException.class, () -> actual.constrain(0), "A null range throws an exception");
	}
	
	void testConstrainNonExistantValue() {
		actual = new Range (0, 10);
		assertEquals(10d, actual.constrain(20), "20 doesn't exist and should return 10");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
}

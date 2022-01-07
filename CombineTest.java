package org.jfree.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombineTest {

	private Range actual;
	private Range range1;
	private Range range2;
	private Range expected;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testCombineTwoPos() {
		range1 = new Range(10, 20);
		range2 = new Range(5, 15);
		expected = new Range(5, 20);
		actual = Range.combine(range1, range2);

		assertAll(() -> assertEquals(expected.getLowerBound(), actual.getLowerBound(), "Lower Bound should be 5"),
				() -> assertEquals(expected.getUpperBound(), actual.getUpperBound(), "Upper Bound should be 50"),
				() -> assertEquals(5, actual.getLowerBound(), "The lower bound is actually 5"),
				() -> assertEquals(20, actual.getUpperBound(), "The upper bound is actually 50")
				);
	}

	@Test
	void testCombineTwoNeg() {
		range1 = new Range(-10, -1);
		range2 = new Range(-50, -3);
		expected = new Range(-50, -1);
		actual = Range.combine(range1, range2);

		assertAll(() -> assertEquals(expected.getLowerBound(), actual.getLowerBound(), "Lower Bound should be -50"),
				() -> assertEquals(expected.getUpperBound(), actual.getUpperBound(), "Upper Bound should be -1"),
				() -> assertEquals(-50, actual.getLowerBound(), "The lower bound is actually -50"),
				() -> assertEquals(-1, actual.getUpperBound(), "The upper bound is actually -1")
				);
	}

	@Test
	void testCombineNegWithPos() {
		range1 = new Range(-10, 5);
		range2 = new Range(0, 20);
		expected = new Range(-10, 20);
		actual = Range.combine(range1, range2);

		assertAll(() -> assertEquals(expected.getLowerBound(), actual.getLowerBound(), "Lower Bounds should be same"),
				() -> assertEquals(expected.getUpperBound(), actual.getUpperBound(), "Upper Bounds should be same"),
				() -> assertEquals(-10.0, actual.getLowerBound(), "The lower bound is actually -10"),
				() -> assertEquals(20, actual.getUpperBound(), "The upper bound is actually 20")
				);
	}
	
	@Test
	void testCombinePosWithNeg() {
		range1 = new Range(0, 20);
		range2 = new Range(-10, 5);
		expected = new Range(-10, 20);
		actual = Range.combine(range1, range2);

		assertAll(() -> assertEquals(expected.getLowerBound(), actual.getLowerBound(), "Lower Bound should be -10"),
				() -> assertEquals(expected.getUpperBound(), actual.getUpperBound(), "Upper Bound should be 20"),
				() -> assertEquals(-10.0, actual.getLowerBound(), "The lower bound is actually -10"),
				() -> assertEquals(20, actual.getUpperBound(), "The upper bound is actually 20")
				);
	}
	
	@Test
	void testCombinePoswithNeg() {
		range1 = new Range(0.0, 20);
		range2 = new Range(-10.0, 5);
		expected = new Range(-10.0, 20);
		
		actual = Range.combine(range1, range2);

		assertAll(() -> assertEquals(expected.getLowerBound(), actual.getLowerBound(), "Lower Bound should be -10"),
				() -> assertEquals(expected.getUpperBound(), actual.getUpperBound(), "Upper Bound should be 20"));
	}
	
	@Test
	void testCombineRange1Null() {
		range1 = null;
		range2 = new Range(-10.0, 5);
		expected = new Range(-10.0, 5);
		
		actual = Range.combine(range1, range2);

		assertAll(() -> assertEquals(expected, actual, "The range should be (-10,5)"),
				() -> assertEquals(5, actual.getUpperBound(), "The upper bound should be 5"),
				() -> assertEquals(-10, actual.getLowerBound(), "The lower bound should be -10"));
	}
	
	@Test
	void testCombineRange2Null() {
		range1 = new Range(-10.0, 5);
		range2 = null;
		expected = new Range(-10.0, 5);
		
		actual = Range.combine(range1, range2);

		assertAll(() -> assertEquals(expected, actual, "The range should be (-10,5)"),
				() -> assertEquals(5, actual.getUpperBound(), "The upper bound should be 5"),
				() -> assertEquals(-10, actual.getLowerBound(), "The lower bound should be -10"));
	}
	
	@Test
	void testCombineRangeBothNull() {
		range1 = null;
		range2 = null;
		expected = null;
		
		actual = Range.combine(range1, range2);

		assertEquals(expected, actual);
	}
	

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
}

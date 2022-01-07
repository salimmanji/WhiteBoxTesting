package org.jfree.data;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataUtilitiesTest {
	private Values2D value;
	private KeyedValues keyValue;
	private KeyedValues nullValues;
	private ArrayList<Integer> keyList;

	@BeforeEach
	void setUp() throws Exception {
		value = mock(Values2D.class);
		when(value.getColumnCount()).thenReturn(4);
		when(value.getRowCount()).thenReturn(3);
		when(value.getValue(0, 2)).thenReturn(5.5);
		when(value.getValue(1, 2)).thenReturn(7.7);
		when(value.getValue(2, 2)).thenReturn(1.1);
		when(value.getValue(0, 1)).thenReturn(3.3);
		when(value.getValue(1, 1)).thenReturn(4.4);
		when(value.getValue(1, 3)).thenReturn(6.6);

	}

	@Test
	void testPosCalcColTotal() {
		assertEquals(14.3, DataUtilities.calculateColumnTotal(value, 2), .01d);
		verify(value, times(3)).getValue(anyInt(), anyInt());
	}

	@Test
	void testPosCalcRowTotal() {
		assertEquals(22, DataUtilities.calculateRowTotal(value, 1), .01d);
		verify(value, times(4)).getValue(anyInt(), anyInt());
	}

	@Test
	void testCreateNumberArray() {
		double[] primArray = { (double) value.getValue(0, 2), (double) value.getValue(1, 2),
				(double) value.getValue(2, 2) };
		Number[] actual = DataUtilities.createNumberArray(primArray);

		assertAll(() -> assertEquals(Number[].class, actual.getClass()),
				() -> assertEquals(value.getValue(0, 2), actual[0]),
				() -> assertEquals(value.getValue(1, 2), actual[1]),
				() -> assertEquals(value.getValue(2, 2), actual[2]));
	}

	@Test
	void testCreateNumberArrayObj() {
		double[] expected = null;
		assertThrows(InvalidParameterException.class, () -> DataUtilities.createNumberArray(expected));
	}

	@Test
	void testCreateNumberArray2D() {
		double[][] actual = { { 0.0, 0.1, 0.2, 0.3 }, { 0.1, 1.1, 1.2, 1.3 }, { 0.2, 1.2, 2.2, 2.3 } };

		Number[][] numArray = DataUtilities.createNumberArray2D(actual);
		assertAll(() -> assertEquals(Number[][].class, numArray.getClass()),
				() -> assertEquals(numArray[0][2], actual[0][2]), () -> assertEquals(numArray[1][2], actual[1][2]),
				() -> assertEquals(numArray[2][2], actual[2][2]), () -> assertThrows(InvalidParameterException.class,
						() -> DataUtilities.createNumberArray2D(null), "A null object throws an exception"));
	}

	@Test
	void testGetCumulativePercentages() {
		keyValue = mock(KeyedValues.class);
		keyList = new ArrayList<>();
		keyList.add(0);
		keyList.add(1);
		keyList.add(2);

		when(keyValue.getItemCount()).thenReturn(3);

		when(keyValue.getKey(0)).thenReturn(0);
		when(keyValue.getKey(1)).thenReturn(1);
		when(keyValue.getKey(2)).thenReturn(2);

		when(keyValue.getIndex(0)).thenReturn(0);
		when(keyValue.getIndex(1)).thenReturn(1);
		when(keyValue.getIndex(2)).thenReturn(2);

		when(keyValue.getKeys()).thenReturn(keyList);

		when(keyValue.getValue(0)).thenReturn(5);
		when(keyValue.getValue(1)).thenReturn(9);
		when(keyValue.getValue(2)).thenReturn(2);

		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValue);

		assertAll(() -> assertEquals(0.3125, actual.getValue(0).doubleValue(), 0.01d, "5/16 = 0.3125"),
				() -> assertEquals(0.875, actual.getValue(1).doubleValue(), 0.01d, "14/16 = 0.875"),
				() -> assertEquals(1.0, actual.getValue(2).doubleValue(), 0.01d, "16/16 = 1.0"),
				() -> assertEquals(keyList, actual.getKeys(), "The keys should be (0, 1, 2)"),
				() -> assertEquals(-1, actual.getIndex(20), "Since the key does not exist, the return should be -1"),
				() -> assertThrows(InvalidParameterException.class,
						() -> DataUtilities.getCumulativePercentages(nullValues), "A null object throws an exception"),
				() -> assertThrows(IndexOutOfBoundsException.class, () -> actual.getKey(20),
						"Unknown Exception thrown if key does not exist"),
				() -> assertThrows(UnknownKeyException.class, () -> actual.getValue(20),
						"An unrecognized key should throw an unknown key exception")

		);

	}
	
	@Test
	void testGetCumulativePercentagesWithNull() {
		keyValue = mock(KeyedValues.class);
		keyList = new ArrayList<>();
		keyList.add(0);
		keyList.add(1);
		keyList.add(2);

		when(keyValue.getItemCount()).thenReturn(3);

		when(keyValue.getKey(0)).thenReturn(0);
		when(keyValue.getKey(1)).thenReturn(1);
		when(keyValue.getKey(2)).thenReturn(2);

		when(keyValue.getIndex(0)).thenReturn(0);
		when(keyValue.getIndex(1)).thenReturn(1);
		when(keyValue.getIndex(2)).thenReturn(2);

		when(keyValue.getKeys()).thenReturn(keyList);

		when(keyValue.getValue(0)).thenReturn(5);
		when(keyValue.getValue(1)).thenReturn(9);
		when(keyValue.getValue(2)).thenReturn(null);

		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValue);

		assertAll(() -> assertEquals(0.3125, actual.getValue(0).doubleValue(), 0.01d, "5/16 = 0.3125"),
				() -> assertEquals(0.875, actual.getValue(1).doubleValue(), 0.01d, "14/16 = 0.875"),
				() -> assertEquals(keyList, actual.getKeys(), "The keys should be (0, 1, 2)"),
				() -> assertEquals(-1, actual.getIndex(20), "Since the key does not exist, the return should be -1"),
				() -> assertThrows(InvalidParameterException.class,
						() -> DataUtilities.getCumulativePercentages(nullValues), "A null object throws an exception"),
				() -> assertThrows(IndexOutOfBoundsException.class, () -> actual.getKey(20),
						"Unknown Exception thrown if key does not exist"),
				() -> assertThrows(UnknownKeyException.class, () -> actual.getValue(20),
						"An unrecognized key should throw an unknown key exception")
		);

	}
}
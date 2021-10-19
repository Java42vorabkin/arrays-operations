package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.util.ArraysOperations.*;

class ArraysOperationsTests {

	private static final String INSERTED_STRING = "World and ";
	private static final int INSERTED_NUMBER = 100;

	@Test
	void testInsert() {
		//  ================Strings==============================================
		String arStr[] = {"hello", "Java"}; 
		String expectedStr[] = {"hello", INSERTED_STRING, "Java"}; 
		String actualStr[] = new String[arStr.length + 1];
		int indexInsert = 1;
		assertEquals(OK, insert(arStr, INSERTED_STRING, indexInsert, actualStr));
		assertArrayEquals(expectedStr, actualStr);
		assertEquals(WRONG_INDEX,insert(arStr, INSERTED_STRING, 100, actualStr));
		actualStr = new String[1];
		assertEquals(WRONG_RESULT_LENGTH,insert(arStr, INSERTED_STRING, indexInsert, actualStr));
		//==============Integers=============================================
		Integer numbers[] = {1, 2, 3};
		indexInsert = 0;
		Integer actualNumbers[] = new Integer[numbers.length + 1];
		Integer expectedFirst[] = {INSERTED_NUMBER, 1, 2, 3};
		insert(numbers,INSERTED_NUMBER, indexInsert, actualNumbers );
		assertArrayEquals(expectedFirst, actualNumbers);
		indexInsert = numbers.length;
		Integer expectedLast[] = { 1, 2, 3, INSERTED_NUMBER};
		insert(numbers,INSERTED_NUMBER, indexInsert, actualNumbers );
		assertArrayEquals(expectedLast, actualNumbers);
				
	}

	@Test
	void testRemove() {
		//==============Integers=============================================
		Integer numbers[] = {1, 2, 3};
		Integer actualNum[] = new Integer[numbers.length-1];
		int indexRemoveNum = 2;
		Integer expectedNum[] = {1, 2};
		assertEquals(OK, remove(numbers, indexRemoveNum, actualNum));
		assertArrayEquals(expectedNum, actualNum);
		//  ================Strings==============================================
		String strings[] = {"Holon", "Jerusalem", "Raanana", "Tel-Aviv", "Haifa"};
		String actualStr[] = new String[strings.length-1];
		int indexRemoveStr = 1;
		String expectedStr[] = {"Holon", "Raanana", "Tel-Aviv", "Haifa"};
		assertEquals(OK, remove(strings, indexRemoveStr, actualStr));
		assertArrayEquals(expectedStr, actualStr);
		assertEquals(WRONG_INDEX, remove(strings, 100, actualStr));
		actualStr = new String[1];
		assertEquals(WRONG_RESULT_LENGTH, remove(strings, indexRemoveStr, actualStr));
	}

	@Test
	void testInsertSorted() {
		//==============Integers=============================================
		Integer numbers[] = {10, 20, 50};
		Integer keyNumOut=40, keyNumIn=20;
		Integer expectedNumOut[] = {10, 20, 40, 50};
		Integer expectedNumIn[] = {10, 20, 20, 50};
		Integer actualNumIn[] = new Integer[numbers.length+1];
		Integer actualNumOut[] = new Integer[numbers.length+1];
		Integer actualNumF[] = new Integer[numbers.length-2];
		assertEquals(OK, insertSorted(numbers, keyNumOut, actualNumOut));
		assertArrayEquals(expectedNumOut, actualNumOut);
		assertEquals(WRONG_RESULT_LENGTH, insertSorted(numbers, keyNumOut, actualNumF));
		assertEquals(OK, insertSorted(numbers, keyNumIn, actualNumIn));
		assertArrayEquals(expectedNumIn, actualNumIn);
		//================Strings===============================================
		String strings[] = {"10", "20", "50"};
		String keyStrOut="40", keyStrIn="20";
		String expectedStrOut[] = {"10", "20", "40", "50"};
		String expectedStrIn[] = {"10", "20", "20", "50"};
		String actualStrIn[] = new String[strings.length+1];
		String actualStrOut[] = new String[strings.length+1];
		String actualStrF[] = new String[numbers.length-2];
		assertEquals(OK, insertSorted(strings, keyStrOut, actualStrOut));
		assertArrayEquals(expectedStrOut, actualStrOut);
		assertEquals(WRONG_RESULT_LENGTH, insertSorted(strings, keyStrOut, actualStrF));
		assertEquals(OK, insertSorted(strings, keyStrIn, actualStrIn));
		assertArrayEquals(expectedStrIn, actualStrIn);
		
	}

	@Test
	void testAddLast() {
		//==============Integers=============================================
		Integer numbers[] = {1, 2, 3};
		Integer expectedNum[] = {1, 2,3, 4};
		Integer actualNum[] = new Integer[numbers.length+1];
		assertEquals(OK, addLast(numbers, 4, actualNum));
		assertArrayEquals(expectedNum, actualNum);
		actualNum = new Integer[numbers.length];
		assertEquals(WRONG_RESULT_LENGTH, addLast(numbers, 4, actualNum));
		//==============Strings=================
		String strings[] = {"Holon", "Jerusalem", "Raanana", "Tel-Aviv"};
		String expectedStr[] = {"Holon", "Jerusalem", "Raanana", "Tel-Aviv", "Haifa"};
		String actualStr[] = new String[strings.length+1];
		assertEquals(OK, addLast(strings, "Haifa", actualStr));
		assertArrayEquals(expectedStr, actualStr);
	}

	@Test
	void testAddFirst() {
		//==============Integers=============================================
		Integer numbers[] = {1, 2, 3};
		Integer expectedNum[] = {0, 1, 2, 3};
		Integer actualNum[] = new Integer[numbers.length+1];
		assertEquals(OK, addFirst(numbers, 0, actualNum));
		assertArrayEquals(expectedNum, actualNum);
		actualNum = new Integer[numbers.length];
		assertEquals(WRONG_RESULT_LENGTH, addFirst(numbers, 4, actualNum));
		//===============Strings===============
		String strings[] = {"Holon", "Jerusalem", "Raanana", "Tel-Aviv"};
		String expectedStr[] = {"Haifa", "Holon", "Jerusalem", "Raanana", "Tel-Aviv"};
		String actualStr[] = new String[strings.length+1];
		assertEquals(OK, addFirst(strings, "Haifa", actualStr));
		assertArrayEquals(expectedStr, actualStr);
	}
}

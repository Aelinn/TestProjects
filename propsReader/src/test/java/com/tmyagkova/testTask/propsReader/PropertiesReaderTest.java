package com.tmyagkova.testTask.propsReader;

import java.util.Properties;

import javax.script.ScriptException;

import org.junit.Test;

import junit.framework.TestCase;

public class PropertiesReaderTest extends TestCase {

	@Test
	public void testPrintPropertiesCorrectPropertiesFileName() {
		String[] testArguments = { "d:\\TestTask\\externalProps.properties" };
		try {
			Properties properties = (Properties) PropertiesReader
					.printProperties(testArguments);
			assertEquals(3, properties.size());
			assertTrue(7 > properties.size());
			assertFalse(10 < properties.size());
			assertTrue(properties.containsKey("EXTERNALkey2"));
			assertEquals("EXTERNALproperty1", properties.get("EXTERNALkey1"));
			assertTrue(properties.contains("EXTERNALproperty3"));
		} catch (ScriptException e) {
			fail(e.getMessage());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testPrintPropertiesIncorrectPropertiesFileName() {
		String[] testArguments = { "Hello World!" };
		try {
			PropertiesReader.printProperties(testArguments);
			fail();
		} catch (Exception e) {

		}
	}

	@Test
	public void testPrintPropertiesEmptyPropertiesFileName() {
		String[] testArguments = { "" };
		try {
			Properties properties = (Properties) PropertiesReader
					.printProperties(testArguments);
			assertEquals(5, properties.size());
			assertTrue(7 > properties.size());
			assertFalse(10 < properties.size());
			assertTrue(properties.containsKey("key1"));
			assertEquals("property2", properties.get("key2"));
			assertTrue(properties.contains("property4"));
		} catch (ScriptException e) {
			fail(e.getMessage());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testPrintPropertiesNullPropertiesFileName() {
		String[] testArguments = { null };
		try {
			Properties properties = (Properties) PropertiesReader
					.printProperties(testArguments);
			assertEquals(5, properties.size());
			assertTrue(7 > properties.size());
			assertFalse(10 < properties.size());
		} catch (ScriptException e) {
			e.printStackTrace();
			fail();
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testPrintPropertiesTwoArgumentsFirstIsIncorrect() {
		String[] testArguments = { "Hello World!",
				"d:\\TestTask\\externalProps.properties" };
		try {
			PropertiesReader.printProperties(testArguments);
			fail();
		} catch (Exception e) {

		}
	}

	@Test
	public void testPrintPropertiesTwoArgumentsFirstIsCorrect() {
		String[] testArguments = { "d:\\TestTask\\externalProps.properties",
				"Hello World!" };
		try {
			Properties properties = (Properties) PropertiesReader
					.printProperties(testArguments);
			assertEquals(3, properties.size());
			assertTrue(7 > properties.size());
			assertFalse(10 < properties.size());
			assertTrue(properties.containsKey("EXTERNALkey2"));
			assertEquals("EXTERNALproperty1", properties.get("EXTERNALkey1"));
			assertTrue(properties.contains("EXTERNALproperty3"));
		} catch (ScriptException e) {
			fail(e.getMessage());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testPrintPropertiesTwoArgumentsIsFirstEmpty() {
		String[] testArguments = { "", "Hello World!" };
		try {
			Properties properties = (Properties) PropertiesReader
					.printProperties(testArguments);
			assertEquals(5, properties.size());
			assertTrue(7 > properties.size());
			assertFalse(10 < properties.size());
			assertTrue(properties.containsKey("key1"));
			assertEquals("property2", properties.get("key2"));
			assertTrue(properties.contains("property4"));
		} catch (ScriptException e) {
			fail(e.getMessage());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}

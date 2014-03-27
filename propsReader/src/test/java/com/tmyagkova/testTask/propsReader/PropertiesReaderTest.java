package com.tmyagkova.testTask.propsReader;

import org.junit.Test;

import junit.framework.TestCase;

public class PropertiesReaderTest extends TestCase {
	private PropertiesReader propertiesReader = new PropertiesReader();

	@Test
	public void testValidateFileNameWinForwardSlash() {
		String fileName = "d:/TestTask/externalProps.properties";
		assertEquals("Number of properties: 3", propertiesReader.printPropertiesFromFile(fileName));
	}

	@Test
	public void testValidateFileNameWinBackSlash() {
		String fileName = "d:\\TestTask\\externalProps.properties";
		assertEquals("Number of properties: 3", propertiesReader.printPropertiesFromFile(fileName));
	}

	@Test
	public void testValidateInvalidFileName() {
		String fileName = "Hello world";
		assertEquals("Incorrect file name.",
				propertiesReader.printPropertiesFromFile(fileName));
	}

	@Test
	public void testExistFileName() {
		String fileName = "d:\\TestTask\\MockFile.properties";
		assertEquals("File is not exists.",
				propertiesReader.printPropertiesFromFile(fileName));
	}

}

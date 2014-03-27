package com.tmyagkova.testTask.propsReader;

import java.io.FileNotFoundException;

public class Main {
	private static final String DEFAULT_FILE_NAME = "D:\\TestTask\\testTask.properties";

	public static void main(String[] args) throws FileNotFoundException {
		String result = "";
		PropertiesReader propertiesReader = new PropertiesReader();
		if (args.length > 0)
			result = propertiesReader.printPropertiesFromFile(args[0]);
		else
			result = propertiesReader.printPropertiesFromFile(DEFAULT_FILE_NAME);
		System.out.println(result);
	}
}
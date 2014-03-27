package com.tmyagkova.testTask.propsReader;

import java.io.File;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import com.tmyagkova.testTask.propsReader.exception.InvalidFileException;

public class PropertiesReader {
	private final String FILE_NAME_REGEXP = "([A-Za-z]:)?([(\\\\|/)A-Za-z0-9_\\s-])*\\.properties";

	public String printPropertiesFromFile(String fileName) {
		String result = "";

		try {
			Properties properties = new Properties();
			FileStreamLoader fileStreamLoader = new FileStreamLoader();
			Context cx = Context.enter();

			validateFileName(fileName);
			String evaluationScript = "function print(){ fileStreamLoader.setFileName(fileName); "
					+ " properties.load(fileStreamLoader.getFileInputStream()); "
					+ " for (var i=0; i<properties.size();i++){"
					+ " var key = properties.keySet().toArray()[i];"
					+ " out.println(\"Key:\" + key + \"  Value: \" + properties.getProperty(key) + \"; \");"
					+ " };"
					+ "return \"Number of properties: \" + i;}; print();";
			Scriptable scope = cx.initStandardObjects();

			Object propertiesObject = Context.javaToJS(properties, scope);
			Object fileNameObject = Context.javaToJS(fileName, scope);
			Object fileStreamLoaderObject = Context.javaToJS(fileStreamLoader,
					scope);
			Object outObject = Context.javaToJS(System.out, scope);

			ScriptableObject.putProperty(scope, "properties", propertiesObject);
			ScriptableObject.putProperty(scope, "fileStreamLoader",
					fileStreamLoaderObject);
			ScriptableObject.putProperty(scope, "fileName", fileNameObject);
			ScriptableObject.putProperty(scope, "out", outObject);

			result = (String) cx.evaluateString(scope, evaluationScript,
					"EvaluationScript", 1, null);
		} catch (InvalidFileException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		} finally {
			Context.exit();
		}
		return result;
	}

	private void validateFileName(String fileName) throws InvalidFileException {
		Pattern pattern = Pattern.compile(FILE_NAME_REGEXP);
		Matcher matcher = pattern.matcher(fileName);
		if (matcher.matches()) {
			File file = new File(fileName);
			if (!file.exists() || file.isDirectory())
				throw new InvalidFileException("File is not exists.");
		} else
			throw new InvalidFileException("Incorrect file name.");
	}
}

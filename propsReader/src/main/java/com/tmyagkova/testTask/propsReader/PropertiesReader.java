package com.tmyagkova.testTask.propsReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class PropertiesReader {
	private static final String JS_FILE_NAME = "/script/propsReader.js";

	public static void main(String[] args) {
		try {
			printProperties(args);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Properties printProperties(String[] args) throws Exception {
			ScriptEngineManager scriptManager = new ScriptEngineManager();
			ScriptEngine scriptEngine = scriptManager
					.getEngineByExtension("js");

			Bindings bindings = scriptEngine.createBindings();
			bindings.put(ScriptEngine.FILENAME, JS_FILE_NAME);
			InputStream inputStream = PropertiesReader.class
					.getResourceAsStream(JS_FILE_NAME);
			Reader reader = new InputStreamReader(inputStream);
			if (args.length > 0)
				bindings.put("fileName", args[0]);
			Object result = scriptEngine.eval(reader, bindings);
			System.out.println("Result: " + result);
			if (result instanceof Exception){
				throw (Exception)result;
			}

		return (Properties)result;
	}
}
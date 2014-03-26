package com.tmyagkova.testTask.simplePropsReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


@SuppressWarnings("restriction")
public class Main {
	private static final String JS_FILE_NAME = "/propertiesReader.js";
	
	public static void main( String[] args ) throws ScriptException
    {
		ScriptEngineManager scriptManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptManager.getEngineByExtension("js");
	
		Bindings bindings = scriptEngine.createBindings();
		bindings.put(ScriptEngine.FILENAME, JS_FILE_NAME);
		InputStream inputStream = Main.class
				.getResourceAsStream(JS_FILE_NAME);
		Reader reader = new InputStreamReader(inputStream);
		scriptEngine.eval(reader, bindings);
		
		
    }
}

package com.tmyagkova.testTask.propsReader;

import java.io.FileInputStream;

public class FileStreamLoader {
	private String fileName;

	@SuppressWarnings("finally")
	public FileInputStream getFileInputStream() {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(getFileName());
			return fileInputStream;
		} finally {
			return fileInputStream;
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}

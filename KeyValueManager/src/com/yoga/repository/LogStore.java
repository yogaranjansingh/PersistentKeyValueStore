package com.yoga.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.yoga.configuration.Constants;

public class LogStore {

	private File file = null;
	private FileWriter fileWriter = null;
	private BufferedWriter bufferedWriter = null;
	private FileReader fileReader = null;
	private BufferedReader bufferedReader = null;
	
	public  void logCreate(String key, String value) {
		String logLine = key + "," + value + "\n";
		writeToLog(logLine);
	}

	public BufferedWriter getBufferedWriter() {
		try {
			file = new File(Constants.LOG_FILE_PATH);
			if (file.exists()) {
				System.out.println("Found the log file : " + file.getAbsolutePath());
			} else {
				file.createNewFile();
				System.out.println("File not found , created new file : " + file.getAbsolutePath());
			}
			fileWriter = new FileWriter(file, true);
			bufferedWriter = new BufferedWriter(fileWriter);
			return bufferedWriter;
		} catch (Exception e) {
			System.out.println("Exception while creating bufferedWriter" + e);
		}
		return null;
	}

	public  BufferedReader getBufferedReader() {
		try {
			file = new File(Constants.LOG_FILE_PATH);
			if (!file.exists()) {
				System.out.println("Log file not found, returning");
				return null;
			}
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			return bufferedReader;
		} catch (Exception e) {
			System.out.println("Exception while creating bufferedReaderr" + e);
		}
		return null;
	}

	public  Map<String, String> restoreKeyValueStore() {
		System.out.println("Restoring the key value store using the log file");
		Map<String, String> map = new HashMap<String, String>();
		bufferedReader = getBufferedReader();
		if (bufferedReader != null) {
			String line = null;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					String keyValue[] = line.split(",");
					if (keyValue != null && keyValue.length == 2)
						map.put(keyValue[0], keyValue[1]);
				}
				KeyValueStore.setCache(map);
				return map;
			} catch (Exception e) {
				System.out.println("Error while restoring the keyValue store");
			}finally {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.out.println("Exception while closing the  bufferedReader connection" + e);
				}
			}
		}
		return null;
	}

	public  void logDelete(String key) {
		writeToLog(key+"\n");
	}

	public  void writeToLog(String logLine) {
		try {
			bufferedWriter = getBufferedWriter();
			if (bufferedWriter != null) {
				bufferedWriter.append(logLine);
				bufferedWriter.flush();
			}
		} catch (Exception e) {
			System.out.println("Error while writing to the log file" + e);
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				System.out.println("Exception while closing the connection" + e);
			}
		}
	}

}

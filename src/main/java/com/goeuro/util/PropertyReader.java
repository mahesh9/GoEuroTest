package com.goeuro.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyReader {

	private static final Logger LOGGER = Logger.getLogger(PropertyReader.class);
	private final Properties properties = new Properties();

	private PropertyReader() {
		InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream("location.properties");

		try {
			properties.load(inputStream);
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}

	private static class LazyHolder {
		private static final PropertyReader INSTANCE = new PropertyReader();
	}

	public static PropertyReader getInstance() {
		return LazyHolder.INSTANCE;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public boolean containsKey(String key) {
		return properties.containsKey(key);
	}
}

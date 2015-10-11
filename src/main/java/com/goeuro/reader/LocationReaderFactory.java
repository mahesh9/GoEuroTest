package com.goeuro.reader;

public class LocationReaderFactory {

	public static LocationReaderFactory factory;
	private LocationReader locationReader;

	private LocationReaderFactory() {
	}

	public static LocationReaderFactory getInstance() {
		if (factory == null) {
			synchronized (LocationReaderFactory.class) {
				if (factory == null) {
					factory = new LocationReaderFactory();
				}
			}
		}
		return factory;
	}

	public LocationReader getLocationReader(LocationReaderType type) {

		switch (type) {
		case JSONReader:
			locationReader = new JsonReader();
			break;
		default:
			throw new IllegalArgumentException("reader type not supported");
		}

		return locationReader;
	}

}

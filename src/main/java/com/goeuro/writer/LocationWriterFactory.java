package com.goeuro.writer;

public class LocationWriterFactory {

	public static LocationWriterFactory factory;
	private LocationWriter locationWriter;

	private LocationWriterFactory() {
	}

	public static LocationWriterFactory getInstance() {
		if (factory == null) {
			synchronized (LocationWriterFactory.class) {
				if (factory == null) {
					factory = new LocationWriterFactory();
				}
			}
		}
		return factory;
	}

	public LocationWriter getLocationWriter(LocationWriterType type) {

		switch (type) {
		case CSVWriter:
			locationWriter = new CSVWriter();
			break;
		default:
			throw new IllegalArgumentException("writer type not supported");
		}

		return locationWriter;
	}

}

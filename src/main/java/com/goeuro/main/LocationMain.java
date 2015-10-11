package com.goeuro.main;

import java.util.List;

import org.apache.log4j.Logger;

import com.goeuro.model.Location;
import com.goeuro.reader.LocationReader;
import com.goeuro.reader.LocationReaderFactory;
import com.goeuro.reader.LocationReaderType;
import com.goeuro.writer.LocationWriter;
import com.goeuro.writer.LocationWriterFactory;
import com.goeuro.writer.LocationWriterType;

public class LocationMain {

	private static final Logger LOGGER = Logger.getLogger(LocationMain.class);

	public static void main(String args[]) {

		LOGGER.info("Location exporter - start");

		if (args.length > 0) {
			// get json reader by passing the type of reader.
			LocationReader locationReader = LocationReaderFactory.getInstance()
					.getLocationReader(LocationReaderType.JSONReader);
			List<Location> locationList = locationReader.readAndParseLocationData(args[0]);

			// get csv writer by passing the type of writer
			LocationWriter locationWriter = LocationWriterFactory.getInstance()
					.getLocationWriter(LocationWriterType.CSVWriter);
			locationWriter.writeData(args[0], locationList);
		} else {
			System.out.println("Please pass city name as command line argument");
		}

		LOGGER.info("Location exporter - end");
	}
}

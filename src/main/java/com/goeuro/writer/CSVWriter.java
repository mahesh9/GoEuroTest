package com.goeuro.writer;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.goeuro.model.Location;
import com.goeuro.util.LocationHelper;

public class CSVWriter implements LocationWriter {

	private static final Logger LOGGER = Logger.getLogger(LocationWriter.class);
	private static final String EXTENSION = ".csv";
	private static final String DELIMITER = ",";

	public void writeData(String fileName, List<Location> locationList) {

		if (!locationList.isEmpty()) {

			fileName = fileName + "_" +new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + EXTENSION;
			try (FileWriter writer = new FileWriter(fileName)) {

				writer.append(LocationHelper.getLocationHeader(DELIMITER));

				for (Location location : locationList) {
					writer.append(LocationHelper.getLocationLine(DELIMITER, location));
				}
				writer.flush();
			} catch (Exception e) {
				LOGGER.error(e);
			}
			LOGGER.info("Output generated,writing to CSV " + fileName);

		} else {
			LOGGER.info("No data found to write");
		}
	}

}

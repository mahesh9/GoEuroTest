package com.goeuro.util;

import com.goeuro.model.Location;

public class LocationHelper {

	private static final String NEW_LINE = "\n";
	
	public static String getLocationHeader(String delimiter) {
		StringBuilder header = new StringBuilder();
		header.append("id")
		.append(delimiter)
		.append("name")
		.append(delimiter)
		.append("type")
		.append(delimiter)
		.append("latitude")
		.append(delimiter)
		.append("longitude")
		.append(NEW_LINE);
		
		return header.toString();
	}

	public static String getLocationLine(String delimiter, Location location) {
		StringBuilder line = new StringBuilder();
		line.append(location.getId())
		.append(delimiter)
		.append(location.getName())
		.append(delimiter)
		.append(location.getType())
		.append(delimiter)
		.append(location.getLatitude())
		.append(delimiter)
		.append(location.getLongitude())
		.append(NEW_LINE);

		return line.toString();
	}

	
}

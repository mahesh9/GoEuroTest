package com.goeuro.reader;

import java.util.List;

import com.goeuro.model.Location;

public interface LocationReader {

	List<Location> readAndParseLocationData(String city);
}

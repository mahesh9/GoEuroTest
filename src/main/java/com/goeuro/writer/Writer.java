package com.goeuro.writer;

import java.util.List;

import com.goeuro.model.Location;

public interface Writer {

	void writeData(String fileName, List<Location> locationList);
}

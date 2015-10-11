package com.goeuro.junit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.goeuro.model.Location;
import com.goeuro.reader.JsonReader;
import com.goeuro.reader.LocationReader;
import com.goeuro.reader.LocationReaderFactory;
import com.goeuro.reader.LocationReaderType;
import com.goeuro.writer.CSVWriter;
import com.goeuro.writer.LocationWriter;
import com.goeuro.writer.LocationWriterFactory;
import com.goeuro.writer.LocationWriterType;

public class LocationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldReturnJsonReader(){
		LocationReader locationReader = LocationReaderFactory.getInstance()
				.getLocationReader(LocationReaderType.JSONReader);
		
		assertTrue(locationReader instanceof JsonReader);
	}
	
	@Test
	public void testReader() {
		LocationReader locationReader = LocationReaderFactory.getInstance()
				.getLocationReader(LocationReaderType.JSONReader);
		List<Location> locationList = locationReader.readAndParseLocationData("berlin");
		assertNotEquals(null, locationList);
	}
	
	@Test
	public void shouldReturnCSVWriter(){
		LocationWriter locationWriter = LocationWriterFactory.getInstance()
				.getLocationWriter(LocationWriterType.CSVWriter);
		
		assertTrue(locationWriter instanceof CSVWriter);
	}
	
	@Test
	public void testCreateCsv() {
		CSVWriter writer = new CSVWriter();
		List<Location> locationList = new ArrayList<Location>();
		Location location = new Location();
		location.setId(1L);
		location.setName("TestName");
		location.setType("TestType");
		location.setLatitude("TestLatitude");
		location.setLongitude("TestLogitude");
		locationList.add(location);
		writer.writeData("testCSV", locationList);
		File file = new File("testCSV_" + new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) +".csv");
        assertTrue(file.exists());
    }
}

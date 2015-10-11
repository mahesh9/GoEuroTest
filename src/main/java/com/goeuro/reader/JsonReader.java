package com.goeuro.reader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import com.goeuro.main.LocationMain;
import com.goeuro.model.Location;
import com.goeuro.util.JerseyAPIClient;
import com.goeuro.util.JsonUtils;
import com.goeuro.util.LocationMapper;
import com.goeuro.util.PropertyReader;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JsonReader implements LocationReader {

	private static final Logger LOGGER = Logger.getLogger(LocationMain.class);

	public List<Location> readAndParseLocationData(String city) {

		List<Location> locationList = null;
		try {
			LOGGER.info("City entered by user:" + city);
			
			WebResource webResource = JerseyAPIClient.getInstance().resource(PropertyReader.getInstance().getProperty("locationAPI") + city);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			String jsonResponse = response.getEntity(String.class);

			if (jsonResponse.isEmpty()) {
				LOGGER.error("Cannot retrieve location details for the city. Please try again later!");
				return Collections.emptyList();
			}
			
			if (LOGGER.isDebugEnabled())
				LOGGER.debug(jsonResponse);

			List<Map<String, Object>> resultList = JsonUtils.fromJSONToArray(jsonResponse);
			locationList = new LinkedList<Location>();
			for (Map<String, Object> result : resultList) {
				Location location = LocationMapper.getLocation(result);
				locationList.add(location);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return locationList;
	}
}

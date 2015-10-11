package com.goeuro.util;

import java.util.Map;
import org.apache.log4j.Logger;
import com.goeuro.model.Location;

public class LocationMapper {

	private static final Logger LOGGER = Logger.getLogger(LocationMapper.class);
	
	public static Location getLocation(Map<String, Object> map) {
		
		if(map == null) {
			return null;
		}
		
		Location location = new Location();
		location.setId((Long) Math.round((Double)map.get("_id")));
		location.setName(String.valueOf(map.get("name")));
		location.setType(String.valueOf(map.get("type")));
		
		Map<String, Object> geoPosition = (Map<String, Object>) map.get("geo_position");
		location.setLatitude(String.valueOf(geoPosition.get("latitude")));
		location.setLongitude(String.valueOf(geoPosition.get("longitude")));
		
		return location;
	}
}

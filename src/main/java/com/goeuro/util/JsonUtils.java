package com.goeuro.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

public class JsonUtils {
	
	public static List<Map<String, Object>> fromJSONToArray(String json) {
		List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
		if (!StringUtils.isNullOrEmpty(json)) {
			Gson gson = new Gson();
			list = gson.fromJson(json, List.class);
		}

		return list;
	}
}

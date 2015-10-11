package com.goeuro.util;

public class StringUtils {

	public static boolean isNullOrEmpty(String str) {
		if (str == null)
			return true;
		if (str.trim().length() == 0)
			return true;

		return false;
	}
	
	public static String checkStringForNull(Object obj) {
		if (obj == null)
			return "";

		return obj.toString();

	}

	public static Long checkLongForNull(Object obj) {
		if (obj == null)
			return 0L;

		return (Long) obj;
	}
}

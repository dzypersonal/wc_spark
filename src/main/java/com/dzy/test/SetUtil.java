package com.dzy.test;


import java.io.IOException;
import java.util.Properties;


public class SetUtil {
	private static Properties prop = new Properties();

	static {
		try {
			prop.load(SetUtil.class.getResourceAsStream("/set.properties"));
		} catch (IOException e) {
		}
	}

	public static String getString(String key, String defaultValue) {
		return prop.getProperty(key, defaultValue);
	}

	public static Integer getInteger(String key, Integer defaultValue) {
		Object obj = prop.getProperty(key);
		if (null != obj) {
			try {
				return Integer.parseInt(obj.toString());
			} catch (Exception e) {

			}
		}
		return defaultValue;
	}

}

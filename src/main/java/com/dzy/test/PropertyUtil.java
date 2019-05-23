package com.dzy.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;


public class PropertyUtil {
	private static Properties prop = new Properties();

	static {
		try {
			prop.load(PropertyUtil.class.getResourceAsStream("/prop/config.properties"));
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

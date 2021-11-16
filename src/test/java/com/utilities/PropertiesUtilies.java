package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtilies {

	static Properties prop;

	public static String getProperty(String key) {
		prop = new Properties();

		String path = "C:\\Users\\Admin\\Desktop\\Sdy\\AgileProject\\src\\test\\java\\com\\TestData\\Global.properties";

		try {
			prop.load(new FileInputStream(path));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return prop.getProperty(key);

	}
}

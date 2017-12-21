package com.zielinski.weather;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

public class XMLReader {
	//Main for testing
	public static void main(String[] args) {
		System.out.println("It is " + readXMLFeedTemperature("http://w1.weather.gov/xml/current_obs/KSPI.xml") + " in Springfield, IL.");
	}
	
	/*
	 * Reads the XML at the given URL
	 * Returns a string containing the temperature in degrees F and C
	 */
	public static String readXMLFeedTemperature(String urlAddress) {
		try {
			String temperatureStr = "";
			String line;
			String targetTagStart = "<temperature_string>";
			String targetTagEnd = "</temperature_string>";
			URL xmlUrl = new URL (urlAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(xmlUrl.openStream()));
			while((line = in.readLine()) != null) {
				if(line.contains(targetTagStart)) {
					int firstPos = line.indexOf(targetTagStart);
					int lastPos = line.indexOf(targetTagEnd);
					temperatureStr = line.substring(firstPos + targetTagStart.length(), lastPos);
					return temperatureStr;
				}
			}
		} catch (MalformedURLException ue) {
			System.out.println("Malformed URL");
		} catch (IOException ioe) {
			System.out.println("Something went wrong reading the contents");
		}
	return null;
	}
}

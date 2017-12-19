package com.zielinski.weather;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

public class XMLReader {
	public static void main(String[] args) {
		System.out.println(readXMLFeed("http://w1.weather.gov/xml/current_obs/KSPI.xml"));
	}
	public static String readXMLFeed(String urlAddress) {
		try {
			String sourceCode = "";
			String line;
			URL xmlUrl = new URL (urlAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(xmlUrl.openStream()));
			while((line = in.readLine()) != null) {
				if(line.contains("<temperature_string")) {
					System.out.println(line);
				}
			}
			return sourceCode;
		} catch (MalformedURLException ue) {
			System.out.println("Malformed URL");
		} catch (IOException ioe) {
			System.out.println("Something went wrong reading the contents");
		}
	return null;
	}
}

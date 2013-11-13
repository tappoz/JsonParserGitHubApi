package org.tappoz.json.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/** 
 * This class helps in connecting to the web service using the URL object
 *
 * @author Alessio Gottardo
 */
public class ConnectionService
{
	private URLConnection urlConnection;
	
	public ConnectionService()
	{
		this.urlConnection = null;
	}
	
	public ConnectionService(URL url) throws IOException
	{
		this.urlConnection = url.openConnection();
	}
	
	public void setUrlConnection(URL url) throws IOException
	{
		this.urlConnection = url.openConnection();
	}

	/** 
	 * This getter retrieves the Json file
	 * 
	 * @throws IllegalStateException when a URL connection is not set up yet
	 * @throws IOException	when there is a problem in retrieving the Json file
	 */
	public String getJsonAsString() throws IOException
	{
		if (urlConnection == null)
			throw new IllegalStateException("You should establish a new connection before attempting to get a Json as a string");
		
		BufferedReader bufferendInput = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String currentLine;
		StringBuilder sbJson = new StringBuilder();

		while ((currentLine = bufferendInput.readLine()) != null) {
		    sbJson.append(currentLine);
		}
		
		return sbJson.toString();
	}
}

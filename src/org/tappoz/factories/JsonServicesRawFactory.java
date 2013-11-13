package org.tappoz.factories;

import java.io.IOException;
import java.net.MalformedURLException;

import org.tappoz.json.services.ConnectionService;
import org.tappoz.json.services.JsonParserService;
import org.tappoz.json.services.ListOfReposContext;
import org.tappoz.json.services.UrlService;

public class JsonServicesRawFactory
{
	public static UrlService getNewUrlService(String repoUserName)
	{
		return new UrlService(repoUserName);
	}
	public static ConnectionService getNewConnectionService()
	{
		return new ConnectionService();
	}
	public static JsonParserService getNewJsonParserService()
	{
		return new JsonParserService();
	}
	
	// ---------------------------------
	
	public static ListOfReposContext getNewListOfReposContext(String parsedRepoUserName) 
			throws MalformedURLException, IOException
	{
		return new ListOfReposContext(parsedRepoUserName);
	}
}

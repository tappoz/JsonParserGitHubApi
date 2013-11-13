package org.tappoz.json.services;

import java.io.IOException;
import java.net.MalformedURLException;

import org.tappoz.factories.JsonServicesRawFactory;

/** 
 * This class helps the class containing the main method (@see WordFreq) handling 
 * all the objects concerned with the web service connection and retrieval of the Json file.
 *
 * @author Alessio Gottardo
 */
public class ListOfReposContext
{
	private UrlService urlService;
	private ConnectionService connectionService;
	private JsonParserService jsonParserService;

	/**
	 * This constructor initializes the URL service, the connection service, and the Json parser service.
	 * 
	 * @param parsedRepoUserName	The GitHub username provided through the command line
	 * */
	public ListOfReposContext(String parsedRepoUserName) throws MalformedURLException, IOException
	{
		this.urlService = JsonServicesRawFactory.getNewUrlService(parsedRepoUserName);
		
		this.connectionService = JsonServicesRawFactory.getNewConnectionService();
		connectionService.setUrlConnection(urlService.getUrl());
		
		this.jsonParserService = JsonServicesRawFactory.getNewJsonParserService();
		jsonParserService.setListOfRepos(connectionService);
	}

	public JsonParserService getJsonParserService()
	{
		return jsonParserService;
	}
}

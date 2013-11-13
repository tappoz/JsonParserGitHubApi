package org.tappoz.json.services;

import java.net.MalformedURLException;
import java.net.URL;

import org.tappoz.data.Constants;

/** 
 * This class helps in building the URL to use in order to retrieve the Json file
 *
 * @author Alessio Gottardo
 */
public class UrlService
{
	private String gitHubUserName;
	
	
	public UrlService(String gitHubUserName)
	{
		this.gitHubUserName = gitHubUserName;
	}

//	public void setGitHubUserName(int gitHubUserName)
//	{
//		this.gitHubUserName = gitHubUserName;
//	}

	/** 
	 * This method builds the URL
	 *
	 * @throws MalformedURLException when the URL is not compliant with the used protocols
	 */
	public URL getUrl() throws MalformedURLException
	{
		return new URL(Constants.GITHUB_JSON_BASE_URL.concat(gitHubUserName).concat(Constants.GITHUB_REPOS_SUB_URL));
	}
}

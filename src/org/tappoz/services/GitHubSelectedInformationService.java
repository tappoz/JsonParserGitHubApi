package org.tappoz.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.tappoz.factories.JsonServicesRawFactory;
import org.tappoz.helpers.SplitDescriptionHelper;
import org.tappoz.helpers.UniqueWordsHelper;
import org.tappoz.json.pojo.Repo;
import org.tappoz.json.services.ListOfReposContext;
import org.tappoz.pojo.GitHubSummaryObject;

public class GitHubSelectedInformationService
{
	private ListOfReposContext listOfReposContext;
	private List<GitHubSummaryObject> listGitHubSummaryObject;
	
	public GitHubSelectedInformationService()
	{
		this.listOfReposContext = null;
		this.listGitHubSummaryObject = null;
	}

	public ListOfReposContext getListOfReposContext()
	{
		if (listOfReposContext == null)
			throw new UnsupportedOperationException("You need to set a Context regarding a Git Hub username before trying to get it!");
		return listOfReposContext;
	}

	public void setListOfReposContext(String parsedRepoUserName) 
			throws MalformedURLException, IOException
	{
		this.listOfReposContext = JsonServicesRawFactory.getNewListOfReposContext(parsedRepoUserName);
	}
	
	public List<GitHubSummaryObject> getListGitHubSummaryObject()
	{
		return listGitHubSummaryObject;
	}

	public void setListGitHubSummaryObject()
	{
		if (this.listOfReposContext == null)
			throw new UnsupportedOperationException("You need to set a Context regarding a Git Hub username before trying to get it!");
		
		List<GitHubSummaryObject> gitHubSummaryObjects = new ArrayList<GitHubSummaryObject>();
		List<Repo> repos = this.listOfReposContext.getJsonParserService().getListOfRepos();
		Iterator<Repo> reposIterator = repos.iterator();
		while (reposIterator.hasNext()) 
		{
			GitHubSummaryObject currentGitHubSummaryObject = new GitHubSummaryObject();
			Repo currentRepo = reposIterator.next();
			
			currentGitHubSummaryObject.setGitHubUserName(currentRepo.getOwner().getLogin());
			currentGitHubSummaryObject.setRepoName(currentRepo.getName());
			currentGitHubSummaryObject.setRepoUrl(currentRepo.getHtmlUrl());
			// adding an array of unique words coming from the description of the repo
			String[] uniqueWords = UniqueWordsHelper.getUniqueWords(SplitDescriptionHelper.getTextDescriptionAsArray(currentRepo.getDescription()));
			Arrays.sort(uniqueWords);
			currentGitHubSummaryObject.setUniqueWordsInRepoDescription(uniqueWords);
			
			gitHubSummaryObjects.add(currentGitHubSummaryObject);
		}
		
		this.listGitHubSummaryObject = gitHubSummaryObjects;
	}
}

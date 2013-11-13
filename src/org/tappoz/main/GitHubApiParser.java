package org.tappoz.main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.tappoz.data.Constants;
import org.tappoz.factories.ServicesRawFactory;
import org.tappoz.helpers.GitHubApiParserHelper;
import org.tappoz.helpers.PrintingStuffHelper;
import org.tappoz.pojo.GitHubSummaryObject;
import org.tappoz.services.GitHubSelectedInformationService;


/** 
 * This class is the entry point of the command line tool called through a Jar file, 
 * it contains the main method
 *
 * @author Alessio Gottardo
 */
public class GitHubApiParser
{
	private static GitHubSelectedInformationService gitHubSelectedInformationService = ServicesRawFactory.getNewGitHubSelectedInformationService();
	
	public static void main(String[] args)
	{
		List<String> listOfGitHubUserNames = new ArrayList<String>();
		try 
		{
			listOfGitHubUserNames = GitHubApiParserHelper.parseInputArgs(args);
		}
		catch(Exception e)
		{
			System.err.println("Check your input values and try again!");
		}

		Iterator<String> iterator = listOfGitHubUserNames.iterator();
		while (iterator.hasNext()) {
			String currentUserNameInputValue = iterator.next();
			try
			{
				// setting the context related to the input username
				gitHubSelectedInformationService.setListOfReposContext(currentUserNameInputValue);
				// setting the list of POJO objects related to the previously set context
				// these POJO objects will be used to print the required information
				// related to the GitHub username and list of related repositories
				gitHubSelectedInformationService.setListGitHubSummaryObject();
			}
			catch (MalformedURLException e)
			{
				System.err.println("The URL is malformed for some reason, check this input user name: " + currentUserNameInputValue + ", check that the current GitHub URL is still compliant with the one defined in this Java project, and try again!");
				return;
			}
			catch (IOException e)
			{
				System.err.println("There is an IO exception, please check that your user name '" + currentUserNameInputValue + "' is genuine and it exists in GitHub. Try again!");
				return;
			}
			
			// printing the information regarding the current username and related repositories
			List<GitHubSummaryObject> summaryGitHubReposList = gitHubSelectedInformationService.getListGitHubSummaryObject();
			if(summaryGitHubReposList.isEmpty())
				System.err.println("Sorry! There are no repos for this user name: " + currentUserNameInputValue);
			else
			{
				Iterator<GitHubSummaryObject> summaryObjIterator = summaryGitHubReposList.iterator();
				while (summaryObjIterator.hasNext()) 
				{
					// getting the current object
					GitHubSummaryObject currentGitHubSummaryObject = summaryObjIterator.next();
					// printing it
					PrintingStuffHelper.printGitHubSummaryObject(currentGitHubSummaryObject);
				}
				System.out.println(Constants.LINE_SEPARATOR + "~~~ No more repos for this user name: " + currentUserNameInputValue);
			}
		}
	}

}

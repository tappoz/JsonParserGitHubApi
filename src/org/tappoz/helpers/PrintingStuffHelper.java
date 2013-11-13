package org.tappoz.helpers;

import java.util.Arrays;

import org.tappoz.data.Constants;
import org.tappoz.pojo.GitHubSummaryObject;

public class PrintingStuffHelper
{
	public static void printGitHubSummaryObject(GitHubSummaryObject currentObj)
	{
		System.out.println("GitHub username: " + currentObj.getGitHubUserName());
		System.out.println("GitHub repo url: " + currentObj.getRepoUrl());
		System.out.println("GitHub repo name: " + currentObj.getRepoName());
		System.out.println("GitHub repo list of unique words appearing in the repo description: " + Arrays.toString(currentObj.getUniqueWordsInRepoDescription()));
		System.out.println(Constants.LINE_SEPARATOR + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + Constants.LINE_SEPARATOR);
	}
}

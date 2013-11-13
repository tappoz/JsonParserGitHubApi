package org.tappoz.factories;

import org.tappoz.services.GitHubSelectedInformationService;

public class ServicesRawFactory
{
	public static GitHubSelectedInformationService getNewGitHubSelectedInformationService()
	{
		return new GitHubSelectedInformationService();
	}
}

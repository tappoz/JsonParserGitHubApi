package org.tappoz.pojo;

public class GitHubSummaryObject
{
	private String gitHubUserName;
	private String repoName;
	private String repoUrl;
	private String[] uniqueWordsInRepoDescription;
	
	public String getGitHubUserName()
	{
		return gitHubUserName;
	}
	public void setGitHubUserName(String gitHubUserName)
	{
		this.gitHubUserName = gitHubUserName;
	}
	public String getRepoName()
	{
		return repoName;
	}
	public void setRepoName(String repoName)
	{
		this.repoName = repoName;
	}
	public String getRepoUrl()
	{
		return repoUrl;
	}
	public void setRepoUrl(String repoUrl)
	{
		this.repoUrl = repoUrl;
	}
	public String[] getUniqueWordsInRepoDescription()
	{
		return uniqueWordsInRepoDescription;
	}
	public void setUniqueWordsInRepoDescription(String[] uniqueWordsInRepoDescription)
	{
		this.uniqueWordsInRepoDescription = uniqueWordsInRepoDescription;
	}
}

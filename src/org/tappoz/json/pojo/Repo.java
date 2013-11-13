package org.tappoz.json.pojo;

import com.google.gson.annotations.SerializedName;

public class Repo
{
	private String id;
	private String name;
	private Owner owner;
	@SerializedName("html_url")
	private String htmlUrl;
	private String description;
	private String language;
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Owner getOwner()
	{
		return owner;
	}
	public void setOwner(Owner owner)
	{
		this.owner = owner;
	}
	public String getHtmlUrl()
	{
		return htmlUrl;
	}
	public void setHtmlUrl(String htmlUrl)
	{
		this.htmlUrl = htmlUrl;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getLanguage()
	{
		return language;
	}
	public void setLanguage(String language)
	{
		this.language = language;
	}
}

package org.tappoz.json.services;

import java.io.IOException;
import java.util.List;
import java.lang.reflect.Type;

import org.tappoz.json.pojo.Repo;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

/** 
 * This class parses the data related to the hotels using the Gson Google external library.
 *
 * @author Alessio Gottardo
 */
public class JsonParserService
{
	private List<Repo> listOfRepos;

	public JsonParserService()
	{
		this.listOfRepos = null;
	}

	public List<Repo> getListOfRepos()
	{
		if (listOfRepos == null)
			throw new IllegalStateException("There is no DestinationHotelsList to return, first of all set it!");
		return listOfRepos;
	}
	
	/** 
	 * This method sets the list of repos.
	 * The top level structure of the GitHub Json API is an array,
	 * then we are going to treat that array as a List of Java object.
	 * 
	 * @param currentCS the Connection service currently up
	 * @throws JsonSyntaxException when the Json has a not expected structure
	 * @throws IOException when the Json can not be retrieved
	 */
	public void setListOfRepos(ConnectionService currentCS) throws JsonSyntaxException, IOException 
	{
		Gson gson = new Gson();
		Type type = new TypeToken<List<Repo>>(){}.getType();
		this.listOfRepos = gson.fromJson(currentCS.getJsonAsString(), type);
	}
	
	
	
}

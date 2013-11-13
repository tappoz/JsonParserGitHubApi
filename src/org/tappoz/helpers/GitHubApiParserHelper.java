package org.tappoz.helpers;

import java.util.ArrayList;
import java.util.List;

/** 
 * This class helps the class containing the main method in parsing the input parameters
 *
 * @author Alessio Gottardo
 */
public class GitHubApiParserHelper
{
	/** 
	 * This method helps in parsing the input parameters submitted through the command line
	 *
	 * @param args	The array containing the input parameters
	 * @return a list of objects of type String
	 */
	public static List<String> parseInputArgs(String[] args)
	{
		List<String> inputGitHubUserNames = new ArrayList<String>();
		
		for (int i = 0; i < args.length; i++)
		{
			inputGitHubUserNames.add(args[i]);
		}
		
		return inputGitHubUserNames;
	}
}

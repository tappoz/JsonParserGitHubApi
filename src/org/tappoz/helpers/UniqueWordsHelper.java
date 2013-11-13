package org.tappoz.helpers;

import java.util.HashSet;
import java.util.Set;

public class UniqueWordsHelper
{
	public static String[] getUniqueWords(String[] arrayOfInputWords)
	{
		Set<String> uniqueWords = new HashSet<String>();
		for (String currentWord: arrayOfInputWords)
		{
			// case insensitive
			uniqueWords.add(currentWord.toLowerCase());
		}
		
		return uniqueWords.toArray(new String[0]);
	}
}

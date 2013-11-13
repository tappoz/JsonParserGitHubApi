package org.tappoz.helpers;

/** 
 * This helper provides the functionality related to the parsing of an input string, 
 * cleaning it from punctuation, splitting it in an array data structure.
 *
 * @author Alessio Gottardo
 */
public class SplitDescriptionHelper
{
	/** 
	 * This method helps in parsing the string, cleaning it etc.
	 * <ul>
	 * 	<i> It splits the string on non-word characters using a regex. </i>
	 * 	<i> It cleans the punctuation using a regex. </i>
	 * 	<i> It deletes the empty strings. </i>
	 * 	<i> It sets the words to lower case. </i>
	 * 	<i> It resize the output array where needed. </i>
	 * </ul>
	 *
	 * @param textDescription the input string to parse
	 */
	public static String[] getTextDescriptionAsArray(String textDescription)
	{
		// split on non-word characters using a regex
		String[] wordsInCurrentTextDescription = textDescription.split("[\\W]");
		
		int counter = 0;
		String[] stagingArray = new String[wordsInCurrentTextDescription.length];
		
		for (int i = 0; i < wordsInCurrentTextDescription.length; i++)
		{
			// cleaning the punctuation using a regex
			wordsInCurrentTextDescription[i].replaceAll("\\p{Punct}","");
			// deleting the empty strings from the array of words
			if (!wordsInCurrentTextDescription[i].equals(""))
			{
				// then setting the current word to lower case
				stagingArray[counter++] = wordsInCurrentTextDescription[i].toLowerCase();
			}
		}
		
		String[] outputArray;
		// we do not need to resize the array because we did not find any empty string
		if (counter == wordsInCurrentTextDescription.length)
			outputArray = wordsInCurrentTextDescription;
		// we need to resize the array because we found empty strings
		else
		{
			outputArray = new String[counter];
			for (int i = 0; i < counter; i++)
			{
				outputArray[i] = stagingArray[i];
			}
		}
		
		return outputArray;
	}
}

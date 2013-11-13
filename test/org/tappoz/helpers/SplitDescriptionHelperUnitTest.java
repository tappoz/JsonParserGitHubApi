package org.tappoz.helpers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SplitDescriptionHelperUnitTest
{	
	@Test
	public void testCommaAtTheEndOfAWord()
	{
		String given = "aaa, bbb";
		String[] expected = {"aaa", "bbb"};
		
		String[] found = SplitDescriptionHelper.getTextDescriptionAsArray(given);
		
		Assert.assertArrayEquals(found, expected);
	}
	
	@Test
	public void testCommaEmbeddedInSpaces()
	{
		String given = "aaa , bbb";
		String[] expected = {"aaa", "bbb"};
		
		String[] found = SplitDescriptionHelper.getTextDescriptionAsArray(given);
		
		Assert.assertArrayEquals(found, expected);
	}

	@Test
	public void testMultiplePunctuationSignsAndCaseInsensitive()
	{
		String given = "aaa , bbB!? . ...cCc, 09@!";
		String[] expected = {"aaa", "bbb", "ccc", "09"};
		
		String[] found = SplitDescriptionHelper.getTextDescriptionAsArray(given);
		
		System.out.println("Given: " + given);
		System.out.println("Found: " + Arrays.toString(found));
		
		Assert.assertArrayEquals(found, expected);
	}
}

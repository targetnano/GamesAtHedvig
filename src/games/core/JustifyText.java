package games.core;

import java.util.ArrayList;
import java.util.List;

public class JustifyText 
{


	private static String getSpaces(int length)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++)
			sb.append(' ');

		return sb.toString();
	}

	private static String justifyLine(String[] strings, int start, int end, int curLineLength, int maxLineLength)
	{
		StringBuilder sb = new StringBuilder();

		/* left justify in case of single word line or last line */
		if( (end - start) == 1 || end == strings.length-1 )
		{
			for( int i = start; i < end; i++ )
			{
				sb.append(strings[i]);
				sb.append(' ');
			}
			int numSpaces = maxLineLength - sb.length();
			sb.append(strings[end]);
			sb.append(getSpaces(numSpaces));
		}
		else
		{
			/* Extra space to add between words */
			int extraSpaces = (maxLineLength - curLineLength) / (end - start);
			
			/* Remaining space that needs to be evenly distributed */
			int spacesToDistribute = (maxLineLength - curLineLength) % (end - start);
			for(int i = start; i < end; i++)
			{
				int spaceToInsert = spacesToDistribute > 0 ? (1 + extraSpaces + 1) : (1+extraSpaces);
				sb.append(strings[i]);
				sb.append(getSpaces(spaceToInsert));
				spacesToDistribute--;
			}

			if(spacesToDistribute > 0)
				sb.append(getSpaces(spacesToDistribute));
			sb.append(strings[end]);
		}
		return sb.toString();
	}

	private static List<String> justifyStrings(String[] strings, int maxLineLength)
	{
		List<String> justifiedString = new ArrayList<String>();

		if(strings == null || strings.length == 0)
		{
			justifiedString.add(getSpaces(maxLineLength));
			return justifiedString;
		}

		int start = 0;
		int curLineLength = 0;
		int curLineLengthWithSpaces = 0;
		
		for(int i = 0; i < strings.length; i++)
		{
			curLineLength += strings[i].length();
			curLineLengthWithSpaces = curLineLength + /* num spaces */( i - start );
			if(curLineLengthWithSpaces > maxLineLength)
			{
				justifiedString.add(justifyLine(strings, start, i-1, curLineLengthWithSpaces - strings[i].length() - 1, maxLineLength));
				curLineLength = strings[i].length();
				start = i;  
			}
		}

		/* Justify last line */
		justifiedString.add(justifyLine(strings, start, strings.length-1, curLineLengthWithSpaces, maxLineLength));

		return justifiedString;
	}
	
	public static void main(String[] args)
	{
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		List<String> justified = justifyStrings(words, 16);
		for(String str : justified)
			System.out.println(str);
	}
}

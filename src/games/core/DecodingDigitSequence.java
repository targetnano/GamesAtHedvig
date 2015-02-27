package games.core;
import java.util.ArrayList;
import java.util.List;


/**
 * Given a digit sequence, count the number of possible decodings of the given digit sequence.
 * 
 * @author Kavi
 */
public class DecodingDigitSequence 
{

	private static void printDecodings(int digitIndex, String digits, List<Character> decodedStr)
	{
		if(digitIndex >= digits.length())
		{
			for(Character ch : decodedStr)
				System.out.print(ch);
			System.out.println("");
			return;
		}

		char curDigit = digits.charAt(digitIndex);

		// BUG: Forgot to handle zero case
		if(curDigit != '0')
		{
			decodedStr.add((char)(curDigit+16));
			printDecodings(digitIndex+1, digits, decodedStr);
			decodedStr.remove(decodedStr.size()-1);
		}

		if(digitIndex < digits.length()-1)
		{
			int tens = curDigit - 48;
			int ones = digits.charAt(digitIndex+1) - 48;
			int number = ones + (tens * 10);
			if(number <= 26)
			{
				decodedStr.add((char)('A' + number-1));
				printDecodings(digitIndex+2, digits, decodedStr);

				//BUG: Forgot to remove this.
				decodedStr.remove(decodedStr.size()-1);
			}
		}
	}

	private static int countDecodings(String s)
	{  
		int len = s.length();
		int[] count = new int[len+1];  
		count[0] = (len <= 0) ? 0 : 1;

		for (int i=1; i<=len; ++i) 
		{  
			char c = s.charAt(i-1);

			if ( c != '0' )  
				count[i] = count[i-1];

			if ( i-1 > 0 && isTwoDigitCode(s.charAt(i-2), c) ) 
				count[i] += count[i-2];

			if ( count[i] == 0 ) 
				return 0;
		}  
		return count[len];  
	}

	private static boolean isTwoDigitCode(char a, char b) 
	{  
		return (a=='1' || (a=='2' && b<='6'));  
	}

	public static void main(String[] args)
	{
		//System.out.println(countDecodings("201"));
		List<Character> decoded = new ArrayList<Character>();
		printDecodings(0, "201", decoded);
	}
}

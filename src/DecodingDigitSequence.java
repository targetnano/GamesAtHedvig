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
	
	private static int countDecodings(String digits)
	{
	    int[] count = new int[digits.length()+1];
	    // Base cases
	    count[0] = 1;
	    count[1] = 1;

	    for(int i = 2; i < count.length; i++)
	    {
	        char curChar = digits.charAt(i-1);
	        char prevChar = digits.charAt(i-2);

	        // If the current entry is a valid number,
	        // it inherits the number of ways from previous one.
	        if(curChar >= '1' && curChar <= '9')
	            count[i] = count[i-1];

	        if(prevChar < '2' || (prevChar == '2' && curChar <= '6') )
	            count[i] += count[i-2];
	    }
	    return count[count.length-1];
	}
	
	public static void main(String[] args)
	{
		//System.out.println(countDecodings("201"));
		List<Character> decoded = new ArrayList<Character>();
		printDecodings(0, "201", decoded);
	}
}

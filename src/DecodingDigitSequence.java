
/**
 * Given a digit sequence, count the number of possible decodings of the given digit sequence.
 * 
 * @author Kavi
 */
public class DecodingDigitSequence 
{

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
		System.out.println(countDecodings("726"));
	}
}

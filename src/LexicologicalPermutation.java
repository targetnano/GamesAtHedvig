
public class LexicologicalPermutation 
{

	private static String nextPermutation(String number)
	{
	    if(number.length() <= 1)
	        return number;
	    int pivot = -1;
	    
	    // Find the longest non-increasing suffix
	    for(int i = number.length() - 2; i >= 0; i--)
	    {
	        if(number.charAt(i) < number.charAt(i+1))
	        {
	            pivot = i;
	            break;
	        }
	    }

	    if(pivot == -1)
	        return number;

	    int pivot2 = -1;
	    // Find the smallest number greater than the pivot
	    for(int i = number.length()-1; i > pivot; i--)
	    {
	        if(number.charAt(i) > number.charAt(pivot))
	        {
	            pivot2 = i;
	            break;
	        }
	    }
	    
	    // Increase the prefix slightly
	    char[] numArray = number.toCharArray();
	    char temp = numArray[pivot2];
	    numArray[pivot2] = numArray[pivot];
	    numArray[pivot] = temp;

	    // Decrease the suffix by reversing the decreasing subarray
	    int i = pivot+1, j = number.length()-1;
	    while(i < j)
	    {
	        temp = numArray[j];
	        numArray[j] = numArray[i];
	        numArray[i] = temp;
	        i++;
	        j--;
	    }
	    return new String(numArray);
	}
	
	public static void main(String[] args)
	{
		System.out.println(nextPermutation("543"));
	}
}

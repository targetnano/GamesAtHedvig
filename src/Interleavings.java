
public class Interleavings 
{

	private static void printInterLeavings(String a, String b)
	{
	    int interLength = a.length() + b.length();
	    char[] buffer = new char[interLength];
	    interleave(0, a, 0, b, 0, buffer);
	}

	private static void interleave(int aIdx, String a, int bIdx, String b, int bufIdx, char[] buffer)
	{
		// Bug 1: Was [ bufIdx == buffer.length - 1 ]
	    if(bufIdx == buffer.length)
	    {
	        for(int i = 0; i <= bufIdx - 1; i++)
	        {
	            System.out.print(buffer[i]);
	        }
	        System.out.println("");
	        // Bug 2: Missed return
	        return;
	    }
	    if(aIdx < a.length())
	    {
	        buffer[aIdx+bIdx] = a.charAt(aIdx);
	        interleave(aIdx+1, a, bIdx, b, bufIdx+1, buffer);
	    }
	    if(bIdx < b.length())
	    {
	        buffer[aIdx+bIdx] = b.charAt(bIdx);
	        interleave(aIdx, a, bIdx+1, b, bufIdx+1, buffer);
	    }
	}
	
	public static void main(String[] args)
	{
		String a = "ab";
		String b = "cd";
		printInterLeavings(a,b);
	}
}

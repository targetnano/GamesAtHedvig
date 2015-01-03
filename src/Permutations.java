
public class Permutations {

	// Permutation by creating substrings and forming
	// new strings. This one eats lots of space.
	private static void permute1(String a)
	{
	    permute1("", a);
	}

	private static void permute1(String prefix, String suffix)
	{
	    if(suffix.length() == 0)
	    {
	        System.out.println(prefix);
	        return;
	    }
	    for(int i = 0; i < suffix.length(); i++)
	    {
	        char ch = suffix.charAt(i);
	        // BUG: Was suffix.substring(i) for i+1
	        permute1(prefix + ch, suffix.substring(0,i) + suffix.substring(i+1));
	    }
	}
	
	public static void main(String[] args)
	{
		permute1("abcd");
	}
}

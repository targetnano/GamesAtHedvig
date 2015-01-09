package games.core;

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
	
	private static void permute2(String str)
	{
	    char[] buffer = new char[str.length()];
	    boolean[] used = new boolean[str.length()];
	    permute2Helper(0, str, buffer, used);
	}

	private static void permute2Helper(int index, String str, char[] buffer, boolean[] used)
	{
	    if(index == buffer.length)
	    {
	        String perm = new String(buffer);
	        System.out.println(perm);
	        return;
	    }
	    for(int i = 0; i < str.length(); i++)
	    {
	        if(used[i])
	            continue;
	        buffer[index] = str.charAt(i);
	        used[i] = true;
	        permute2Helper(index+1, str, buffer, used);
	        used[i] = false;
	    }
	}
	public static void main(String[] args)
	{
		permute2("abc");
	}
}

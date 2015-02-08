package games.core;

public class StringAddition 
{
	private static String add(String s1, String s2)
	{
	    if(s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
	        return "";
	    
	    StringBuilder sb = new StringBuilder();
	    int i = s1.length()-1;
	    int j = s2.length()-1;
	    int carry = 0;
	    
	    for(; i >= 0 || j >= 0; i--,j--)
	    {
	        int n1 = (i >= 0) ? Character.getNumericValue(s1.charAt(i)) : 0;
	        int n2 = (j >= 0) ? Character.getNumericValue(s2.charAt(j)) : 0;
	        int sum = n1 + n2 + carry;
	        if(sum <= 1)
	        {
	            sb.append(sum);
	            carry = 0;
	        }
	        else
	        {
	            sb.append(sum % 2);
	            carry = 1;
	        }
	    }
	    
	    if(carry != 0)
	        sb.append(carry);
	        
	    return sb.reverse().toString();
	}	

	public static void main(String[] args)
	{
		System.out.println(add("10", "11"));
	}
}

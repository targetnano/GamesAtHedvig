package games.core;

public class MutiplyStrings 
{
	private static String multiply(String s1, String s2)
	{
		s1 = new StringBuilder(s1).reverse().toString();
		s2 = new StringBuilder(s2).reverse().toString();

		int[] product = new int[s1.length() + s2.length()];

		for(int i = 0; i < s1.length(); i++)
		{
			for(int j = 0; j < s2.length(); j++)
			{
				int op1 = Character.getNumericValue(s1.charAt(i));
				int op2 = Character.getNumericValue(s2.charAt(j));
				int result = op1*op2;
				product[i+j] += result;
				product[i+j+1] += product[i+j]/10;
				product[i+j] = product[i+j] % 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		boolean zerosDone = false;
		for(int i = product.length-1; i >= 0; i--)
		{
			if(!zerosDone && product[i] == 0)
				continue;
			sb.append(product[i]);
			zerosDone = true;
		}
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(multiply("1938194","1746182"));
	}
}

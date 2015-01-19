package games.core;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals 
{

	private static String intToRoman(int num)
	{
	    int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] roman = {"M", "CM", "D", "CD", "C","XC", "L" ,"XL", "X", "IX" , "V", "IV", "I"};

	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < decimal.length; i++)
	    {
	        int times = num / decimal[i];
	        for(; times > 0; times--)
	            sb.append(roman[i]);
	        num = num % decimal[i];
	    }
	    return sb.toString();
	}
	
	private static int romanToDecimal(String roman)
	{
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put('I', 1);
	    map.put('V', 5);
	    map.put('X', 10);
	    map.put('L', 50);
	    map.put('C', 100);
	    map.put('D', 500);
	    map.put('M', 1000);

	    int result = 0;
	    for(int i = 0; i < roman.length(); i++)
	    {
	        if(i+1 < roman.length() &&
	                map.get(roman.charAt(i)) < map.get(roman.charAt(i+1)))
	        {
	            result += map.get(roman.charAt(i+1)) - map.get(roman.charAt(i));
	            i++;
	        }
	        else
	            result += map.get(roman.charAt(i));
	    }
	    return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(romanToDecimal("CM"));
	}
}

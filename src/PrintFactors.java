import java.util.ArrayList;
import java.util.List;


public class PrintFactors {

	private static void printFactors(int number, int start, List<Integer> factors)
	{
	    if(number == 1)
	    {
	        for(int i = factors.size()-1; i >= 1; i--)
	            System.out.print(factors.get(i) + "*");
	        System.out.println(factors.get(0));
	        return;
	    }

	    for(int i = start; i >= 2; i--)
	    {
	        int quotient = number % i;
	        if(quotient == 0)
	        {
	            factors.add(i);
	            printFactors(number/i, i, factors);
	            factors.remove(factors.size()-1);
	        }
	    }
	}
	
	public static void main(String[] args)
	{
		printFactors(12, 6, new ArrayList<Integer>());
	}
}

package games.core;

public class Sqrt 
{

	private static double sqrt(double num)
	{
	    double lo = 0;
	    double hi = num;
	    double diff = 0.0001;
	    double mid = num/2;
	    
	    while( Math.abs(num - (mid * mid)) > diff )
	    {
	       mid = lo + (hi - lo) / 2;
	       if(mid*mid > num)
	           hi = mid;
	       else
	           lo = mid;
	    }
	    return mid;
	}
	
	public static void main(String[] args)
	{
		System.out.print(sqrt(84));
	}
}

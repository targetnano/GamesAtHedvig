package games.core;

public class Power 
{

	private static double pow(int x, int y)
	{
	    if(y == 0)
	        return 1;

	    double power = pow(x, y/2);

	    if(y % 2 == 1)
	        return x * power * power;
	    else
	        return power * power;
	}
	
	private static double power(int x, int y)
	{
		if(y >= 0)
			return pow(x,y);
		else
			return 1.0/pow(x,-y);
	}
	
	public static void main(String[] args)
	{
		System.out.println(power(2,6));
	}
}

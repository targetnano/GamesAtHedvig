
public class DutchNationalFlag 
{

	private static void formDutchFlag(int[] array, int x)
	{
	    if(array.length == 0 || array.length == 1)
	        return;

	    int i = 0;
	    int small = 0;
	    int large = array.length - 1;

	    while(small < large)
	    {
	        if(array[i] == x)
	        {
	            i++;
	            continue;
	        }
	        else if(array[i] > x)
	        {
	            ArrayUtils.swap(array, i, large);
	            large--;
	        }
	        else
	        {
	        	ArrayUtils.swap(array, i, small);
	            i++;
	            small++;
	        }
	    }
	}
	
	public static void main(String[] args)
	{
		int[] array = {2};
		formDutchFlag(array, 2);
		ArrayUtils.printArray(array);
	}
}

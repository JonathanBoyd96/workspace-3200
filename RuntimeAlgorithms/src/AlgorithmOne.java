import java.util.Random; 

public class AlgorithmOne 
{	
	
	public static void main (String[] args)
	{
		long startTime = System.nanoTime();
		int n = 2000;
		int[] x = new int[n];
		Random rand = new Random();
		
		for (int i = 0; i<x.length; i++)
		{
			int r = rand.nextInt(n) + 1;
			
			for (int a=0; a<x.length; a++)
			{
				while(r == x[a])
				{
					r = rand.nextInt(n)+1;
					a = 0;
				}
			}
			x[i] = r;
		}
	
		long endTime = System.nanoTime();
		System.out.println("Algorithm one: at N = " + n + ", time was: " + ((endTime - startTime)*0.0000001) + "ms");
		//System.out.println(java.util.Arrays.toString(x));
	
	}
	

}
import java.util.Random; 

public class AlgorithmTwo 
{
	public static void main (String[] args)
	{
		long startTime = System.nanoTime();
		int n = 800000;
		int[] x = new int[n];
		boolean [] used = new boolean[n];
		Random rand = new Random();
		
		for (int i = 0; i<x.length; i++)
		{
			int r = rand.nextInt(n) + 1;
			
			while(used[r-1] == true)
			{
				r = rand.nextInt(n)+1;
			}
			
			used[r-1] = true;
			x[i] = r;
		}
	
		long endTime = System.nanoTime();
		System.out.println("Algorithm one: at N = " + n + ", time was: " + ((endTime - startTime)*0.0000001) + "ms");
		//System.out.println(java.util.Arrays.toString(x));
	}
}
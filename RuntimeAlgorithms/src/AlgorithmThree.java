import java.util.Random; 

public class AlgorithmThree 
{
	
	public static int rand(int first, int last)
	{
		int y;
		y = first + (int)(Math.random() * last);
		
		return y;
	}
	
	public static void main (String[] args)
	{
		long startTime = System.nanoTime();
		int n = 6400000;
		int[] x = new int[n];
		Random rand = new Random();
		
		for (int i = 0; i<x.length; i++)
		{
			x[i] = i + 1;
			
			int temp = x[i];
			int next = rand(0, i);
			x[i] = x[next];
			x[next] = temp;
		}
	
		long endTime = System.nanoTime();
		System.out.println("Algorithm one: at N = " + n + ", time was: " + ((endTime - startTime)*0.0000001) + " ms");
		//System.out.println(java.util.Arrays.toString(x));
	}
	
}
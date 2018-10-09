import java.util.Scanner; 

public class NumberOfOnes 
{
	static int ones ;  
	
	  public static int countOnes(int n)
	  { 
	    if (n == 0)
	    {
	      ones = 0;
	      return ones;
	    }
	    else
	    if (n%2 == 0)
	    {
	      ones = countOnes(n/2);
	      return ones;
	    }
	    else
	    {
	      ones = 1 + countOnes((n-1)/2);
	      return ones;
	    }
	  }
	  
	  public static void main(String[] args)
	  {
		System.out.println("Input a number: ");
	    Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		countOnes(n);
	    System.out.println("The number of ones are " + ones);
		
	  } 
	  
	}

	
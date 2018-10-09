import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReadFromFile {

	public static void main(String[] args) throws FileNotFoundException {
		//Random Numbers: http://textmechanic.com/text-tools/numeration-tools/generate-list-numbers/
		long startTime = System.nanoTime();
		//Open file for reading
		Scanner s = new Scanner(new File("random100.txt"));
		Scanner s2 = new Scanner(new File("random1000.txt"));
		//Create ArrayList for all values
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		//Read until end of file is reached
		
		long endReadFile = 0;
		long endReadFile2 = 0;
		
		while(s.hasNextInt())
		{
			//Add each value found to the ArrayList
			nums.add(s.nextInt());
			
			// Organizes the ArrayList
			Collections.sort(nums);
			
			endReadFile = System.nanoTime();
		}
		
		while(s2.hasNextInt())
		{
			//Add each value found to the ArrayList
			nums2.add(s2.nextInt());
			
			// Organizes the ArrayList
			Collections.sort(nums2);
			
			endReadFile2 = System.nanoTime();
		}
		
		// Sets k = to half the size of the organized list (which returns what the middle would be)
		
		int x = nums.size();
		int k = x/2;
		
		int x2 = nums2.size();
		int k2 = x2/2;
		
		long endProgram = System.nanoTime();
		
		// 100 numbers
		System.out.print("k/2 of 100: ");
		System.out.println(k);
		System.out.println("Runtime of reading file contents:" + 
				String.format( "%12.6f",((endReadFile-startTime)/Math.pow(10,9))));
		
		// 1000 numbers
		System.out.print("k/2 of 1000: ");
		System.out.println(k2);
		System.out.println("Runtime of reading file contents:" + 
				String.format( "%12.6f",((endReadFile2-startTime)/Math.pow(10,9))));
		
		// Runtime of entire program
		System.out.println("");
		System.out.println("Runtime of entire program:" + 
				String.format( "%12.6f",((endProgram-startTime)/Math.pow(10,9))));
		
	}
}

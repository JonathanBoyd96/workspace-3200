import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetMapExamples {

	public static void main(String args[]) 
	  {
		TreeMap<String, String> nameMap = new TreeMap<String,String>();
		  Scanner scan = new Scanner(System.in);
		  String input = "yes";
	        
	        while (input.equalsIgnoreCase("yes"))
	        {
	        	String str = "";
		        Scanner in = new Scanner(System.in);
		        System.out.println("Enter name: ");
		        str = in.nextLine();
		        int totalVowels = 0;
		        
	        	Map<Character, Integer> tmap = new TreeMap<Character, Integer>();
		        for (int i = 0; i < str.length(); i++) 
		        	{
		            	char c = str.charAt(i);
		            	if (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I'
		                    || c == 'i' || c == 'O' || c == 'o' || c == 'U' || c == 'u') 
		            	{
		            		Integer count = tmap.get(c);
		            		tmap.put(c, (count == null ? 1 : count + 1));
		            		totalVowels++;
		            	}
		        	}
		        String vowels = String.valueOf(totalVowels);
	        	
	        	nameMap.put(str, vowels);
	        	System.out.println("Enter another name? ");
		        System.out.println("Yes or No: ");
		        input = scan.nextLine();
	        }
	        for(String s : nameMap.keySet())
        	{
        		System.out.println(s + ":" + nameMap.get(s));
        	}
	  }

}

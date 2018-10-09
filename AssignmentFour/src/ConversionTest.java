import java.util.Scanner;

public class ConversionTest 
{
	public static void main(String[] args) 
	 {
		int input = 0;
		
		while (input != 1 || input != 2)
		{
		System.out.println("Enter '1' for: Postfix");
		System.out.println("Enter '2' for: Prefix");
		Scanner scan = new Scanner(System.in);
		input = scan.nextInt();
		System.out.println();
		
		if (input == 1)
		{
			PostfixToInfix obj = new PostfixToInfix();
			  System.out.print("Postfix input : ");
			  Scanner sc = new Scanner(System.in);
			  String postfix = sc.next();
			  System.out.println("Infix output : "+obj.convert(postfix));
			  System.out.println();
			  input = 0;
		}
	 
		if (input == 2)
		{
			InfixToPostfix obj = new InfixToPostfix();
			  Scanner sc = new Scanner(System.in);
			  System.out.print("Infix input: ");
			  String infix = sc.next();
			  System.out.print("Postfix output: "+obj.convert(infix));
			  System.out.println();
			  System.out.println();
			  input = 0;
		}
	 }
	}
}

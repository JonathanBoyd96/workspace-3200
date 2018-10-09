import java.util.Scanner;

public class ConversionTest 
{
	public static void main(String[] args) 
	 {
		int input = 0;
		
		while (input != 1 || input != 2)
		{
		System.out.println("-------------------Input a postfix or prefix equation to store in a tree-------------------");
		System.out.println("Enter '1' to insert from Infix: ");
		System.out.println("Enter '2' to insert from Postfix: ");
		System.out.println("Enter '3' to insert from Prefix: ");
		Scanner scan = new Scanner(System.in);
		input = scan.nextInt();
		System.out.println();
		
		if (input == 1)
		{
				EquationBinaryTree obj = new EquationBinaryTree();
			  System.out.print("Infix input : ");
			  Scanner sc = new Scanner(System.in);
			  String infix = sc.next();
			  obj.populateFromInfix(infix);
			  System.out.println("Infix : "+obj.printInfix());
			  System.out.println("Postfix: "+obj.printPostfix());
			  System.out.println("Prefix: "+obj.printPrefix());
			  System.out.println();  
		}
		
		if (input == 2)
		{
			PostfixToInfix obj = new PostfixToInfix();
			  System.out.print("Postfix input : ");
			  Scanner sc = new Scanner(System.in);
			  String postfix = sc.next();
			  System.out.println("Output : "+obj.convert(postfix));
			  System.out.println(); 
		}
	 
		if (input == 3)
		{
			PrefixToInfix obj = new PrefixToInfix();
			  Scanner sc = new Scanner(System.in);
			  System.out.print("Prefix input: ");
			  String prefix = sc.next();
			  System.out.println("Output : "+obj.convert(prefix));
			  System.out.println();
		}
	 }
	}
}

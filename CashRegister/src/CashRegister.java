import java.text.DecimalFormat;
import java.util.Scanner;

public class CashRegister 
{
	static int [] Register = {0, 0, 10, 20, 20, 0, 50, 80, 50, 20, 100};
	static DecimalFormat df = new DecimalFormat("#.00");
	
	public static void main(String[] args) 
	   {
		int input=0;
		double total=577.00; // Set for the total of starting money
		int operations=0; // Print operations after a sale * 2 points
		
			while(input==0)
			{
				Scanner scan = new Scanner(System.in);
				System.out.println("What would you like to do?");
				System.out.println("1: Make a sale");
				System.out.println("2: Make change");
				System.out.println("3: Print Balance");
				System.out.println("4: Exit");
				System.out.println("Select an option (e.g., '1': ) ");
				input = scan.nextInt();
				operations++;
		   
		   while (input==1) // Make a sale *Easy, hard and failed greedy* 3 points ***Big-Oh is O(2N^2)
		   {
			   Scanner scan2 = new Scanner(System.in);
			   Scanner scan3 = new Scanner(System.in);
			   Scanner scan4 = new Scanner(System.in);
			   System.out.println("What was the total cost? (e.g., '20.24')");
			   double cost1 = scan2.nextDouble();
			   double cost2 = cost1*100;
			   int cost = (int) cost2;
			   int money = 0;
			   int remainder = 0;
			   operations++;
			   
			   int i = 1;
			   String currency = null;
			while(i!=0)
			{
				// When entering currency, enter one at a time
			   System.out.println("What was the given currency? Enter one string at a time. (e.g., 'Twenty')");
			   currency = scan3.nextLine();
			   // You will be asked if you would like to enter another, enter 1 to add another or 0 to finish.
			   System.out.println("Add another given currency? (1:Yes, 0:No)");
			   int addCurrency = scan4.nextInt();
			   operations++;
			   if(addCurrency == 0)
			   i=0;
			   
			   switch (currency.toUpperCase()) 
				{
			    case "ONEHUNDRED":
			    	Register[0]++;
			    	money+=10000;
			    	operations++;
			        break;
			 
			    case "FIFTY":
			    	Register[1]++;
			    	money+=5000;
			    	operations++;
			        break;
			 
			    case "TWENTY":
			    	Register[2]++;
			    	money+=2000;
			    	operations++;
			        break;
			 
			    case "TEN":
			    	Register[3]++;
			    	money+=1000;
			    	operations++;
			        break;
			 
			    case "FIVE":
			    	Register[4]++;
			    	money+=500;
			    	operations++;
			        break;
			        
			    case "TWO":
			    	Register[5]++;
			    	money+=200;
			    	operations++;
			        break;

			    case "ONE":
			    	Register[6]++;
			    	money+=100;
			    	operations++;
			        break;
			        
			    case "QUARTER":
			    	Register[7]++;
			    	money+=25;
			    	operations++;
			        break;
			        
			    case "DIME":
			    	Register[8]++;
			    	money+=10;
			    	operations++;
			        break;
			        
			    case "NICKEL":
			    	Register[9]++;
			    	money+=5;
			    	operations++;
			        break;
			        
			    case "PENNY":
			    	Register[10]++;
			    	money+=1;
			    	operations++;
			        break;
			 
			    default:
				}
			}
			   //printArray(Register);
			   //System.out.println(df.format(money));
			   System.out.println(); 
			   
			if(money<cost)
			{
				// If enough money wasn't given, print error
				System.out.println("Either you didnt give enough money, or the total cost was wrong. Try again.");
				operations++;
				System.out.println("Number of operations: "+operations);
			}
			
			if(money>cost)
			{
				int hundreds=0, fifties=0, twenties=0, tens=0, fives=0, twos=0, ones=0, quarters=0, dimes=0, nickels=0, pennies=0;
				remainder=(money-cost);
				double remainder2=remainder;
				double remainder3=remainder2/100;
				System.out.println("Your change is "+ df.format(remainder3));
				
				while(remainder>=10000 && Register[0]>0)
				{
					Register[0]--;
					remainder-=10000;
					hundreds++;
					operations++;
				}
				while(remainder>=5000 && Register[1]>0)
				{
					Register[1]--;
					remainder-=5000;
					fifties++;
					operations++;
				}
				while(remainder>=2000 && Register[2]>0)
				{
					Register[2]--;
					remainder-=2000;
					twenties++;
					operations++;
				}
				while(remainder>=1000 && Register[3]>0)
				{
					Register[3]--;
					remainder-=1000;
					tens++;
					operations++;
				}
				while(remainder>=500 && Register[4]>0)
				{
					Register[4]--;
					remainder-=500;
					fives++;
					operations++;
				}
				while(remainder>=200 && Register[5]>0)
				{
					Register[5]--;
					remainder-=200;
					twos++;
					operations++;
				}
				while(remainder>=100 && Register[6]>0)
				{
					Register[6]--;
					remainder-=100;
					ones++;
					operations++;
				}
				while(remainder>=25 && Register[7]>0)
				{
					Register[7]--;
					remainder-=25;
					quarters++;
					operations++;
				}
				while(remainder>=10 && Register[8]>0)
				{
					Register[8]--;
					remainder-=10;
					dimes++;
					operations++;
				}
				while(remainder>=5 && Register[9]>0)
				{
					Register[9]--;
					remainder-=5;
					nickels++;
					operations++;
				}
				while(remainder>=1 && Register[10]>0)
				{
					Register[10]--;
					remainder-=1;
					pennies++;
					operations++;
				}
				
				System.out.println("The most efficiant way to make change is ");
				if(remainder==0)
				{
				System.out.println("100's: "+hundreds);
				System.out.println("50's: "+fifties);
				System.out.println("20's: "+twenties);
				System.out.println("10's: "+tens);
				System.out.println("5's: "+fives);
				System.out.println("2's: "+twos);
				System.out.println("1's: "+ones);
				System.out.println("Quarters: "+quarters);
				System.out.println("Dimes: "+dimes);
				System.out.println("Nickels: "+nickels);
				System.out.println("Pennies: "+pennies);
				System.out.println();
				operations++;
				System.out.println("Number of operations: "+operations);
				System.out.println();
				input=0;
				}
				else if(remainder!=0)
				{
					System.out.println("Cant make appropriate change. Sorry");
					operations++;
					System.out.println("Number of operations: "+operations);
					System.out.println();
					break;
				}
			}
			
			if(money==cost)
			{
				System.out.println("Sale complete!");
				operations++;
				System.out.println("Number of operations: "+operations);
				System.out.println();
				System.out.println();
				input=0;
			}
			total = total+(money/100);
			}
		   
		   while (input==2) // Make change *Easy, hard and failed greedy* 3 points ***Big-Oh is O(2N)
		   {
			   
			   int hundreds=0, fifties=0, twenties=0, tens=0, fives=0, twos=0, ones=0, quarters=0, dimes=0, nickels=0, pennies = 0;
			   int money = 0;
			   int i = 1;
			   String currency = null;
			   Scanner scan5 = new Scanner(System.in);
			   Scanner scan6 = new Scanner(System.in);
			   while(i!=0)
				{
			   System.out.println("Enter the currency you would you like to make change for? (e.g., 'Onehundred')");
			   currency = scan5.nextLine();
			   System.out.println("Add another currency? (1:Yes, 0:No)");
			   int addCurrency = scan6.nextInt();
			   if(addCurrency == 0)
			   i=0;
			   
			   switch (currency.toUpperCase()) 
				{
			    case "ONEHUNDRED":
			    	money+=10000;
			        break;
			 
			    case "FIFTY":
			    	money+=5000;
			        break;
			 
			    case "TWENTY":
			    	money+=2000;
			        break;
			 
			    case "TEN":
			    	money+=1000;
			        break;
			 
			    case "FIVE":
			    	money+=500;
			        break;
			        
			    case "TWO":
			    	money+=200;
			        break;

			    case "ONE":
			    	money+=100;
			        break;
			        
			    case "QUARTER":
			    	money+=25;
			        break;
			        
			    case "DIME":
			    	money+=10;
			        break;
			        
			    case "NICKEL":
			    	money+=5;
			        break;
			        
			    case "PENNY":
			    	money+=1;
			        break;
			 
			    default:
			}
				}
			   int remainder = money;
			   double remainder2 = remainder;
			   double remainder3 = remainder2/100;
			   System.out.println("With the money that is currently in the register, the best way to make change for "+df.format(remainder3)+ " is:");
				
				while(remainder>=10000 && Register[0]>0)
				{
					Register[0]--;
					remainder-=10000;
					hundreds++;
				}
				while(remainder>=5000 && Register[1]>0)
				{
					Register[1]--;
					remainder-=5000;
					fifties++;
				}
				while(remainder>=2000 && Register[2]>0)
				{
					Register[2]--;
					remainder-=2000;
					twenties++;
				}
				while(remainder>=1000 && Register[3]>0)
				{
					Register[3]--;
					remainder-=1000;
					tens++;
				}
				while(remainder>=500 && Register[4]>0)
				{
					Register[4]--;
					remainder-=500;
					fives++;
				}
				while(remainder>=200 && Register[5]>0)
				{
					Register[5]--;
					remainder-=200;
					twos++;
				}
				while(remainder>=100 && Register[6]>0)
				{
					Register[6]--;
					remainder-=100;
					ones++;
				}
				while(remainder>=25 && Register[7]>0)
				{
					Register[7]--;
					remainder-=25;
					quarters++;
				}
				while(remainder>=10 && Register[8]>0)
				{
					Register[8]--;
					remainder-=10;
					dimes++;
				}
				while(remainder>=5 && Register[9]>0)
				{
					Register[9]--;
					remainder-=5;
					nickels++;
				}
				while(remainder>=1 && Register[10]>0)
				{
					Register[10]--;
					remainder-=1;
					pennies++;
				}
				
				if(remainder==0)
				{
				System.out.println("100's: "+hundreds);
				System.out.println("50's: "+fifties);
				System.out.println("20's: "+twenties);
				System.out.println("10's: "+tens);
				System.out.println("5's: "+fives);
				System.out.println("2's: "+twos);
				System.out.println("1's: "+ones);
				System.out.println("Quarters: "+quarters);
				System.out.println("Dimes: "+dimes);
				System.out.println("Nickels: "+nickels);
				System.out.println("Pennies: "+pennies);
				System.out.println();
				input=0;
				}
				else if(remainder!=0)
				{
					System.out.println("Cant make appropriate change. Sorry");
					break;
				}
		   }
		   
		   while (input==3) // Print balances * 1 point ***Big-Oh is O(1)
		   {
			   System.out.println("Current Balance: "+df.format(total));
			   System.out.println("100's: "+Register[0]);
			   System.out.println("50's: "+Register[1]);
			   System.out.println("20's: "+Register[2]);
			   System.out.println("10's: "+Register[3]);
			   System.out.println("5's: "+Register[4]);
			   System.out.println("2's: "+Register[5]);
			   System.out.println("1's: "+Register[6]);
			   System.out.println("Quarters: "+Register[7]);
			   System.out.println("Dimes: "+Register[8]);
			   System.out.println("Nickels: "+Register[9]);
			   System.out.println("Pennies: "+Register[10]);
			   System.out.println();
			   input=0;
		   }
		   
		   while (input==4) // Exit
		   {
			   System.out.println("Goodbye!");
			   break;
		   }
		}
	   }
	
	private static void printArray(int[] anArray) {
	      for (int i = 0; i < anArray.length; i++) {
	          if (i > 0) {
	             System.out.print(", ");
	          }
	          System.out.print(anArray[i]);
	       }
	    }
}
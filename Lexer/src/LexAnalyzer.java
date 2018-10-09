import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LexAnalyzer 
{
	public static void main(String[] args) throws IOException  
    {
		String input=null;
					try {
						File file = new File("/Users/jonathanboyd/Desktop/Test/test.txt");
						FileReader fileReader = new FileReader(file);
						BufferedReader bufferedReader = new BufferedReader(fileReader);
						StringBuffer test = new StringBuffer();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							test.append(line);
							test.append("\n");
						}
						fileReader.close();
						input = (test.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
		
	System.out.println("Input: ");
	System.out.println(input);
	System.out.println();
	//String input = "C = age + 3 – 5 * (D / C)";
	input = input.replace("(", "( ");
	input = input.replace(")", " )");
    
    String[] input_split = input.split("\\s+");
    
    //System.out.println(Arrays.toString(input_split));
    
    int n = input_split.length;
    int i=0;
    String input_holder = null;
    
    while(i!= n)
    {
   switch (input_split[i].toLowerCase()) 
		{
		case "(": // If token is left parentheses
			input_holder = input_split[i];
			input_split[i] = "LEFT_PAREN";
			System.out.println("The next token is: " + (input_split[i]) + "\t The next lexeme is: " + input_holder);
			 i++;
			 break;
		case ")": // If token is right parentheses
			input_holder = input_split[i];
			input_split[i] = "RIGHT_PAREN";
			System.out.println("The next token is: " + (input_split[i]) + "\t The next lexeme is: " + input_holder);
			i++;
			break;
		case "=": // If token is equals operator
			input_holder = input_split[i];
			input_split[i] = "ASSIGN_OP";
			System.out.println("The next token is: " + (input_split[i]) + "\t The next lexeme is: " + input_holder);
			 i++;
			 break;
		case "+": // If token is addition operator
			input_holder = input_split[i];
			input_split[i] = "ADD_OP";
			System.out.println("The next token is: " + (input_split[i]) + "\t The next lexeme is: " + input_holder);
			i++;
			break;
		case "-": //
		case "–": // If token is minus operator
			input_holder = input_split[i];
			input_split[i] = "SUB_OP";
			System.out.println("The next token is: " + (input_split[i]) + "\t The next lexeme is: " + input_holder);
			i++;
			break;
		case "*": // If token is multiply operator
			input_holder = input_split[i];
			input_split[i] = "MULT_OP";
			System.out.println("The next token is: " + (input_split[i]) + "\t The next lexeme is: " + input_holder);
			i++;
			break;
		case "/": // If token is divide operator
			input_holder = input_split[i];
			input_split[i] = "DIV_OP";
			System.out.println("The next token is: " + (input_split[i]) + "\t The next lexeme is: " + input_holder);
			i++;
			break;
		case "|": // For end of line
			System.out.println("\n");
			 i++;
			 break;
		case "a": case "b": case "c": case "d": case "e": case "f": case "g": case "h": case "i": case "j": case "k": case "l": case "m":
		case "n": case "o": case "p": case "q": case "r": case "s": case "t": case "u": case "v": case "w": case "x": case "y": case "z":
			input_holder = input_split[i];
			input_split[i] = "LET_VAR"; // If token is a letter
			System.out.println("The next token is: " + (input_split[i]) + "\t The next lexeme is: " + input_holder);
			i++;
			break;
		case "sum":     //
		case "total":   //
		case "area":    // If token is an identity
		case "length":  //
		case "width":   //
		case "age":     // 
			input_holder = input_split[i];
			input_split[i] = "IDENT";
			System.out.println("The next token is: " + (input_split[i]) + "\t The next lexeme is: " + input_holder);
			 i++;
			 break;
		default: // If token is anything other than the listed cases the token must be an int
			input_holder = input_split[i];
			input_split[i] = "INT_LIT";
			System.out.println("The next token is: " + (input_split[i]) + "\t The next lexeme is: " + input_holder);
			i++;
		}
    }
    System.out.println("The next token is: END_OF_FILE \t The next lexeme is: EOF");
	
}
}

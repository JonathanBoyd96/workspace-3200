import java.util.Stack;
 
public class PostfixToInfix 
{
 private boolean isOperator(char c){
  if(c == '+' || c == '-' || c == '*' || c =='/' || c == '^')
   return true;
  return false;
 }
  
 public String convert(String postfix){
  Stack<String> s = new Stack<>();
   
  for(int i = 0; i < postfix.length(); i++){
   char c = postfix.charAt(i);
   if(isOperator(c)){
    String b = s.pop();
    String a = s.pop();
    s.push("("+a+c+b+")");
   }
   else
    s.push(""+c);
  }
   
  return s.pop();
 }
}
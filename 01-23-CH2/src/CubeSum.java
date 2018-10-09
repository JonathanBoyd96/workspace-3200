
public class CubeSum 
{
 public static void main (String[] args)
 {
	System.out.println(sum(2));
	System.out.println(sum(3)); 
	System.out.println(sum(4)); 
	System.out.println(sum(5)); 
 }
 
 public static int sum(int n) // F(N) = 0 + 1 + N + 1 = 0(N)
 {
	 int partialSum; // zero time
	 partialSum=0; // one time = 0(1)
	 for(int i = 1; // one time = 0(1)
		 i<=n;
		 i++)
	 {
		 partialSum += i*i*i;
	 }
	 return partialSum;
 }
}

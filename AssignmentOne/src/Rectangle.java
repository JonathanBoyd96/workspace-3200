import java.io.FileNotFoundException;
import java.util.Comparator;

public class Rectangle 
{
	static double w;
	static double h;
	
	public static <E> E findMax(E[] arr, Comparator<? super E> cmp) {
	    int maxIndex = 0;
	    for (int i = 1; i < arr.length; i++) {
	        if (cmp.compare(arr[i], arr[maxIndex]) > 0) {
	            maxIndex = i;
	        }
	    }
	    return arr[maxIndex];
	}
	
	private static class AreaComparator implements Comparator<Rectangle> {
	    public int compare(Rectangle lhs, Rectangle rhs) {
	        return Double.compare(lhs.getArea(), rhs.getArea());
	    }
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		Rectangle[] arr = new Rectangle[10];

		for(int i = 0; i < 10; i++)
		{
		 Rectangle r = new Rectangle();
		 r.getHeight();
		 r.getWidth();

		 arr[i] = r;
		}

		// prints "Rectangle@14ae5a5"???
	    System.out.println(findMax(new Rectangle[] { new Rectangle(), new Rectangle() }, new AreaComparator()));
	    System.out.println();
	    
	    // test outprints
	    System.out.println("Width is: " + w);
	    System.out.println("Hieght is: " + h);
	    System.out.println(java.util.Arrays.toString());
	    
		
	}
	
	public double getArea() 
		{
        	return w * h;
		}

	public void getHeight() 
		{
	    	h = (Math.random()*40)+10;
	    }

	public void getWidth() 
		{
	    	w = (Math.random()*40)+10;
	    }
	
}

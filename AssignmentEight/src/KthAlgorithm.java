import java.util.Arrays;
import java.util.Scanner;

public class KthAlgorithm 
{

	public static class BinaryHeap<AnyType extends Comparable<? super AnyType>> 
	{
		private static final int DEFAULT_CAPACITY = 10;
		private int currentSize;
		private AnyType [ ] array;
		
		public BinaryHeap(int Capacity )
	    {
	        currentSize = 0;
	        array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1 ];
	    }
		
	    public BinaryHeap( AnyType [ ] items )
	    {
	        currentSize = items.length;
	        array = (AnyType[]) new Comparable[ items.length + 1 ];
	        
	        for( int i = 0; i < items.length; i++ )
	            array[ i + 1 ] = items[ i ];
	        buildHeap( );    
	    }
	    
	    private void doubleArray( )
	    {
	        AnyType [ ] newArray;

	        newArray = (AnyType []) new Comparable[ array.length * 2 ];
	        for( int i = 0; i < array.length; i++ )
	            newArray[ i ] = array[ i ];
	        array = newArray;
	    }
	    
	    public Object insert( AnyType x )
	    {
	        if( currentSize + 1 == array.length )
	            doubleArray( );

	        int hole = ++currentSize;
	        array[ 0 ] = x;
	        
	        for( ; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
	            array[ hole ] = array[ hole / 2 ];
	        array[ hole ] = x;
	        
	        return null;
	    }
	    
	    public AnyType findMin( ) throws Exception
	    {
	        if( isEmpty( ) )
	            throw new Exception( "Empty binary heap" );
	        return array[ 1 ];
	    }
	    
	    public AnyType findMax( ) throws Exception
	    { 
	    	if( isEmpty( ) )
	            throw new Exception( "Empty binary heap" );
	        return array[ currentSize ];
	    }
	    
	    public AnyType deleteMin( ) throws Exception
	    {
	        AnyType minItem = findMin( );
	        array[ 1 ] = array[ currentSize-- ];
	        percolateDown( 1 );

	        return minItem;
	    }
	    
	    public AnyType deleteMax( ) throws Exception
	    {
	    	AnyType maxItem = findMax( );
	        array[ currentSize ] = array[ currentSize-- ];
	        
	        return maxItem;
	    }
	    
	    public boolean isEmpty( )
	    {
	        return currentSize == 0;
	    }
	    
	    public void makeEmpty( )
	    {
	        currentSize = 0;
	    }
	    
	    private void percolateDown( int hole )
	    {
	        int child;
	        AnyType tmp = array[ hole ];

	        for( ; hole * 2 <= currentSize; hole = child )
	        {
	            child = hole * 2;
	            if( child != currentSize &&
	                    array[ child + 1 ].compareTo( array[ child ] ) < 0 )
	                child++;
	            if( array[ child ].compareTo( tmp ) < 0 )
	                array[ hole ] = array[ child ];
	            else
	                break;
	        }
	        array[ hole ] = tmp;
	    }
		
		private void buildHeap( )
	    {
	        for( int i = currentSize / 2; i > 0; i-- )
	            percolateDown( i );
	    }
		
		public static void main( String [ ] args ) throws Exception
	    {
	        int numItems = 10;
	        BinaryHeap<Integer> h1 = new BinaryHeap<Integer>(numItems);
	        BinaryHeap<Integer> h2 = new BinaryHeap<Integer>(numItems);
	        Integer [ ] items = new Integer[ numItems-1];
	        Integer [ ] items2 = new Integer[ numItems-1];
	        
	        int i = 10;
	        int j;

	        for( i = 7, j = 0; i != 0; i = ( i + 7 ) % numItems, j++ )
	        {
	            h1.insert( i );
	            items[ j ] = i;
	            h1.buildHeap();					// Execute buildHeap for h1
	        }
	        
	        for( i = 7, j = 0; i != 0; i = ( i + 7 ) % numItems, j++ )
	        {
	            h2.insert( i );
	            items2[ j ] = i;
	            h2.buildHeap();					// Execute buildHeap for h2
	        }
	        
	        
	        System.out.println("This program finds the K'th smallest element.\nWhat would you like 'K' to be?");
	        Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			System.out.println();
			
			while (input!= 1)
			{
				h1.deleteMin();
				h2.deleteMax();
				input--;
			}
			
			int min = h1.findMin();
			int max = h2.findMax();
	        System.out.println(Arrays.toString(items));
	        System.out.println("\nThe K'th smallest element is: "+min);
	        
	        // Couldnt find a way to display largest element.
	        //System.out.println("The K'th largest element is: "+max);
	    }
	}
	
}
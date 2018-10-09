public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> 
{
	
	private static class BinaryNode<AnyType>
	{
		BinaryNode( AnyType theElement )
		{ 
			this( theElement, null, null, false ); 
		}
		
		BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt , boolean Ldelete)
		{
			element = theElement; 
			left = lt; 
			right = rt;
			L = Ldelete;
		}
		
		AnyType element;            
		BinaryNode<AnyType> left;   
		BinaryNode<AnyType> right;  
		boolean L;
	}

	
	private BinaryNode<AnyType> root;
	
	public BinarySearchTree()
	{ 
		root = null;
	}
	
	public void makeEmpty()
	{ 
		root = null;
	}
	
	public boolean isEmpty()
	{ 
		return root == null;
	}
	
	public boolean contains(AnyType x)
	{ 
		return contains( x, root );
	}
	
	public AnyType findMin()
	{
		if(isEmpty())
			return (AnyType) "Tree is Empty";
		
	    return findMin( root ).element;
	}
	
	public AnyType findMax()
	{
		if(isEmpty()) 
			return (AnyType) "Tree is Empty";
		
		return findMax( root ).element;
	}
	
	public void insert(AnyType x)
	{ 
		root = insert( x, root ); 
	}
	
	public void remove( AnyType x )
	{ 
		root = remove( x, root ); 
	}
	
	public void LazyDelete( AnyType x )
	{ 
		root = LazyDelete( x, root ); 
	}
	
	public void printTree()
	{ 
		if (isEmpty()) 
			System.out.println("Empty Tree");
		else 
			printTree(root);
	}
	
	private boolean contains(AnyType x, BinaryNode<AnyType> t)
	{ 
		if (t == null)
			return false;
		
		int compareResult = x.compareTo(t.element);
		
		if (compareResult < 0) 
			return contains( x, t.left );
		else if(compareResult > 0)
			return contains( x, t.right );
		else 
			return true;
	}
	
	private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
	{ 
		if( t == null)
			   return null;
		BinaryNode<AnyType> tmp= findMin(t.left);
		 
		   if (tmp != null) return tmp;
		 
		   if (!t.L) return t;
		 
		   return findMin(t.right);
	}
	
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) 
	{
		if( t == null)
			   return null;
		BinaryNode<AnyType> tmp= findMax(t.right);
		 
		   if (tmp != null) return tmp;
		 
		   if (!t.L) return t;
		 
		   return findMin(t.left);
	}
	
	
	private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
	{
		if (t == null) 
			return new BinaryNode<>( x, null, null, false );
		
		int compareResult = x.compareTo(t.element);
		
		if (compareResult < 0) 
			t.left = insert( x, t.left );
		else if( compareResult > 0 )
		    t.right = insert( x, t.right );
		else
		    ;  // Duplicate; do nothing
		return t;
	}
	
	private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
	{
		if (t == null)
			return t;;
			
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0)
			t.left = remove( x, t.left );
		else if( compareResult > 0 )
		    t.right = remove( x, t.right );
		else if( t.left != null && t.right != null ) // Two children
		{
		    t.element = findMin( t.right ).element;
		    t.right = remove( t.element, t.right );
		}
		else
		    t = ( t.left != null ) ? t.left : t.right;
		return t;
	}
	
	private BinaryNode<AnyType> LazyDelete( AnyType x, BinaryNode<AnyType> t )
	{
		if (t == null)
			return t;
			
		int compareResult = x.compareTo(t.element);
		if (compareResult < 0)
			t.left = LazyDelete( x, t.left );
		else if( compareResult > 0 )
		    t.right = LazyDelete( x, t.right );
		else if( t.left != null && t.right != null )
		{
		    t.element = findMin( t.right ).element;
		    t.right = LazyDelete( t.element, t.right );
		}
		else
		{
		    if (t.left != null || t.left == null)
		    {
		    	t.L = true;
		    }
		}
		return t;
	
	}
	
	private void printTree( BinaryNode<AnyType> t) 
	{
		if (t != null) 
		{
			if (t.L != false)
			{
				printTree(t.left);
				printTree(t.right);
			}
			else
			{
			printTree( t.left );
		    System.out.println( t.element );
		    printTree( t.right );
			}
		}
	}
	
}

public class TestTree 
{
	public static void main(String[] args) 
	{
		BinarySearchTree<String> words = new BinarySearchTree<String>();
		words.insert("1");
		words.insert("2");
		words.insert("3");
		words.insert("4");
		words.insert("5");
		words.insert("6");
		words.insert("7");
		words.insert("8");
		words.insert("9");
		words.insert("10");
		
		words.LazyDelete("1"); // Test findMin with lazydeletion
		words.LazyDelete("10"); // Test findMax with lazydeletion
		
		words.printTree();
		System.out.println("Min is: "+words.findMin()); // Print min
		System.out.println("Max is: "+words.findMax()); // Print max
		
	}

}

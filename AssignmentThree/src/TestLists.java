
public class TestLists 
{

	public static void main(String[] args) 
	{
		MyLinkedListGeneric<Integer> nums = new MyLinkedListGeneric<>();
		nums.add(1); // Adds 1
		nums.add(2); // Adds 2
		nums.add(3); // Adds 3
		nums.add(4); // Adds 4
		nums.add(5); // Adds 5
		System.out.println(nums.printList()); // Prints My LinkedListGeneric before swap method is called
		nums.swap(); // Swaps nums
		System.out.println(nums.printList()); // Prints My LinkedListGeneric after swap method is called
		
		System.out.println();
		System.out.println();
		
		MyDoublyLinkedListGeneric<Integer> nums2 = new MyDoublyLinkedListGeneric<>();
		nums2.add(5); // Adds 5
		nums2.add(4); // Adds 4
		nums2.add(3); // Adds 3
		nums2.add(2); // Adds 2
		nums2.add(1); // Adds 1
		System.out.println(nums2.printList()); // Prints MyDoublyLinkedListGeneric before swap method is called
		nums2.swap(); // Swaps nums2
		System.out.println(nums2.printList()); // Prints MyDoublyLinkedListGeneric after swap method is called
		
		
	}

}
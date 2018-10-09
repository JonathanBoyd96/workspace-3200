import java.util.ArrayList;
import java.util.Scanner;
 
public class GenericMap
{
	
static class HashMap<K, V>
{
    K key;
    V value;
    HashMap<K, V> next;
 

    public HashMap(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}

static class Map<K, V>
{

    private ArrayList<HashMap<K, V>> array;
    private int num;
    private int size;
 

    public Map()
    {
    	array = new ArrayList<>();
    	num = 10;
        size = 0;
 

        for (int i = 0; i < num; i++)
        	array.add(null);
    }
 
    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }
 

    private int getIndex(K key)
    {
        int hashCode = key.hashCode();
        int index = hashCode % num;
        return index;
    }
 

    public V remove(K key)
    {

        int index = getIndex(key);
 

        HashMap<K, V> head = array.get(index);
 

        HashMap<K, V> prev = null;
        while (head != null)
        {

            if (head.key.equals(key))
                break;
 

            prev = head;
            head = head.next;
        }
 

        if (head == null)
            return null;
 

        size--;
 

        if (prev != null)
            prev.next = head.next;
        else
        	array.set(index, head.next);
 
        return head.value;
    }
 

    public V get(K key)
    {

        int index = getIndex(key);
        HashMap<K, V> head = array.get(index);
 

        while (head != null)
        {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
 

        return null;
    }
 

    public void put(K key, V value)
    {

        int index = getIndex(key);
        HashMap<K, V> head = array.get(index);

        
        while (head != null)
        {
            if (head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }
 

        size++;
        head = array.get(index);
        HashMap<K, V> newNode = new HashMap<K, V>(key, value);
        newNode.next = head;
        array.set(index, newNode);
 

        if ((1.0*size)/num >= 0.7)
        {
            ArrayList<HashMap<K, V>> temp = array;
            array = new ArrayList<>();
            num = 2 * num;
            size = 0;
            for (int i = 0; i < num; i++)
            	array.add(null);
 
            for (HashMap<K, V> headNode : temp)
            {
                while (headNode != null)
                {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
    	   
        Map<String, Integer>map = new Map<>();
        String input = null;
        int input2 = 0;
        
		System.out.println("Enter a Key to insert");
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		System.out.println();
		
		System.out.println("Enter a Value to insert");
		Scanner scan2 = new Scanner(System.in);
		input2 = scan2.nextInt();
		System.out.println();
		
        map.put(input, input2);
        
        
       Integer n = map.get(""+input);
  	   if (n != null) 
  	   {
  	     System.out.println(input+": " + n);
  	   }

    }
}
}
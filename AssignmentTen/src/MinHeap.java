import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap<E extends Comparable<? super E>>  
{
    private ArrayList<E> num;

    public MinHeap() 
    {
        this.num = new ArrayList<E>();
    }

    public E minValue() {
        if (this.num.size() == 0) {
            throw new NoSuchElementException();
        }
        return this.num.get(0);
    }
    
    public void add(E newValue) {
    	num.add(newValue);
        int pos = this.num.size()-1;
        
        while (pos > 0) {
            if (newValue.compareTo(this.num.get((pos-1)/2)) < 0) {
            	num.set(pos, this.num.get((pos-1)/2));
                pos = (pos-1)/2;
            }
            else {
                break;
            }
        }
        this.num.set(pos, newValue);
    }
    
    public void remove() 
    {
       E newValue = this.num.remove(this.num.size()-1);
       int pos = 0;
       
       if (this.num.size() > 0) {
           while (2*pos+1 < this.num.size()) {
               int minChild = 2*pos+1;
               if (2*pos+2 < this.num.size() &&
                     this.num.get(2*pos+2).compareTo(this.num.get(2*pos+1)) < 0) {
                   minChild = 2*pos+2;
               }
           
               if (newValue.compareTo(this.num.get(minChild)) > 0) {
                   this.num.set(pos, this.num.get(minChild));
                   pos = minChild;
               }
               else {
                   break;
               }
           }
           this.num.set(pos, newValue);
       }      
    }

    public String toString() 
    {
        return num.toString();
    }
    
    public static void main(String[] args) 
    {
    	MinHeap<Integer> itemHeap = new MinHeap<Integer>();
        int[] a = {10,23,20,4,70,2};

        System.out.println("Before");
        System.out.println(java.util.Arrays.toString(a));
        
        for (int i = 0; i < a.length; i++) 
        {
            itemHeap.add(a[i]);
        }

        for (int i = 0; i < a.length; i++) 
        {
            a[i] = itemHeap.minValue();
            itemHeap.remove();
        }

        System.out.println(java.util.Arrays.toString(a));
    }
}
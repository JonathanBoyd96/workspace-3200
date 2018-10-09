public class Heapsort
{
    public void sort(int arr[])
    {
        int n = arr.length;
 
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapify(arr, i, 0);
        }
    }
 
    void heapify(int arr[], int n, int i)
    {
        int smallest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] < arr[smallest])
        	smallest = l;
 
        if (r < n && arr[r] < arr[smallest])
        	smallest = r;
 
        if (smallest != i)
        {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
 
            heapify(arr, n, smallest);
        }
    }
 
    public static void main(String args[])
    {
        int arr[] = {10, 40, 60, 20, 30, 50};
        int a = arr.length;
 
        System.out.println("Before sorting: ");
        System.out.println(java.util.Arrays.toString(arr));
        System.out.println();
        
        Heapsort ob = new Heapsort();
        ob.sort(arr);
        
        System.out.println("After sorting: ");					// Printed out from greatest to least, opposite as how the book printed
        System.out.println(java.util.Arrays.toString(arr));		// the max heap so im assuming this is the correct way to print it.
    }
}
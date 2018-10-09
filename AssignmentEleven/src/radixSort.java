import java.util.ArrayList;
import java.util.Arrays;

public class radixSort 
{

	public static void main(String[] args) 
	{
		String[] strarr = new String[]{"Word","word","WORD","wOrD"};
		System.out.println(Arrays.toString(strarr));
		radixSortStrings(strarr);
		System.out.println(Arrays.toString(strarr));
	}
	public static void radixSortStrings(String[] arr)
	{
		int max = 0;
		int buckets = 256;
		for(int i = 0; i < arr.length; i++)
		{
			if(max <= arr[i].length())
			{
				max = arr[i].length();
			}
		}
		String[][] word = new String[max + 1][max + 1];
		ArrayList<String>[] BUCKETS = (ArrayList<String>[]) new ArrayList[buckets];
		
		for(int i = 0; i < buckets; i++)
			BUCKETS[i] = new ArrayList<String>( );
		
		for( String s : arr )
		{
			int i = 0;
			while(word[s.length()][i] != null) 
			{
				i++;
			}
			word[s.length()][i] = s;
		}

		int index = 0;
		for (int i = 0; i < word.length; i++) 
		{
			for (int j = 0; j < word[i].length; j++) 
			{
				if(word[i][j] != null)
					arr[index++] = word[i][j];
			}
		}

		//create array of lists and initialize each object
		int startingIndex = arr.length;
		for( int pos = max - 1; pos >= 0; pos-- )
		{
			int temp = 0;
			for(int k = 0; k < word[pos + 1].length; k++)
			{
				if(word[pos + 1][k] != null)
				{
					temp++;
				}
			}
			startingIndex -= temp;

			for( int i = startingIndex; i < arr.length; i++ )
				BUCKETS[ arr[ i ].charAt( pos ) ].add( arr[ i ] );

			index = startingIndex;
			for( ArrayList<String> thisBucket : BUCKETS )
			{
				for( String s : thisBucket )
				{
					arr[ index++ ] = s;
				}

				thisBucket.clear( );
			}
			System.out.println(pos + " : " + Arrays.toString(arr));
		}
	}
}

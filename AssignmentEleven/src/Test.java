import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		String[] strarr = new String[]{"Word","word","WORD","wOrD","words","abcd","abc"};
		System.out.println(Arrays.toString(strarr));
		radixSortString(strarr);
		System.out.println(Arrays.toString(strarr));
	}

	public static void radixSortString( String [ ] arr )
	{
		int buckets = 256;

		int maxLen = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(maxLen <= arr[i].length())
				maxLen = arr[i].length();
		}

		String[][] WordByLength = new String[maxLen + 1][maxLen + 1];
		ArrayList<String>[] Buckets = (ArrayList<String>[]) new ArrayList[buckets];


		for(int i = 0; i < buckets; i++)
		Buckets[i] = new ArrayList<String>( );

		for( String s : arr )
		{
			int i = 0;
			while(WordByLength[s.length()][i] != null) 
			{
				i++;
			}
			WordByLength[s.length()][i] = s;
		}

		int idx = 0;
		for (int o = 0; o < WordByLength.length; o++) {
			for (int p = 0; p < WordByLength[o].length; p++) {
				if(WordByLength[o][p] != null)
					arr[idx++] = WordByLength[o][p];
			}
		}

		int startingIndex = arr.length;
		for( int pos = maxLen - 1; pos >= 0; pos-- )
		{
			int temp = 0;
			for(int k = 0; k < WordByLength[pos + 1].length; k++)
			{
				if(WordByLength[pos + 1][k] != null)
				{
					temp++;
				}
			}
			startingIndex -= temp;

			for( int i = startingIndex; i < arr.length; i++ )
				Buckets[ arr[ i ].charAt( pos ) ].add( arr[ i ] );

			idx = startingIndex;
			for( ArrayList<String> thisBucket : Buckets )
			{
				for( String s : thisBucket )
				{
					arr[ idx++ ] = s;
				}

				thisBucket.clear( );
			}
			System.out.println(pos + " : " + Arrays.toString(arr));
		} 

	}
}
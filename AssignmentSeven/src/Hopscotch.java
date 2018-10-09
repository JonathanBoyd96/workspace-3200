
public class Hopscotch 
{
	public static class HopscotchHashTable<AnyType> {

		private static final int DEFAULT_TABLE_SIZE = 10;
		private static final int RANGE = 8;
		private HashEntry<AnyType>[] array;
		private int occupied;
		private int theSize;

		public HopscotchHashTable() {
			this(DEFAULT_TABLE_SIZE);
		}

		public HopscotchHashTable(int size) {
			allocateArray(size);
			doClear();
		}

		private void allocateArray(int arraySize) {
			array = new HashEntry[arraySize];
		}

		private void doClear() {
			occupied = 0;
			for (int i = 0; i < array.length; i++)
				array[i] = null;
		}

		private int myhash(AnyType x) {
			int hashVal = x.hashCode();

			hashVal %= array.length;
			if (hashVal < 0)
				hashVal += array.length;

			return hashVal;
		}


		public boolean insert(AnyType x) {

			if (!isEmpty()) {
				return false;
			}

			int currentPos = findPos(x);

			if (currentPos == -1) {
				return false;
			}

			if (array[currentPos] != null) {
				x = array[currentPos].element;
				array[currentPos].isActive = true;
			}

			String hope;
			if (array[currentPos] != null) {
				hope = array[currentPos].hope;
				x = array[currentPos].element;
			} else {
				hope = "100";
			}

			array[currentPos] = new HashEntry<>(x, hope, true);
			theSize++;

			return true;
		}

		private void display() {
			for (int i = 0; i < array.length; i++) {
				if (array[i] != null) {
					System.out.println("index :" + i + " array item :"
							+ array[i].element + " hope:" + array[i].hope);
				} else {
					System.out.println("index :" + i + " array item :"
							+ "--" + " hope:" + "--");
				}
			}
		}

		private int findPos(AnyType x) {
			int offset = 0;
			int currentPos = myhash(x);
			int startPosition = currentPos;
			int original = startPosition;
			boolean flag = false;
			boolean f = false;
			while (array[currentPos] != null) {
				currentPos++;

				if (currentPos - startPosition >= 8
						|| (((currentPos) < startPosition) && (array.length
								- startPosition + currentPos) >= 8)) {
					f = true;
				}
				if (f
						&& ((myhash(array[startPosition].element) - currentPos) >= RANGE
								|| (currentPos - myhash(array[startPosition].element)) >= RANGE || ((currentPos - myhash(array[startPosition].element)) < 0 && (array.length
								- myhash(array[startPosition].element) + currentPos) >= 8))) {
					flag = true;
					currentPos = nextJumpPosition(startPosition);
					if (currentPos == -2) {
						return -1;
					}
					startPosition = currentPos;
					offset = 0;
				}
				if (currentPos >= array.length) {
					currentPos = 0;
				}
			}

			if (flag == true) {
				array[currentPos] = new HashEntry<>(array[startPosition].element,
						"00000000", true);
				StringBuilder string = new StringBuilder(
						array[myhash(array[startPosition].element)].hope);
				if ((currentPos - myhash(array[startPosition].element)) < 0) {
					string.setCharAt(array.length
							- myhash(array[startPosition].element) + currentPos,
							'1');
				} else {
					string.setCharAt(currentPos
							- myhash(array[startPosition].element), '1');
				}
				array[myhash(array[startPosition].element)].hope = string
						.toString();
				if (array[myhash(array[startPosition].element)].hope
						.charAt(startPosition
								- myhash(array[startPosition].element)) == '1') {
					string = new StringBuilder(
							array[myhash(array[startPosition].element)].hope);
					string.setCharAt(
							(startPosition - myhash(array[startPosition].element)),
							'0');
					array[myhash(array[startPosition].element)].hope = string
							.toString();
				}
				AnyType x1 = x;
				array[startPosition] = new HashEntry<>(x1,
						array[startPosition].hope, true);
				StringBuilder temp = new StringBuilder(array[myhash(x1)].hope);
				if (startPosition-myhash(x1) < 0) {
					temp.setCharAt(array.length - myhash(x1) + startPosition, '1');
				} else {
					temp.setCharAt(startPosition - myhash(x1), '1');
				}
				array[myhash(x1)].hope = temp.toString();
				currentPos = startPosition;
			} else {
				if (startPosition != currentPos) {
					array[currentPos] = new HashEntry<>(x, "00000000", true);
					StringBuilder temp = new StringBuilder(
							array[startPosition].hope);
					int p;
					if (currentPos - startPosition < 0) {
						p = array.length - startPosition + currentPos;
						temp.setCharAt(p, '1');
					} else {
						temp.setCharAt(currentPos - startPosition, '1');
					}

					AnyType x1 = array[startPosition].element;
					array[startPosition] = null;
					array[startPosition] = new HashEntry<>(x1, temp.toString(),
							true);
					currentPos = startPosition;
				}
			}

			return currentPos;
		}

		private boolean isEmpty() {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == null) {
					return true;
				}
			}
			return false;
		}

		private int nextJumpPosition(int startPosition) {
			int position = startPosition + 1;
			int c = checkHope(position);
			while (c == -1) {
				if (position >= array.length) {
					position = 0;
					c = checkHope(position);
				}
				if (position == startPosition) {
					return -2;
				}
				c = checkHope(position++);
			}
			return c;
		}

		private int checkHope(int position) {
			if (array[position] != null
					&& (!array[position].hope.equals("00000000") && !array[position].hope
							.equals("00000001"))) {
				for (int i = 0; i < array[position].hope.length(); i++) {
					if (array[position].hope.charAt(i) == '1') {
						return position + i;
					}
				}
			}
			return -1;
		}

		private static class HashEntry<AnyType> {
			public AnyType element;
			public String hope;
			public boolean isActive;

			public HashEntry(AnyType e) {
				this(e, true);
			}

			public HashEntry(AnyType e, boolean i) {
				element = e;
				isActive = i;
			}

			public HashEntry(AnyType e, String h, boolean i) {
				element = e;
				hope = h;
				isActive = i;
			}
		}

		public static void main(String[] args) 
		{
			HopscotchHashTable<Integer> H1 = new HopscotchHashTable<>();
			 
			H1.insert(1);
			H1.insert(3);
			H1.insert(6);
			H1.insert(5);
			H1.insert(4);
			H1.insert(2);
			
			System.out.println("Table after insert: \n");
			H1.display();
			
			
		}
	}
}

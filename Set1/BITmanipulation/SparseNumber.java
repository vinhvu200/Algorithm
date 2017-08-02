// http://www.geeksforgeeks.org/given-a-number-find-next-sparse-number/

public class SparseNumber {

	public boolean isSparse(int num) {

		for (int i=1; i<31; i++) {
		
			int current = num & (1 << i);

			if (current == (1 << i)) {

				int before = num & (1 << i-1);
				int after = num & (1 << i+1);

				before <<= 1;
				after >>= 1;

				if (current == before || current == after)
					return false;
			}
		}

		return true;
	}

	public int nextSparse(int num) {
	
		int i=0;
		while (i < 30000) {
		
			if (isSparse(num))
				return num;
			else
				num++;
			i++;
		}
		
		return -1;
	}

	public static void main(String[] args) {

		SparseNumber obj = new SparseNumber();
		System.out.println(obj.nextSparse(6));
		System.out.println(obj.nextSparse(4));

	}
}

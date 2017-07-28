// http://www.geeksforgeeks.org/find-the-element-that-appears-once/

public class AppearOnce {

	public int appearOnce(int[] arr) {
	
		int ans = 0;

		for (int i=0; i<32; i++) {

			int result = 0;
			int bitPlace = (1 << i);
			for (int j=0; j<arr.length; j++) {
			
				result += (arr[j] & bitPlace);
			}

			if (result % 3 != 0)
				ans |= bitPlace;
		}
		return ans;
	}

	public static void main(String[] args) {
	
		int[] arr = {12,1,12,3,12,1,1,15,3,3};
		AppearOnce obj = new AppearOnce();

		System.out.println(obj.appearOnce(arr));
	}
}

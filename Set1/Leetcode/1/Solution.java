import java.util.HashMap;
import java.util.Map;

public class Solution{

	public static int[] twoSum(int[] nums, int target){
		
		Map<Integer, Integer> map = new HashMap<>();

		for (int i=0; i<nums.length; i++){
		
			map.put(nums[i], i);
		}

		for (int i=0; i<nums.length; i++){
		
			int complement = target - nums[i];
			if (map.containsKey(nums[i]) && map.get(complement) != i)
				return new int[] { i, map.get(complement) };
		}

		throw new IllegalArgumentException("None");
	}

	public static void main(String[] args){
		
		int[] array = {7, 2, 9, 11};
		int target = 9;

		int[] answer;
		answer = twoSum(array, target);

		for (int i=0; i<answer.length; i++){
			System.out.print(answer[i] + " ");
		}
		System.out.println();
	}
}

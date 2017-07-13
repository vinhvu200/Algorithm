// http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/

public class PreorderArray {

	// O(n^2)
	public boolean preorderArray(int[] arr, int l, int r) {
	
		if (l < r) {
		
			boolean rightNodeFound = false;
			int rightNode = -1;
			int root = arr[l];
			int pos=r;
			for (int i=l+1; i<=r; i++) {
			
				if (!rightNodeFound && arr[i] > root){
				
					rightNode = arr[i];
					rightNodeFound = true;
					pos=i;
				}
				else if (rightNodeFound && arr[i] < rightNode)
					return false;
			}
	
			boolean leftSubTree = preorderArray(arr, l+1, pos-1);
			boolean rightSubTree = preorderArray(arr, pos+1, r);

			return leftSubTree && rightSubTree;
			
		}

		return true;
	}

	public static void main(String[] args) {
	
		PreorderArray obj = new PreorderArray();
		int[] array = {40,30,35,80,100};
		System.out.println(obj.preorderArray(array,0,array.length-1));
	}
}

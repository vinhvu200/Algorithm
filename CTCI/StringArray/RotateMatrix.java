public class RotateMatrix {

	public void rotate(int[][] mat) {
	
		for (int layer=0; layer<mat.length/2; layer++) {
		
			int first = layer;
			int last = mat.length-layer-1;

			for (int i=first; i < last; i++) {

				int offset = i - first;

				// Save top
				int temp = mat[first][i];

				// left to top
				mat[first][i] = mat[last-offset][first];

				// bottom to left
				mat[last-offset][first] = mat[last][last-offset];

				// right to bottom
				mat[last][last-offset] = mat[first+offset][last];

				// top to right
				mat[first+offset][last] = temp;
			}

		}

		/*
		for (int i=0; i<mat.length/2; i++) {
		
			int offset = i;
			for (int j=i; j<mat.length-i; j++) {

				int first = i;
				int last = mat.length-i;

				// Save top
				int temp = mat[i][j];

				// left to top
				mat[i][j] = mat[last-offset][i];

				// bottom to left
				mat[last-offset][i] = mat[last][last-offset];

				// right to bottom
				mat[last][last-offset] = mat[last-offset][last];

				// top to right
				mat[last-offset][last] = temp;

				offset++;
			}
		}
		*/

	}

	public static void main(String[] args) {

		RotateMatrix obj = new RotateMatrix();
		int[][] mat = { {1,2,3},
						{4,5,6},
						{7,8,9} };

		for (int i=0; i<mat.length; i++) {
		
			for (int j=0; j<mat.length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
		System.out.println();

		obj.rotate(mat);

		for (int i=0; i<mat.length; i++) {
		
			for (int j=0; j<mat.length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}
}

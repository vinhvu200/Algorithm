import java.util.ArrayList;

public class ZeroMatrix {

	public void zero(int[][] mat) {
	
		ArrayList<Integer> rowsToChange = new ArrayList<>();
		ArrayList<Integer> colsToChange = new ArrayList<>();

		for (int i=0; i<mat.length; i++)
			for (int j=0; j<mat[0].length; j++) {
			
				if (mat[i][j] == 0) {
					rowsToChange.add(i);
					colsToChange.add(j);
				}
			}

		for (int i=0; i < rowsToChange.size(); i++) {
		
			for (int col=0; col<mat[0].length; col++)
				mat[rowsToChange.get(i)][col] = 0;
		}

		for (int i=0; i < colsToChange.size(); i++) {
		
			for (int row=0; row<mat.length; row++)
				mat[row][colsToChange.get(i)] = 0;
		}

	}

	public static void main(String[] args) {

		int[][] mat = { {1,2,3,0},
						{2,0,5,7},
						{3,4,5,6} };

		for (int i=0; i<mat.length; i++) {
		
			for (int j=0; j<mat[0].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
		System.out.println();

		ZeroMatrix obj = new ZeroMatrix();
		obj.zero(mat);

		for (int i=0; i<mat.length; i++) {
		
			for (int j=0; j<mat[0].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}
}

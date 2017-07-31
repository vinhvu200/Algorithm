// http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/

public class Boggle {

	private boolean inDictionary(String s) {
	
		String[] arr = {"GEEKS", "FOR", "QUIZ", "GO"};

		for (int i=0; i<arr.length; i++)
			if (arr[i].equals(s))
				return true;

		return false;
	}

	private void boggle_util(char[][] arr, int i, int j, String str, boolean[][] visited) {
	
		String c = String.valueOf(arr[i][j]);
		str += c;
		visited[i][j] = true;

		if (inDictionary(str))
			System.out.println(str);

		// left
		if (j-1 >=0 && !visited[i][j-1])
			boggle_util(arr, i, j-1, str, visited);

		// left up
		if (i-1 >= 0 && j-1 >= 0 && !visited[i-1][j-1])
			boggle_util(arr, i-1, j-1, str, visited);

		// left down
		if (i+1 < arr.length && j-1 >= 0 && !visited[i+1][j-1])
			boggle_util(arr, i+1, j-1, str, visited);

		// right
		if (j+1 < arr.length && !visited[i][j+1]) 
			boggle_util(arr, i, j+1, str, visited);
		
		// right up
		if (i-1 >= 0 && j+1 < arr.length && !visited[i-1][j+1])
			boggle_util(arr, i-1, j+1, str, visited);

		// right down
		if (i+1 < arr.length && j+1 < arr.length && !visited[i+1][j+1])
			boggle_util(arr, i+1, j+1, str, visited);

		// up
		if (i-1 >=0 && !visited[i-1][j])
			boggle_util(arr, i-1, j, str, visited);

		// down
		if (i+1 < arr.length && !visited[i+1][j])
			boggle_util(arr, i+1, j, str, visited);

		str = str.substring(0,str.length()-1);
		visited[i][j] = false;
	}

	public void boggle(char[][] arr) {

		String str = "";
		boolean[][] visited = new boolean[arr.length][arr.length];

		for (int i=0; i<arr.length; i++)
			for (int j=0; j<arr.length; j++)
				visited[i][j] = false;

		for (int i=0; i<arr.length; i++)
			for (int j=0; j<arr.length; j++)
				boggle_util(arr, i, j, str, visited);
	}

	public static void main(String[] args) {

		Boggle obj = new Boggle();

		char[][] boggle = { {'G', 'I', 'Z'},
					 		{'U', 'E', 'K'},
					 		{'Q', 'S', 'E'} };

		obj.boggle(boggle);
	}
}

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class MagicSquare2
{
	private int[][] mat;

	//size the matrix and make the magic square pattern
	//write alls nested loop code here in the constructor
	public MagicSquare2(int size) {
		mat = new int[size][size];
	}
	
	public void createMagic() {
        int n = mat.length;
        int num = 1;
        int row = 0;
        int col = n / 2;

        while (num <= n * n) {
            mat[row][col] = num;
            num++;
            int newRow = (row - 1 + n) % n;
            int newCol = (col + 1) % n;
            if (mat[newRow][newCol] != 0) {
                newRow = (row + 1) % n;
                newCol = col;
            }
            row = newRow;
            col = newCol;
            
		}
	}


	public String toString() {
		String output = "";
	    int n = mat.length;
	    for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++)
	            output += " " + mat[i][j];
	        output += "\n";
		}
		return output;
	}
}
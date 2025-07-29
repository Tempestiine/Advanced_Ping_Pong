//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class SpiralMatrix
{
	//define a matrix
	int[][] spiral;

	public SpiralMatrix() {
		spiral = new int[3][3];
	}
	public SpiralMatrix(int size) {
		spiral = new int[size][size];
	}

	public void createSpiral() {
		int n = spiral.length;
		int value = 1; //Increasing value
		int top = 0, bottom = n - 1, left = 0, right = n - 1; //Row and Columns
		
		//Spiral until the matrix is filled
		while (value <= n * n) {
			for (int x = top; x <= bottom; x++)
	            spiral[x][left] = value++;
	        left++;
	        for (int x = left; x <= right; x++)
	            spiral[bottom][x] = value++;
	        bottom--;
	        for (int x = bottom; x >= top; x--)
	            spiral[x][right] = value++;
	        right--;
	        for (int x = right; x >= left; x--)
	            spiral[top][x] = value++;
	        top++;
		}
	}

	public String toString() {
		String output="";
		for (int[] row : spiral) {
			for (int value : row)
				output += value + "\t";
			output += "\n";
		}
		return output;
	}
}
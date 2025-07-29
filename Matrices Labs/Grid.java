//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Grid
{
   private String[][] grid;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals) {
		grid = new String[rows][cols];
		for (int x = 0; x < rows; x++)
			for (int y = 0; y < cols; y++)
				grid[x][y] = vals[(int) (Math.random() * 6)];
	}

	//find out which of the vals occurs the most
	public String findMax(String[] vals) {
		int index = 0;
		for (int s = 0; s < vals.length; s++)
			if (countVals(vals[s]) > countVals(vals[index]))
				index = s;
		return vals[index] + " occurs the most.";
	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val ) {
		int total = 0;
		for (String[] row : grid)
			for (String num : row)
				if (num.equals(val))
					total++;
		return total;
	}

	//display the grid
	public String toString() {
		String output = "";
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++)
				output += grid[x][y] + " ";
			output += "\n";
		}
		return output;
	}
}
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.util.Scanner;

public class MagicSquare1 {
	private int[][] mat;

	public MagicSquare1(int size, String numbers) {
		mat = new int[size][size];
		Scanner sc = new Scanner(numbers);
		for (int r = 0; r < size; r++)
			for (int c = 0; c < size; c++)
				mat[r][c] = sc.nextInt();
	}

	public boolean isMagicSquare() {
		int size = mat.length;
		int targetSum = sumRow(0);
		for (int r = 0; r < size; r++)
			if (sumRow(r) != targetSum)
				return false;
		for (int c = 0; c < size; c++)
			if (sumCol(c) != targetSum)
				return false;
		if (sumDownDiag() != targetSum || sumUpDiag() != targetSum)
			return false;
		return true;
	}

	public int sumRow( int r ) {
		int sum = 0;
		for (int c = 0; c < mat[r].length; c++)
			sum += mat[r][c];
		return sum;
	}
	public int sumCol( int c ) {
		int sum = 0;
		for (int r = 0; r < mat.length; r++)
			sum += mat[r][c];
		return sum;
	}
	public int sumDownDiag() {
		int sum = 0;
		for (int i = 0; i < mat.length; i++)
			sum += mat[i][i];
		return sum;
	}
	public int sumUpDiag() {
		int sum = 0;
		for (int i = 0; i < mat.length; i++)
			sum += mat[i][mat.length - 1 - i];
		return sum;
	}

	public String toString() {
		String output = "";
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++)
                output += mat[r][c] + " ";
            output += "\n";
        }
        return output;
	}
}
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class PascalsTriangle
{
	private int[][] mat;

	public PascalsTriangle() {
		mat = new int[3][3];
		createTriangle();
	}
	public PascalsTriangle(int size) {
		mat = new int[size][size];
		createTriangle();
	}

	public void createTriangle() {
		int n = mat.length;
		
		for (int x = 0; x < n; x++) {
			mat[x][0] = 1;
			mat[x][x] = 1;
			
			for (int y = 1; y < x; y++)
				mat[x][y] = mat[x-1][y-1] + mat[x-1][y];
		}



	}

	public String toString() {
		String output = " ";
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++)
                output += " ";
            for (int j = 0; j <= i; j++) {
                output += mat[i][j] + " ";
            }
            output += "\n";
        }
        return output;
		}
	}
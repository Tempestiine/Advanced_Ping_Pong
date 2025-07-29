//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class MatrixSumming2
{
    private int[][] m = {
    {1,2,3,4,5},
    {6,7,8,9,0},
    {6,7,1,2,5},
    {6,7,8,9,0},
    {5,4,3,2,1}
    };   //load in the matrix values

    public int sum( int r, int c ) {
    	int total = 0;
    	
    	int row = r - 1;
    	if (row < 0)
    		row = 0;
    	int col = c - 1;
    	if (col < 0)
    		col = 0;
  
    	for (int x = row; x < r + 2 && x < m.length; x++)
    		for (int y = col; y < c + 2 && y < m[x].length; y++)
    			total += m[x][y];
    	return total;
    }

    public String toString()
    {
    	return "";
    }
}

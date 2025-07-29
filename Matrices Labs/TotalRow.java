//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class TotalRow
{
    public static List<Integer> getRowTotals( int[][] m )
    {
    	List<Integer> rowTotals = new ArrayList<>();
		for (int i = 0; i < m.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < m[i].length; j++)
                rowSum += m[i][j];
            rowTotals.add(rowSum);
		}
		return rowTotals;
    }
}

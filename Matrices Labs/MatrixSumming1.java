import java.util.*;
import java.io.*; 

public class MatrixSumming1
{
    private static int[][] m = {{ 1, 2, 3, 4, 5},
                                { 6, 7, 8, 9, 0},
                                { 6, 7, 1, 2, 5},
                                { 6, 7, 8, 9, 0},
                                { 5, 4, 3, 2, 1}};

    public static int sum(int r, int c) {
        int sum = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int row = r + i;
                int col = c + j;
                if (row >= 0 && row < m.length && col >= 0 && col < m[0].length) {
                    sum += m[row][col];
                }
            }
        }
        return sum;
    }
}

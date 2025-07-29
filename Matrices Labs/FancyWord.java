//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.util.*;

public class FancyWord
{
	private String[][] mat;

   public FancyWord(String s) {
		mat = new String[s.length()][s.length()];
		for (int x = 0; x < mat.length; x++)
			Arrays.fill(mat[x], " ");
			
		for (int x = 0; x < s.length(); x++)
			mat[0][x] = s.substring(x, x+1);
		for (int d = 1; d < mat.length; d++) {
			mat[d][d] = s.substring(d, d+1);
			mat[d][s.length() - d - 1] = s.substring(s.length() - d - 1, s.length() - d);
		}
		for (int x = 0; x < s.length(); x++)
			mat[mat.length - 1][x] = s.substring(x, x+1);
	}

	public String toString()
	{
		String output="";
		for (String[] row : mat) {
			for (String s: row)
				output += s;
			output += "\n";
		}
		return output+"\n\n";
	}
}
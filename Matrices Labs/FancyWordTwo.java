//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class FancyWordTwo
{
	private String[][] mat;
	
public FancyWordTwo(String s) {
   	mat = new String[s.length()][s.length()];
   	for (int x = 0; x < mat.length; x++)
   		Arrays.fill(mat[x]," ");	
   	for (int x = 0; x < s.length(); x++) {
   		mat[0][x] = s.substring(x, x+1);
   		mat[x][0] = s.substring(x, x+1);
   	}
   	for (int x = s.length() - 1; x > 0; x--)
   		mat[s.length() - 1][x] = s.substring(s.length() - 1 - x, s.length() - x);
	for (int x = s.length() - 1; x > 0; x--)
   		mat[x][s.length() - 1] = s.substring(s.length() - 1 - x, s.length() - x);

	}

	public String toString()
	{
		String output="";
		for (String[] row : mat) {
			for (String s : row)
				output += s;
			output += "\n";
		}
		return output+"\n\n";
	}
}
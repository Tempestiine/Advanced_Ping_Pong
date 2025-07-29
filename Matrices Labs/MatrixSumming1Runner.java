//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.util.*;
import java.io.*; 

public class MatrixSumming1Runner
{
	public static void main( String args[] ) throws Exception
	{
		Scanner f = new Scanner( new File( "matsum.dat" ));
    	int times = f.nextInt();
    	MatrixSumming2 ms = new MatrixSumming2();
    	for( int dx = 0; dx < times; dx++ )
    	{
    		int r = f.nextInt();
    		int c = f.nextInt();
    		System.out.println("The sum of " + r + "," + c + " is "  + ms.sum(r,c) );
	}
}
}




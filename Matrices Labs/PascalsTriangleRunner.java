//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class PascalsTriangleRunner
{
	public static void main( String args[] ) 
	{
		PascalsTriangle pt = new PascalsTriangle( 3 );
		pt.createTriangle();
		System.out.println( pt );
		
		pt = new PascalsTriangle( 6 );
		pt.createTriangle();
		System.out.println( pt );
		
		pt = new PascalsTriangle( 9 );
		pt.createTriangle();
		System.out.println( pt );				
	}
}




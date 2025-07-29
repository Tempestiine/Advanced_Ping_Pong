//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class MagicSquare2Runner
{
	public static void main( String args[] ) 
	{
		MagicSquare2 mg = new MagicSquare2( 5 );
		mg.createMagic();
		System.out.println( mg );
		
		mg = new MagicSquare2( 7 );
		mg.createMagic();
		System.out.println( mg );
	}
}
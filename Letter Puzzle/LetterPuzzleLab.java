import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;


public class LetterPuzzleLab
	{
		public static void main(String...args)
		{
			JFrame j = new JFrame();  
			MyPanelb m = new MyPanelb();
			j.setSize(m.getSize());
			j.add(m);      
       		j.addMouseListener(m);
			j.setVisible(true);

		}

	}


class MyPanelb extends JPanel implements MouseListener
	{
		
		
		Rectangle r11,r12,r13,r14,r15,r21,r22,r23,r24,r25,r31,r32,r33,r34,r35,r41,r42,r43,r44,r45,r51,r52,r53,r54,r55;
		boolean scramble[];
		String matrix[][];
		Random rnd;
		int blankR;
		int blankC;
		int playLevel;
		int sizer = 2;

		String strNbr1 = JOptionPane.showInputDialog("Enter Play Level \n 3 - 3 X 3 Grid \n 4 - 4 X 4 Grid \n 5 - 5 X 5 Grid");
		int num = Integer.parseInt(strNbr1);


		MyPanelb()
		{
			

			setSize(2000, 1500);
			r11 = new Rectangle(100/sizer,100/sizer,200/sizer,200/sizer);
			r12 = new Rectangle(300/sizer,100/sizer,200/sizer,200/sizer);
			r13 = new Rectangle(500/sizer,100/sizer,200/sizer,200/sizer);
			if(num == 4)
				r14 = new Rectangle(700/sizer,100/sizer,200/sizer,200/sizer);
			if (num == 5)
			{
				r14 = new Rectangle(700/sizer,100/sizer,200/sizer,200/sizer);
				r15 = new Rectangle(900/sizer, 100/sizer,200/sizer,200/sizer);
			}
			r21 = new Rectangle(100/sizer,300/sizer,200/sizer,200/sizer);
			r22 = new Rectangle(300/sizer,300/sizer,200/sizer,200/sizer);
			r23 = new Rectangle(500/sizer,300/sizer,200/sizer,200/sizer);
			if(num ==4)
				r24 = new Rectangle(700/sizer,300/sizer,200/sizer,200/sizer);
			if(num == 5)
			{
				r24 = new Rectangle(700/sizer,300/sizer,200/sizer,200/sizer);
				r25 = new Rectangle(900/sizer,300/sizer,200/sizer,200/sizer);
			}
			r31 = new Rectangle(100/sizer,500/sizer,200/sizer,200/sizer);
			r32 = new Rectangle(300/sizer,500/sizer,200/sizer,200/sizer);
			r33 = new Rectangle(500/sizer,500/sizer,200/sizer,200/sizer);
			if(num ==4)
				r34 = new Rectangle(700/sizer,500/sizer,200/sizer,200/sizer);
			if(num == 5)
			{
				r34 = new Rectangle(700/sizer,500/sizer,200/sizer,200/sizer);
				r35 = new Rectangle(900/sizer,500/sizer,200/sizer,200/sizer);
			}

			if (num==4)
			{	

				r41 = new Rectangle(100/sizer,700/sizer,200/sizer,200/sizer);
				r42 = new Rectangle(300/sizer,700/sizer,200/sizer,200/sizer);
				r43 = new Rectangle(500/sizer,700/sizer,200/sizer,200/sizer);
				r44 = new Rectangle(700/sizer,700/sizer,200/sizer,200/sizer);
				if(num==5)
					r45 = new Rectangle(900/sizer,700/sizer,200/sizer,200/sizer);

			}
			if (num==5)
			{
				r41 = new Rectangle(100/sizer,700/sizer,200/sizer,200/sizer);
				r42 = new Rectangle(300/sizer,700/sizer,200/sizer,200/sizer);
				r43 = new Rectangle(500/sizer,700/sizer,200/sizer,200/sizer);
				r44 = new Rectangle(700/sizer,700/sizer,200/sizer,200/sizer);
				r45 = new Rectangle(900/sizer,700/sizer,200/sizer,200/sizer);

				r51 = new Rectangle(100/sizer,900/sizer,200/sizer,200/sizer);
				r52 = new Rectangle(300/sizer,900/sizer,200/sizer,200/sizer);
				r53 = new Rectangle(500/sizer,900/sizer,200/sizer,200/sizer);
				r54 = new Rectangle(700/sizer,900/sizer,200/sizer,200/sizer);
				r55 = new Rectangle(900/sizer,900/sizer,200/sizer,200/sizer);

			}

			


			if(num ==4)
			{
				matrix = new String[6][6];
			}
			else if(num ==3)
			{
				matrix = new String[5][5];
			}
			else if(num==5)
			{
				matrix = new String[7][7];
			}


			if(num ==4)
			{
				scramble = new boolean[17];
			}
			else if(num ==3)
			{
				scramble = new boolean[10];
			}
			else if(num ==5)
			{
				scramble = new boolean [26];
			}



			if(num == 4)
			{

				for (int k = 1; k <=16; k++)
				scramble[k] = false;
				rnd = new Random();
				
				for (int r = 0; r <= 5; r++)
				for (int c = 0; c <= 5; c++)
				matrix[r][c] = "#";
				
				for (int r = 1; r <= 4; r++)
				for (int c = 1; c <= 4; c++)
				{
					matrix[r][c] = getLetter();
					if (matrix[r][c].equals("P"))
					{
						blankR = r;
						blankC = c;
					}
				}
				setVisible(true);

			}



			else if(num ==3)
			{

				for (int k = 1; k <=9; k++)
						scramble[k] = false;
				rnd = new Random();
				
				for (int r = 0; r <= 4; r++)
					for (int c = 0; c <= 4; c++)
						matrix[r][c] = "#";
				
				for (int r = 1; r <= 3; r++)
					for (int c = 1; c <= 3; c++)
						{
							matrix[r][c] = getLetter();
							if (matrix[r][c].equals("I"))
							{
								blankR = r;
								blankC = c;
							}
						}
				setVisible(true);
			}


			else if(num ==5)
			{

				for (int k = 1; k <=25; k++)
					scramble[k] = false;
				rnd = new Random();

				for (int r = 0; r <= 6; r++)
					for (int c = 0; c <= 6; c++)
						matrix[r][c] = "#";

				for (int r = 1; r <= 5; r++)
					for (int c = 1; c <= 5; c++)
					{
						matrix[r][c] = getLetter();
						if (matrix[r][c].equals("Y"))
						{
							blankR = r;
							blankC = c;
						}
					}
					setVisible(true);
				}
			}



			public String getLetter()
			{
				String letter = "";
				boolean Done = false;
				if( num==4)
				{
					while(!Done)
					{
						int rndNum = rnd.nextInt(16) + 1;
						if (scramble[rndNum] == false)
						{
							letter = String.valueOf((char) (rndNum+64));
							scramble[rndNum] = true;
							Done = true;
						}
					}

				}



				else if(num ==3)
				{
					while(!Done)
					{
						int rndNum = rnd.nextInt(9) + 1;
						if (scramble[rndNum] == false)
						{
							letter = String.valueOf((char) (rndNum+64));
							scramble[rndNum] = true;
							Done = true;
						}
					}

				}


				else if(num==5)
				{
					while(!Done)
					{
						int rndNum = rnd.nextInt(25) + 1;
						if (scramble[rndNum] == false)
						{
							letter = String.valueOf((char) (rndNum+64));
							scramble[rndNum] = true;
							Done = true;
						}
					}

				}
				return letter;
			}


			public void paintComponent(Graphics g)
			{
   				drawGrid(g);
				drawLetter(g,matrix[1][1],100/sizer,100/sizer);
				drawLetter(g,matrix[1][2],300/sizer,100/sizer);
				drawLetter(g,matrix[1][3],500/sizer,100/sizer);
				if( num==4)
					drawLetter(g,matrix[1][4],700/sizer,100/sizer);
				if(num==5)
				{
					drawLetter(g,matrix[1][4],700/sizer,100/sizer);
					drawLetter(g,matrix[1][5],900/sizer,100/sizer);
				}
				drawLetter(g,matrix[2][1],100/sizer,300/sizer);
				drawLetter(g,matrix[2][2],300/sizer,300/sizer);
				drawLetter(g,matrix[2][3],500/sizer,300/sizer);
				if( num==4)
					drawLetter(g,matrix[2][4],700/sizer,300/sizer);
				if(num==5)
				{
					drawLetter(g,matrix[2][4],700/sizer,300/sizer);
					drawLetter(g,matrix[2][5],900/sizer,300/sizer);
				}
				drawLetter(g,matrix[3][1],100/sizer,500/sizer);
				drawLetter(g,matrix[3][2],300/sizer,500/sizer);
				drawLetter(g,matrix[3][3],500/sizer,500/sizer);
				if( num==4)
					drawLetter(g,matrix[3][4],700/sizer,500/sizer);
				if(num==5)
				{
					drawLetter(g,matrix[3][4],700/sizer,500/sizer);
					drawLetter(g,matrix[3][5],900/sizer,500/sizer);
				}
				if( num==4)
				{

					drawLetter(g,matrix[4][1],100/sizer,700/sizer);
					drawLetter(g,matrix[4][2],300/sizer,700/sizer);
					drawLetter(g,matrix[4][3],500/sizer,700/sizer);
					drawLetter(g,matrix[4][4],700/sizer,700/sizer);
					if(num==5)
					drawLetter(g,matrix[4][5],900/sizer,700/sizer);
					
				}
				if( num==5)
				{
					drawLetter(g,matrix[4][1],100/sizer,700/sizer);
					drawLetter(g,matrix[4][2],300/sizer,700/sizer);
					drawLetter(g,matrix[4][3],500/sizer,700/sizer);
					drawLetter(g,matrix[4][4],700/sizer,700/sizer);
					drawLetter(g,matrix[4][5],900/sizer,700/sizer);
					
					drawLetter(g,matrix[5][1],100/sizer,900/sizer);
					drawLetter(g,matrix[5][2],300/sizer,900/sizer);
					drawLetter(g,matrix[5][3],500/sizer,900/sizer);
					drawLetter(g,matrix[5][4],700/sizer,900/sizer);
					drawLetter(g,matrix[5][5],900/sizer,900/sizer);
					
				}
			}

			public void drawGrid(Graphics g)
			{
				if(num==4)
				{

					g.drawRect(100/sizer,100/sizer,800/sizer,800/sizer);
					
					g.drawLine(300/sizer,100/sizer,300/sizer,900/sizer);
					
					g.drawLine(500/sizer,100/sizer,500/sizer,900/sizer);
					
					g.drawLine(100/sizer,300/sizer,900/sizer,300/sizer);
					
					g.drawLine(100/sizer,500/sizer,900/sizer,500/sizer);
					
					
					g.drawLine(700/sizer,100/sizer,700/sizer,900/sizer);
					g.drawLine(100/sizer,700/sizer,900/sizer,700/sizer);
				}

				if(num==3)
				{
					g.drawRect(100/sizer,100/sizer,600/sizer,600/sizer);
					g.drawLine(300/sizer,100/sizer,300/sizer,700/sizer);
					g.drawLine(500/sizer,100/sizer,500/sizer,700/sizer);
					g.drawLine(100/sizer,300/sizer,700/sizer,300/sizer);
					g.drawLine(100/sizer,500/sizer,700/sizer,500/sizer);
					
				}
				if(num==5)
				{

					g.drawRect(100/sizer,100/sizer,1000/sizer,1000/sizer);
					
					g.drawLine(300/sizer,100/sizer,300/sizer,1100/sizer);
					
					g.drawLine(500/sizer,100/sizer,500/sizer,1100/sizer);
					g.drawLine(700/sizer,100/sizer,700/sizer,1100/sizer);
					g.drawLine(900/sizer,100/sizer,900/sizer,1100/sizer);
					
					g.drawLine(100/sizer,300/sizer,1100/sizer,300/sizer);
					
					g.drawLine(100/sizer,500/sizer,1100/sizer,500/sizer);
					g.drawLine(100/sizer,700/sizer,1100/sizer,700/sizer);
					g.drawLine(100/sizer,900/sizer,1100/sizer,900/sizer);
					
					
					
				}





			}


			public void drawLetter(Graphics g, String letter, int x, int y)
			{
				int offSetX = x + 30/sizer;
				int offSetY = y + 175/sizer;
				g.setFont(new Font("Arial",Font.BOLD,200/sizer));
				if (num==4)
				{

					if (letter.equals("P"))
					{
						g.setColor(Color.white);
						g.fillRect(x+1,y+1,198/sizer,198/sizer);
					}
					else
					{
						g.setColor(Color.black);
						g.drawString(letter,offSetX,offSetY);
					}
				}
				else if(num==3)
				{

					if (letter.equals("I"))
					{
						g.setColor(Color.white);
						g.fillRect(x+1,y+1,198/sizer,198/sizer);
					}
					else
					{
						g.setColor(Color.black);
						g.drawString(letter,offSetX,offSetY);
					}
				}	

				else if(num==5)
				{

					if (letter.equals("Y"))
					{
						g.setColor(Color.white);
						g.fillRect(x+1,y+1,198/sizer,198/sizer);
					}
					else
					{
						g.setColor(Color.black);
						g.drawString(letter,offSetX,offSetY);
					}
				}
			}


			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseExited(MouseEvent e){}
			
			public void mouseClicked(MouseEvent e)
			{
				int x = e.getX();
				int y = e.getY();
				if(num==4)
				{

					if(r11.inside(x,y) && okSquare(1,1))
						swap(1,1);
					else if(r12.inside(x,y) && okSquare(1,2))
						swap(1,2);
					else if(r13.inside(x,y) && okSquare(1,3))
						swap(1,3);
					else if(r14.inside(x,y) && okSquare(1,4))
						swap(1,4);
					else if(r21.inside(x,y) && okSquare(2,1))
						swap(2,1);
					else if(r22.inside(x,y) && okSquare(2,2))
						swap(2,2);
					else if(r23.inside(x,y) && okSquare(2,3))
						swap(2,3);
					else if(r24.inside(x,y) && okSquare(2,4))
						swap(2,4);
					else if(r31.inside(x,y) && okSquare(3,1))
						swap(3,1);
					else if(r32.inside(x,y) && okSquare(3,2))
						swap(3,2);
					else if(r33.inside(x,y) && okSquare(3,3))
						swap(3,3);
					else if(r34.inside(x,y) && okSquare(3,4))
						swap(3,4);
					else if(r41.inside(x,y) && okSquare(4,1))
						swap(4,1);
					else if(r42.inside(x,y) && okSquare(4,2))
						swap(4,2);
					else if(r43.inside(x,y) && okSquare(4,3))
						swap(4,3);
					else if(r44.inside(x,y) && okSquare(4,4))
						swap(4,4);
				}
				if(num==3)
				{
					if(r11.inside(x,y) && okSquare(1,1))
						swap(1,1);
					else if(r12.inside(x,y) && okSquare(1,2))
						swap(1,2);
					else if(r13.inside(x,y) && okSquare(1,3))
						swap(1,3);
					else if(r21.inside(x,y) && okSquare(2,1))
						swap(2,1);
					else if(r22.inside(x,y) && okSquare(2,2))
						swap(2,2);
					else if(r23.inside(x,y) && okSquare(2,3))
						swap(2,3);
					else if(r31.inside(x,y) && okSquare(3,1))
						swap(3,1);
					else if(r32.inside(x,y) && okSquare(3,2))
						swap(3,2);
					else if(r33.inside(x,y) && okSquare(3,3))
						swap(3,3);


			}
	if(num==5)
	{
		
		if(r11.inside(x,y) && okSquare(1,1))
			swap(1,1);
		else if(r12.inside(x,y) && okSquare(1,2))
			swap(1,2);
		else if(r13.inside(x,y) && okSquare(1,3))
			swap(1,3);
		else if(r14.inside(x,y) && okSquare(1,4))
			swap(1,4);
		else if(r15.inside(x,y) && okSquare(1,5))
			swap(1,5);
		else if(r21.inside(x,y) && okSquare(2,1))
			swap(2,1);
		else if(r22.inside(x,y) && okSquare(2,2))
			swap(2,2);
		else if(r23.inside(x,y) && okSquare(2,3))
			swap(2,3);
		else if(r24.inside(x,y) && okSquare(2,4))
			swap(2,4);
		else if(r25.inside(x,y) && okSquare(2,5))
			swap(2,5);
		else if(r31.inside(x,y) && okSquare(3,1))
			swap(3,1);
		else if(r32.inside(x,y) && okSquare(3,2))
			swap(3,2);
		else if(r33.inside(x,y) && okSquare(3,3))
			swap(3,3);
		else if(r34.inside(x,y) && okSquare(3,4))
			swap(3,4);
		else if(r35.inside(x,y) && okSquare(3,5))
			swap(3,5);
		else if(r41.inside(x,y) && okSquare(4,1))
			swap(4,1);
		else if(r42.inside(x,y) && okSquare(4,2))
			swap(4,2);
		else if(r43.inside(x,y) && okSquare(4,3))
			swap(4,3);
		else if(r44.inside(x,y) && okSquare(4,4))
			swap(4,4);
		else if(r45.inside(x,y) && okSquare(4,5))
			swap(4,5);
		else if(r51.inside(x,y) && okSquare(5,1))
			swap(5,1);
		else if(r52.inside(x,y) && okSquare(5,2))
			swap(5,2);
		else if(r53.inside(x,y) && okSquare(5,3))
			swap(5,3);
		else if(r54.inside(x,y) && okSquare(5,4))
			swap(5,4);
		else if(r55.inside(x,y) && okSquare(5,5))
			swap(5,5);
	}

}


public boolean okSquare(int r, int c)
{
	boolean temp = false;
	if(num ==4)
	{


		if (matrix[r-1][c].equals("P"))
			temp = true;
		else if (matrix[r+1][c].equals("P"))
			temp = true;
		else if (matrix[r][c-1].equals("P"))
			temp = true;
		else if (matrix[r][c+1].equals("P"))
			temp = true;


	}
	else if(num==3)
	{


		if (matrix[r-1][c].equals("I"))
			temp = true;
		else if (matrix[r+1][c].equals("I"))
			temp = true;
		else if (matrix[r][c-1].equals("I"))
			temp = true;
		else if (matrix[r][c+1].equals("I"))
			temp = true;


	}
	else if(num ==5)
	{


		if (matrix[r-1][c].equals("Y"))
			temp = true;
		else if (matrix[r+1][c].equals("Y"))
			temp = true;
		else if (matrix[r][c-1].equals("Y"))
			temp = true;
		else if (matrix[r][c+1].equals("Y"))
			temp = true;


	}
	return temp;
}


public void swap(int r, int c)
{
	matrix[blankR][blankC] = matrix[r][c];
	if(num ==4)
		matrix[r][c] = "P";
	if(num==3)
		matrix[r][c] = "I";
	if(num==5)
		matrix[r][c] = "Y";
	blankR = r;
	blankC = c;
	repaint();
}


public void update(Graphics g)
{
	paint(g);
}
}

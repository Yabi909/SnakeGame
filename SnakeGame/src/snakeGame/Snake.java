package snakeGame;

import snakeGame.Menu;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Snake implements ActionListener, KeyListener, MouseListener
{

	public static Snake snake;
	public JFrame jframe;
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	public Renderer renderer;
	public Timer timer = new Timer(20, this);
	public ArrayList<Point> snakeParts = new ArrayList<Point>();
	public static final int SCALE = 10;
	public int ticks = 0, score, snakeLength = 10, time;
	public Point head, fruit;
	

	public Random random;
	
	private Menu menu;

	public boolean gameOver= false, paused;

	public Dimension dim;
	public boolean up = false;
	public boolean down = false;
	public boolean left = false;
	public boolean right = false;
	

	public Snake()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Snake");
		jframe.setVisible(true);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setResizable(false);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(renderer = new Renderer());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
		jframe.addMouseListener(this);
		init();
		
	}
	
	public static enum STATE{
		MENU,
		PLAY
		
		
	};
	
	public static STATE State = STATE.MENU;

	public void init()
	{
		time = 0;
		score = 0;
		ticks = 0;
		snakeLength = 1;
		gameOver= false;
		paused = false;
		
		random = new Random();
		head = new Point(10, 10);
		
		snakeParts.clear();
		fruit = new Point(50, 50);
		
		menu = new Menu();
		timer.start();
		
	}
	
	public boolean endPart(int x, int y)
	{
		for (Point point : snakeParts)
		{
			if (point.equals(new Point(x, y)))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		renderer.repaint();
		ticks++;
		

		if (ticks % 3 == 0 && State == STATE.PLAY && !gameOver&& !paused && head != null)
		{
			time++;
			snakeParts.add(new Point(head.x, head.y));

			if (up == true)
			{
				if (head.y - 1 >= 0 && endPart(head.x, head.y - 1))
				{
					head = new Point(head.x, head.y - 1);
				}
				else
				{
					gameOver= true;

				}
				
			}

			if (down == true)
			{
				if (head.y + 1 < 57 && endPart(head.x, head.y + 1))
				{
					head = new Point(head.x, head.y + 1);
				}
				else
				{
					gameOver= true;

				}
				
			}

			if (left == true)
			{
				if (head.x - 1 >= 0 && endPart(head.x - 1, head.y))
				{
					head = new Point(head.x - 1, head.y);
				}
				else
				{
					gameOver= true;

				}
				
				
			}

			if (right == true)
			{
				if (head.x + 1 < 80 && endPart(head.x + 1, head.y))
				{
					head = new Point(head.x + 1, head.y);
				}
				else
				{
					gameOver= true;

				}
				
			}

			if (snakeParts.size() > snakeLength)
			{
				snakeParts.remove(0);

			}

			if (fruit != null)
			{
				if (head.equals(fruit))
				{
					score += 10;
					snakeLength++;
					fruit.setLocation(random.nextInt(30), random.nextInt(30));
				}
			}
		}
	}



	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(State == STATE.PLAY){
			
			
		if (key == KeyEvent.VK_UP && down == false)
		{
			up = true;
			down = false;
			left = false;
			right = false;
		}

		if (key == KeyEvent.VK_DOWN && up == false)
		{
			up = false;
			down = true;
			left = false;
			right = false;
		}

		if (key == KeyEvent.VK_LEFT && right == false)
		{
			up = false;
			down = false;
			left = true;
			right = false;;
		}

		if (key == KeyEvent.VK_RIGHT && left == false)
		{
			right = true;
			down = false;
			left = false;
			up = false;
		}

		

		if (key == KeyEvent.VK_SPACE)
		{
			if (gameOver)
			{
				init();
			}else
				{
					paused = !paused;
				}
	     }
		if (key == KeyEvent.VK_ENTER && gameOver)
		{
			System.exit(1);
		}
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		int xCoor = e.getX();
		int yCoor = e.getY();
		if(State == STATE.MENU){
        if(xCoor>Snake.WIDTH/2 -50 && xCoor<Snake.WIDTH/2 +50){
			
			if(yCoor> 130 && yCoor< 230){
				Snake.State = Snake.STATE.PLAY;
				
				
			}
		}
        
        
        
        if(xCoor>=10 && xCoor<=110){
			
			if(yCoor> 520 && yCoor< 600){
				System.exit(1);
			}
		}
		
		}
		
	}
	
	
	public static void main(String[] args)
	{
		snake = new Snake();
		
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

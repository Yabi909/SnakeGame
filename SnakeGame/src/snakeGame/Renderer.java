package snakeGame;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import snakeGame.Menu;

import javax.swing.JPanel;

@SuppressWarnings("serial")
/**
 * @author Yabesera Dereje
 */
public class Renderer extends JPanel
{

	public static final Color GREEN = new Color(1666073);
	private Menu menu;
	private BufferedImage background = null;
	
	public Renderer(){
		menu = new Menu();
		
	}
	

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		

		Snake snake = Snake.snake;
		
       
		
		g.drawImage(background, 0, 0, null);
		
		if(Snake.State == Snake.STATE.MENU){
			
			BufferedImageLoader load = new BufferedImageLoader();
			try{
				background = load.loadimage("/snake.png");
			}catch(IOException e){
				e.printStackTrace();
			}

			  menu.Render(g);
			  
		  }
		
		if(Snake.State == Snake.STATE.PLAY){
			
		g.setColor(Color.BLACK);
				
		g.fillRect(0, 0, 800, 700);
		
		Color mycolor1 = new Color(4,255,29);
		g.setColor(mycolor1);


		for (Point point : snake.snakeParts)
		{
			g.fillRect(point.x * Snake.SCALE +1, point.y * Snake.SCALE +1, 10 -2 , 10 -2 );
		}
		
		g.fillRect(snake.head.x * Snake.SCALE +1, snake.head.y * Snake.SCALE +1, 10 -2, 10 -2);
		
		g.setColor(Color.RED);
		
		g.fillRect(snake.fruit.x * Snake.SCALE, snake.fruit.y * Snake.SCALE, 10, 10);
		
		String string = "Score: " + snake.score + ", Length: " + snake.snakeLength + ", Time: " + snake.time / 20;
		
		g.setColor(Color.white);
		
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);

		string = "Game Over!";

		if (snake.gameOver)
		{
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", 1, 50));
			g.drawString("GAME OVER!", 250, 250);
			g.setFont(new Font("Arial", 1, 10));
			g.drawString("PRESS ENTER TO QUIT", 340, 270);
		}

		string = "Paused!";

		if (snake.paused && !snake.gameOver)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
		}

	}
	}
}


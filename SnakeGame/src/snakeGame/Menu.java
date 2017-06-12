package snakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playbutton = new Rectangle(Snake.WIDTH/2 -50, 150, 100, 50);
	
	public Rectangle quitbutton = new Rectangle(10, Snake.HEIGHT-90 , 100, 50);
	
	public void Render(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("Apple LiGothic",Font.BOLD, 50);
		g.setFont(fnt0);
		Color mycolor1 = new Color(4,255,29);
		g.setColor(mycolor1);
		
		
		Font fnt1 = new Font("Microsoft Sans Serif",Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playbutton.x+19, playbutton.y+30);
		g2d.draw(playbutton);
		
		Font fnt3 = new Font("Microsoft Sans Serif",Font.BOLD, 20);
		g.setFont(fnt3);
		
		g.setColor(mycolor1);
		g.drawString("Quit", quitbutton.x+19, quitbutton.y+30);
		g2d.draw(quitbutton);
		
	}

}

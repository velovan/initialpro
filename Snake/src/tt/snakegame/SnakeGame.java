package tt.snakegame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import tt.snakegame.obj.Apple;
import tt.snakegame.obj.Snake;

public class SnakeGame extends JPanel implements ActionListener{
	
	public static final int SCALE =30;
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	public static double SPEED = 0.7;
	
	Apple apple = new Apple((int) (Math.random()* WIDTH), (int)(Math.random()*HEIGHT));
	Snake s = new Snake(0,0, 15,10);
	Timer t = new Timer ((int) (100/SPEED), this);
	
	public SnakeGame(){
		t.start();
		addKeyListener(new keyAdapter());
		setFocusable(true);
	}
	
	public Color color (int red, int green, int blue){
    	return new Color (red, green, blue);
    }
	
	public void paint(Graphics g){
		
         g.setColor( color(5,50,10));
         g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
         g.setColor(color(255,216,0));
		
         for(int xx = 0; xx <= WIDTH*SCALE; xx+=SCALE){
        	 g.drawLine(xx, 0, xx, HEIGHT*SCALE);
         }
              
         for(int yy = 0; yy <= HEIGHT*SCALE; yy+=SCALE){
        	 g.drawLine(0, yy, WIDTH*SCALE,yy);
         }
                           
         for(int d = 0; d < s.lenght; d++){
        	 g.setColor(color(20,30,150));
        	 g.fillRect(s.snakeX[d]*SCALE+1,s.snakeY[d]*SCALE+1 , SCALE-1, SCALE-1);
         }
         
         for(int d = 0; d < s.lenght; d++){
        	 g.setColor(color(2,90,10));
        	 g.fillRect(s.snakeX[0]*SCALE+1,s.snakeY[0]*SCALE+1 , SCALE-1, SCALE-1);
         }
             
         g.setColor(color(200,10,0));
         g.fillRect(apple.posX* SCALE+1, apple.posY* SCALE+1, SCALE-1, SCALE-1);
         
 		g.drawString(" �������:" + s.lenght +"  (min. = 50 )", 1, 10);
	}
	

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Snake");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setSize(WIDTH * SCALE+7, HEIGHT * SCALE+29);
		f.setLocationRelativeTo(null);
		f.add(new SnakeGame());
	    f.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent arg0) {
        s.move();
        if((s.snakeX[0] == apple.posX) & (s.snakeY[0] == apple.posY)){
             apple.setRandomPosition();
             s.lenght++;
             if(s.lenght == 50){
                      JOptionPane.showMessageDialog(null, "�� �������");
                 }
             System.out.println(s.lenght);
         }
        
        for(int k = 1;k < s.lenght; k++){
        if((s.snakeX[k] == apple.posX) & (s.snakeY[k] == apple.posY)){
            apple.setRandomPosition();
        }
     }
	repaint();
	}
	
	
	private class keyAdapter extends KeyAdapter{
		
	     public void keyPressed(KeyEvent e){
		 int key = e.getKeyCode();
			
		 if((key ==  KeyEvent.VK_RIGHT) &  s.direction != 2) s.direction = 0;
		 if((key ==  KeyEvent.VK_DOWN)  &  s.direction != 3) s.direction = 1;
		 if((key ==  KeyEvent.VK_LEFT)  &  s.direction != 0) s.direction = 2;
		 if((key ==  KeyEvent.VK_UP)    &  s.direction != 1) s.direction = 3;
		}
	}
	
}

package tt.snakegame.obj;

import tt.snakegame.SnakeGame;

public class Apple{
 
	public int posX;
	public int posY;
	SnakeGame main;
	
	public Apple(int stX, int stY){
	  posX = stX;
	  posY = stY;
	}
	
	public void setRandomPosition(){
	  posX = (int) (Math.random() *main.WIDTH );
	  posY = (int) (Math.random() * main.HEIGHT);
	}
	
}

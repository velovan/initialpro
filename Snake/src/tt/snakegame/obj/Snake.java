package tt.snakegame.obj;

import javax.swing.JOptionPane;

import tt.snakegame.SnakeGame;

public class Snake {
	
	    public int direction = 1;
		public int lenght = 1;
		public int snakeX[] = new int[1000];
		public int snakeY[] = new int[1000];		
		SnakeGame sn;
		
		public Snake (int x0 ,int y0, int x1, int y1){
		  snakeX[0] = x0;
		  snakeY[0] = y0;
		  snakeX[1] = x1;
		  snakeY[1] = y1;
		}
		
		public void move(){
			 for(int d = lenght; d > 0; d--) {
				  snakeX[d] = snakeX[d-1];
				  snakeY[d] = snakeY[d-1];
				}
				
				if(direction == 0)snakeX[0]++;		
				if(direction == 1)snakeY[0]++;
				if(direction == 2)snakeX[0]--;
				if(direction == 3)snakeY[0]--;
				
				for(int d = lenght-1; d>0; d--){
					if(snakeX[0] == snakeX[d] & snakeY[0] == snakeY[d]){
					   JOptionPane.showMessageDialog(null,  "Snake" );
					   lenght = d-1;
					}				
				}
			
			
			if(snakeX[0] > sn.WIDTH){
				snakeX[0] = 0;
			}
			if(snakeX[0] < 0){
				snakeX[0] = sn.WIDTH-1;
			}
			if(snakeY[0] > sn.HEIGHT-1){
				snakeY[0] = 0;
			}
			if(snakeY[0] < 0){
				snakeY[0] = sn.HEIGHT-1;
			}	
			if(lenght < 1){
				lenght = 1;
			}	
		}
	
}




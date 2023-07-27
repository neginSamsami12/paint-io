
import java.util.Timer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Weapon {
    
    int X;
    int Y;
    
    int xx;
    int yy;

    boolean redkill;
    boolean greenkill;

public void shoot(int CHECKER_SIZE,double x, double y, Pane pane, int bluedirct, double redx, double redy, double greenx , double greeny) {
// Create new blue rectangle 5 squares away
//int X = (int) (x / CHECKER_SIZE) + 5;
//int Y = (int) (y / CHECKER_SIZE);

for(int i = 0; i < 9; i++){
    for(int j = 0; j < 9; j++){
        if(bluedirct == 4){
     X = (int) (x / CHECKER_SIZE) + 5 +i;
     Y = (int) (y / CHECKER_SIZE)+j;
        
        }
        else if(bluedirct == 2){
        
        X = (int) (x / CHECKER_SIZE) - 5 -i;
        Y = (int) (y / CHECKER_SIZE)-j;
        
        }
         xx = X * CHECKER_SIZE;
         yy = Y * CHECKER_SIZE;
         

 Rectangle rect = new Rectangle(CHECKER_SIZE, CHECKER_SIZE, Color.BLUE);
 rect.setX(xx);
 rect.setY(yy);

 pane.getChildren().add(rect);
 
             if(xx == redx && yy == redy){
       
        
        redkill = true;
        
        }
        if(xx == greenx && yy == greeny){
        
        
        greenkill = true;
        
        
        }
    }
    

}
}

}




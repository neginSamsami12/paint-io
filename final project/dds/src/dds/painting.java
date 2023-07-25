
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class painting {
    int redcolorX;
    int redcolorY;
    Pane pane_l;
    Rectangle redrectToColor;
    
    public painting(Pane pane){

        pane_l = pane;

}
    
    public void paint_node(double redRectX, double redRectY, int CHECKER_SIZE,int num_of_players, boolean redlost, String color){
        redrectToColor = new Rectangle(CHECKER_SIZE, CHECKER_SIZE); 
        redcolorX = (int) (redRectX / CHECKER_SIZE) * CHECKER_SIZE;
        redcolorY = (int) (redRectY / CHECKER_SIZE) * CHECKER_SIZE;
        redrectToColor.setLayoutX(redcolorX);
        redrectToColor.setLayoutY(redcolorY);
        if(color == "red"){
        redrectToColor.setFill(Color.RED.deriveColor(0, 1, 1, 0.9));
        }
        if(color == "green"){
        redrectToColor.setFill(Color.RED.deriveColor(0, 1, 1, 0.9));
        }

            }
    
    
    void getchill(){
    
    pane_l.getChildren().add(redrectToColor);
    }
    
    
}

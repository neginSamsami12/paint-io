
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Move_Images {
    
    Pane pane_l;
    int num;
    String path;
    private ImageView rect;

    
    public Move_Images(Pane pane, int num_of_players, String Path){
    
    
    pane_l = pane;
    num = num_of_players;
    path = Path;
    
    }
    public void create_image(){
    
        Image image = new Image(path); // Replace with your image path
        rect = new ImageView(image);
        rect.setFitWidth(50);
        rect.setFitHeight(50);
        
          
          
    }
    
    public void getchil(){
             pane_l.getChildren().add(rect);
    }
  
    
    
    public void get_killed(boolean bool){
    
    if (!bool){
        
    pane_l.getChildren().remove(rect);
    
    }
    
    }
    
    public void set_layout(double rectX, double rectY){
        
         rect.setLayoutX(rectX);
         rect.setLayoutY(rectY);
       
    }
    
    public ImageView get_ret(){
    return rect;
    }
    
    
}

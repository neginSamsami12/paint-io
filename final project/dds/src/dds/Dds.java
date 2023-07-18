
package dds;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Background;

import javafx.scene.control.ScrollPane;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;



public class Dds extends Application {
    int count = 0;
    int startx;
    int starty;
    
    final double speeds =5;
    double dx1 =0;
    double dy1=0;
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final int CHECKER_SIZE = 50;
    
    private Pane pane;
    private Rectangle rect;
    
    
    private double x = WIDTH / 2;
    private double y = HEIGHT / 2;
    private double dx = 0;
    private double dy = 0;
    private double speed = 5;
    
    private Color[][] colorMatrix;
    
    double randomdx ;
    double randomdy;
    
    
    
    double redRectX = Math.random() * WIDTH;
    double redRectY = Math.random() * HEIGHT;
    double redRectDx = Math.random() * speeds - speeds / 2;
    double redRectDy = Math.random() * speeds - speeds / 2;
          
    
     
    
    
    public int kl;
    @Override
    public void start(Stage primaryStage) {
       
       
        
           // create a menu
        Menu m = new Menu("file");
  
        // create menuitems
        MenuItem m1 = new MenuItem("game over");
        MenuItem m2 =new MenuItem("show scor");
        
        m.getItems().add(m1);
        m.getItems().add(m2);
        MenuBar mb = new MenuBar();
        mb.getMenus().add(m);
        VBox menubox =new VBox(mb);
  
       
  
        
      

        BackgroundFill white =new BackgroundFill(Color.WHITE,null,null);
        BackgroundFill black =new BackgroundFill(Color.BLACK,null,null);
        pane = new Pane();
        
          
        pane.setPrefSize(2000, 2000);
        pane.setBackground(new Background(new BackgroundFill[]{black,white}[0]));
        
        for(int i =0;i <10000 /CHECKER_SIZE;i++){
            for(int j =0;j<10000/CHECKER_SIZE;j++){
                Rectangle rect =new Rectangle(CHECKER_SIZE,CHECKER_SIZE,((i+j)%2==0) ? black.getFill() :white.getFill());
                
                rect.setX(i * CHECKER_SIZE);
                rect.setY(j * CHECKER_SIZE);
                
                
               
                pane.getChildren().add(rect);
                
                
                if(rect.getFill().equals(Color.BLUE)){
                    kl++;
                }
                  
            }
        }
        
              
             
              m2.setOnAction(event -> {
    
             System.out.println("blue colored: "+ kl);
                });
       
        
        
        ScrollPane scrollPane = new ScrollPane(pane);
        scrollPane.setPrefWidth (300); // set the preferred width
        scrollPane.setPrefHeight (200); // set the preferred height
        scrollPane.setLayoutX (50); // set the layout x position
        scrollPane.setLayoutY (60);
       
        
        m1.setOnAction(event ->{
            pane.getChildren().clear();
            
            
        });
        
        Scene scenee =new Scene(pane,WIDTH,HEIGHT);
        scenee.setRoot(new StackPane(scrollPane,menubox));
        primaryStage.setScene(scenee);
        //primaryStage.setScene(new Scene(scrollPane, WIDTH, HEIGHT));
        
        primaryStage.show();
        
        
        
        
        rect = new Rectangle(0, 0, 50, 50);
        rect.setFill(Color.BROWN.deriveColor(3, 1, 1, 0.9));
        pane.getChildren().add(rect);
        
        
        
        
       
        
        primaryStage.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    dy = -speed;
                    break;
                case A:
                    dx = -speed;
                    break;
                case S:
                    dy = speed;
                    break;
                case D:
                    dx = speed;
                    break;
            }
        });
         
         
          primaryStage.getScene().setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case W:
                case S:
                    dy = 0;
                    break;
                case A:
                case D:
                    dx = 0;
                    break;
            }
        });
          
          
          
        
          
          
          
          
         
          
          final int rows =8;
          final int cols =8;
          final double chkr_size =50;
          
          for(int i=0;i <rows;i++){
              for(int j=0;j <cols;j++){
                  Rectangle recdt =new Rectangle(chkr_size,chkr_size);
                  double xi =i *chkr_size;
                  double yj =j * chkr_size;
                  recdt.setLayoutX(xi);
                  recdt.setLayoutY(yj);
                  recdt.setFill(((i+j)%2==0)?Color.WHITE:Color.BLACK);
                  
                  
                  
                  
                  
                  
                  pane.getChildren().add(recdt);
              }
          }
          Rectangle redRect = new Rectangle(50, 50);
          redRect.setFill(Color.RED.deriveColor(0, 1, 1, 0.9));
          pane.getChildren().add(redRect);
          
          double redRectx =Math.random() * (WIDTH - redRect.getWidth());
          double redRecty =Math.random() * (HEIGHT -redRect.getHeight());
          double spe =3;
          
          
           for (int d = startx; d < startx + WIDTH; d++) {
                     for (int f = starty; f < starty + HEIGHT; f++) {
                           if (rect.contains(d, f)) {
                                count++;
                                         }
                                     }
                                  }
                 
              
                 
                
          

          ///------------------------------------------------------------------------------------------
          AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                
            double nextX = x + dx;
            double nextY = y + dy;
            int i = (int) (x / CHECKER_SIZE);
            int j = (int) (y / CHECKER_SIZE);
                
          //  System.out.println("ih"+count);
               
            rect.setFill(Color.BLUE.deriveColor(0, 1, 1, 0.9));
            
          
            double xi = i * CHECKER_SIZE + (CHECKER_SIZE - rect.getWidth()) / 2;
            double yj = j * CHECKER_SIZE + (CHECKER_SIZE - rect.getHeight()) / 2;
            rect.setLayoutX(xi);
            rect.setLayoutY(yj);
            x = nextX;
            y = nextY;
               
                
            Rectangle rect1 =new Rectangle(CHECKER_SIZE,CHECKER_SIZE,((i+j)%2==0) ? black.getFill() :white.getFill());
            rect1.setFill(Color.BLUE.deriveColor(0, 1, 1, 0.9));
            rect1.setLayoutX(xi);
            rect1.setLayoutY(yj);
            pane.getChildren().add(rect1);
                
             
                
                
                
                  
          
                  
         
          
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                redRectX += redRectDx;
                redRectY += redRectDy;
                 if (redRectX < 0 || redRectX > WIDTH - redRect.getWidth()) {
                     redRectDx += -1;
                   }
                 
                 if (redRectY < 0 || redRectY > HEIGHT - redRect.getHeight()) {
                        redRectDy *= -1;
                   }
                 redRect.setLayoutX(redRectX);
                 redRect.setLayoutY(redRectY);
                 
                 for(Node node :pane.getChildren()){
                     if(node instanceof Rectangle){
                         Rectangle rect =(Rectangle)node;
                         if(redRect.getBoundsInParent().intersects(rect.getBoundsInParent())){
                             rect.setFill(Color.RED.deriveColor(0, 1, 1,0.9));
                         }
                       
                         
                         if (redRect.getBoundsInParent().intersects(rect1.getBoundsInParent())) {
                               System.exit(1);
                               }
                         
                     }
                 
                 }
                    
            }
        };
        timer.start();
      
    
    }
    
    
    

   
    public static void main(String[] args) {
        launch(args);
    }
    
}

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


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
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.A;
import static javafx.scene.input.KeyCode.D;
import static javafx.scene.input.KeyCode.S;
import static javafx.scene.input.KeyCode.W;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;



public class test extends Application {

    
    int num_of_players = 2;
    Rectangle rect1;
    final double speeds = 2; //show how fast enemies will move(speed of the game)

    private static final int WIDTH = 1000;  //طول زمین بازی
    private static final int HEIGHT = 600; //عرض زمین بازی
    private static final int CHECKER_SIZE = 50; //میتوان زمین را بزرگتر کرد یعنی هرچی این عدد کمتر زمین بزرگتر و تعداد خانه ها ریز تر میشود
    
    private Pane pane;
    private Rectangle rect;
    
    
    private double x = WIDTH / 2;
    private double y = HEIGHT / 2;
    private double dx = 0; //مکان اولیه ابی
    private double dy = 0;//مکان اولیه ابی
    private double speed = 5; //سرعت کاراکتراصلی 
    
   
    
    
    
    double redRectX = Math.random() * WIDTH;//مکان اولیه کاراکتر قرمز
    double redRectY = Math.random() * HEIGHT;//مکان اولیه کاراکتر قرمز
    double redRectDx = 0;
    double redRectDy = 0;
    
    int directionChangeTimer = 119;
    
    boolean redlost = true;
    boolean greenlost = true;
    boolean bluelost = true;
    
    int redshot = 0;
    int greenshot = 0;
    int blueshot = 0;

    
    
    double greenRectX = Math.random() * WIDTH; //مکان اولیه کاراکتر سبز
    double greenRectY = Math.random() * HEIGHT; //مکان اولیه کاراکتر سبز
    double greenRectDx = 0;
    double greenRectDy = 0;
          
    
     
    
    
    public int kl;
    @Override
    public void start(Stage primaryStage) {
       
       
        
           // create a menu
        Menu m = new Menu("file");
  
        // create menuitems
        MenuItem m1 = new MenuItem("quit the game");
        MenuItem m2 =new MenuItem("show score");
        
        m.getItems().add(m1);
        m.getItems().add(m2);
        MenuBar mb = new MenuBar();
        mb.getMenus().add(m);
        VBox menubox =new VBox(mb);
  
       
  
        
      

        BackgroundFill white = new BackgroundFill(Color.WHITE,null,null);
        BackgroundFill black = new BackgroundFill(Color.BLACK,null,null);
        pane = new Pane();
        
          
        pane.setPrefSize(2000, 2000);
        pane.setBackground(new Background(new BackgroundFill[]{black,white}[0]));
        
        for(int i =0;i <10000 /CHECKER_SIZE;i++){
            for(int j =0;j<10000/CHECKER_SIZE;j++){
                Rectangle rect =new Rectangle(CHECKER_SIZE,CHECKER_SIZE,((i+j)%2==0) ? black.getFill() :white.getFill());
                
                rect.setX(i * CHECKER_SIZE);
                rect.setY(j * CHECKER_SIZE);
                
                
               
                pane.getChildren().add(rect);
                
                
                if(rect.getFill().equals(Color.BLUE.deriveColor(0, 1, 1, 0.9))){
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
            System.exit(1);
            
            
        });
        
        Scene scenee =new Scene(pane,WIDTH,HEIGHT);
        scenee.setRoot(new StackPane(scrollPane,menubox));
        primaryStage.setScene(scenee);
        //primaryStage.setScene(new Scene(scrollPane, WIDTH, HEIGHT));
        
        primaryStage.show();
        
        
        
        
        rect = new Rectangle(0, 0, 50, 50);
        rect.setFill(Color.BROWN.deriveColor(3, 1, 1, 0.9));
        pane.getChildren().add(rect);
        
        
        
        
       
        

          

          final int rows = 8;
          final int cols = 8;
          final double chkr_size =50;
          
          for(int i=0;i < rows;i++){
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
          
          

          Image image = new Image("file:C:\\Users\\SibCo\\Desktop\\87de8500-08d0-4f53-952c-df69c72b78f8.png"); // Replace with your image path
            ImageView redRect = new ImageView(image);
            redRect.setFitWidth(50);
            redRect.setFitHeight(50);
          if (num_of_players >= 1){
          pane.getChildren().add(redRect);
          }
          
          
          
            Image image_2 = new Image("file:C:\\Users\\SibCo\\Desktop\\sonic-the-hedgehog-movie.jpg"); // Replace with your image path
            ImageView greenRect = new ImageView(image_2);
            greenRect.setFitWidth(50);
            greenRect.setFitHeight(50);
            if(num_of_players >= 2){
            pane.getChildren().add(greenRect);
          }
          
          

          ///------------------------------------------------------------------------------------------
          AnimationTimer timer = new AnimationTimer() {
            @Override
public void handle(long now) {
    
        
        directionChangeTimer++;
        blueshot += 1;
        greenshot += 1;
        redshot += 1;
    if (directionChangeTimer % 120 == 0) {  // Every 3 seconds (120 ticks at 120 FPS)
      directionChangeTimer = 0;
      changeRedRectDirection();
      changegreenRectDirection();
    }   
    
    

    double nextX = x + dx;
    double nextY = y + dy;
    

            
    int i = (int) (x / CHECKER_SIZE);
    int j = (int) (y / CHECKER_SIZE);

    rect.setFill(Color.BLUE.deriveColor(0, 1, 1, 0.9));

    double xi = i * CHECKER_SIZE + (CHECKER_SIZE - rect.getWidth()) / 2;
    double yj = j * CHECKER_SIZE + (CHECKER_SIZE - rect.getHeight()) / 2;


if(bluelost){
    rect.setLayoutX(xi);
    rect.setLayoutY(yj);}
    x = nextX;
    y = nextY;


    if(bluelost){
    rect1 =new Rectangle(CHECKER_SIZE,CHECKER_SIZE,((i+j)%2==0) ? black.getFill() :white.getFill());
    
    rect1.setFill(Color.BLUE.deriveColor(0, 1, 1, 0.9));
    rect1.setLayoutX(xi);
    rect1.setLayoutY(yj);
    pane.getChildren().add(rect1);
}
    

    
        primaryStage.getScene().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W) {
                
                    dy = -speed;
            }
                if (event.getCode() == KeyCode.A){
                    dx = -speed;}
                if (event.getCode() == KeyCode.S){
                    dy = speed;
        }
                if (event.getCode() == KeyCode.D){
                    dx = speed;
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
            redRectX += redRectDx;
            redRectY += redRectDy;
    if (redRectX < 0) {
        redRectX = 0;
        redRectDx = -redRectDx;
    }
    if (redRectX + 50 > WIDTH) {
        redRectX = WIDTH - 50;
        redRectDx = -redRectDx;
    }
    if (redRectY < 0) {
        redRectY = 0;
        redRectDy = -redRectDy;
    }
    if (redRectY + 50 > HEIGHT) {
        redRectY = HEIGHT - 50;
        redRectDy = -redRectDy;
    }

    redRect.setLayoutX(redRectX); //مربوط به حرکت عکس میباشد
    redRect.setLayoutY(redRectY); //مربوط به حرکت عکس میباشد
    
    
    
            greenRectX += greenRectDx;
            greenRectY += greenRectDy;

            // Check for collisions with walls
            if (greenRectX < 0) {
                greenRectX = 0;
                greenRectDx = -greenRectDx;
            }

            if (greenRectY < 0) {
                greenRectY = 0;
                greenRectDy = -greenRectDy;
            }
            
            if (greenRectY + 50 > HEIGHT) {
                greenRectY = HEIGHT - 50;
                greenRectDy = -greenRectDy;
            }
            if (greenRectX + 50 > WIDTH) {
                greenRectX = WIDTH - 50;
                greenRectDx = -greenRectDx;
            }



    greenRect.setLayoutX(greenRectX); //مربوط به حرکت عکس میباشد
    greenRect.setLayoutY(greenRectY); //مربوط به حرکت عکس میباشد
    
    
    Rectangle redrectToColor = new Rectangle(CHECKER_SIZE, CHECKER_SIZE); 
int redcolorX = (int) (redRectX / CHECKER_SIZE) * CHECKER_SIZE;
int redcolorY = (int) (redRectY / CHECKER_SIZE) * CHECKER_SIZE;
redrectToColor.setLayoutX(redcolorX);
redrectToColor.setLayoutY(redcolorY);
redrectToColor.setFill(Color.RED.deriveColor(0, 1, 1, 0.9));
if (num_of_players >= 1 && redlost){
pane.getChildren().add(redrectToColor);
}



Rectangle greenrectToColor = new Rectangle(CHECKER_SIZE, CHECKER_SIZE); 
int colorgreenX = (int) (greenRectX / CHECKER_SIZE) * CHECKER_SIZE;
int colorgreenY = (int) (greenRectY / CHECKER_SIZE) * CHECKER_SIZE;
greenrectToColor.setLayoutX(colorgreenX);
greenrectToColor.setLayoutY(colorgreenY);
greenrectToColor.setFill(Color.GREEN.deriveColor(0, 1, 1, 0.9));
if(num_of_players > 1 && greenlost){
pane.getChildren().add(greenrectToColor);
}

if (redcolorX == colorgreenX ||redcolorY == colorgreenY ){

pane.getScene().setOnKeyPressed(event -> {
    if (event.getCode() == KeyCode.R && greenshot >= 120) {
        greenshot = 0;
        redlost = false;
        pane.getChildren().remove(redRect);
        
    }
    if (event.getCode() == KeyCode.G && redshot >= 120) {
        redshot = 0;
        greenlost = false;
        pane.getChildren().remove(greenRect);
    }
});

}
 

if (xi == colorgreenX || yj == colorgreenY ){

pane.getScene().setOnKeyPressed(event -> {
    if (event.getCode() == KeyCode.SPACE  && greenshot >= 120) {
        greenshot = 0;
        bluelost = false;
        pane.getChildren().remove(rect1);
        
    }
    if (event.getCode() == KeyCode.G && blueshot >= 120) {
        blueshot = 0;
        greenlost = false;
        pane.getChildren().remove(greenRect);
    }
});

}


if (redcolorX == xi ||redcolorY == yj   ){

pane.getScene().setOnKeyPressed(event -> {
    if (event.getCode() == KeyCode.R && blueshot >= 120) {
        blueshot = 0;
        redlost = false;
        pane.getChildren().remove(redRect);
        
    }
    if (event.getCode() == KeyCode.SPACE && redshot >= 120) {
        redshot = 0;
        bluelost = false;
        pane.getChildren().remove(rect1);
    }
});

}

    for(Node node :pane.getChildren()){
        if(node instanceof Rectangle){
            Rectangle rect =(Rectangle)node;
            
            
            if(num_of_players >= 1 && redlost && bluelost){
            if (redRect.getBoundsInParent().intersects(rect1.getBoundsInParent())) {
                System.exit(1);
            }}
            
            if(num_of_players >= 2 && greenlost && bluelost){
            if (greenRect.getBoundsInParent().intersects(rect1.getBoundsInParent())) {
                System.exit(1);
            }}
            
            if(num_of_players >= 2 && redlost && greenlost)            
            if (redRect.getBoundsInParent().intersects(greenRect.getBoundsInParent())) {
                System.exit(1);
            }            
        }
    }
}

    private void changeRedRectDirection() { //حرکت بعدی کاراکتر قرمز در این تابع مشخص میشود
                
        Random redrandom = new Random();    
        int redMoveDir = 0; // 0 = up, 1 = down, 2 = left, 3 = right
        redMoveDir = redrandom.nextInt(4); 
        
        switch(redMoveDir) {
         case 0: // Up
            redRectDy = -speeds;   
            redRectDx = 0;
            break;
         case 1: // Right      
            redRectDx = speeds;
            redRectDy = 0;
            break;                
         case 2: // Down        
            redRectDy = speeds;   
            redRectDx = 0;       
            break;
         case 3: // Left       
            redRectDx = -speeds;
            redRectDy = 0;   
      } 
            }
            
    private void changegreenRectDirection() { //حرکت بعدی کاراکتر سلز در این تابع مشخص میشود
                
        Random greenrandom = new Random();    
        int greenMoveDir = 0; // 0 = up, 1 = down, 2 = left, 3 = right
        greenMoveDir = greenrandom.nextInt(4); 
        
        switch(greenMoveDir) {
         case 0: // Up
            greenRectDy = -speeds;   
            greenRectDx = 0;
            break;
         case 1: // Right      
            greenRectDx = speeds;
            greenRectDy = 0;
            break;                
         case 2: // Down        
            greenRectDy = speeds;   
            greenRectDx = 0;       
            break;
         case 3: // Left       
            greenRectDx = -speeds;
            greenRectDy = 0;   
      } 
            }


        };
        timer.start();
      
    
    }
    
    
    

   
    public static void main(String[] args) {
        launch(args);
    }
    
}

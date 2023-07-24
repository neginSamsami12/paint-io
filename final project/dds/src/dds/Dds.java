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
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;



public class test extends Application {
    int count = 0;
    int startx;
    int starty;
    
    int num_of_players = 2;
    
    final double speeds = 2; //show how fast enemies will move(speed of the game)
    double dx1 = 0;
    double dy1 = 0;
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final int CHECKER_SIZE = 50;
    
    private Pane pane;
    private Rectangle rect;
    
    
    private double x = WIDTH / 2;
    private double y = HEIGHT / 2;
    private double dx = 0;
    private double dy = 0;
    private double speed = 5; //سرعت کاراکتراصلی 
    
    private Color[][] colorMatrix;
    
    double randomdx ;
    double randomdy;
    
    
    
    double redRectX = Math.random() * WIDTH;  //مکان اولیه کاراکتر قرمز
    double redRectY = Math.random() * HEIGHT;  //مکان اولیه کاراکتر قرمز
    double redRectDx = 0;
    double redRectDy = 0;
    
    int directionChangeTimer = 59;
    
    
    double greenRectX = Math.random() * WIDTH;  //مکان اولیه کاراکتر سبز
    double greenRectY = Math.random() * HEIGHT;  //مکان اولیه کاراکتر سبز
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
          double redRectx =Math.random() * (WIDTH - 50);
          double redRecty =Math.random() * (HEIGHT -50);
          
          
          
            Image image_2 = new Image("file:C:\\Users\\SibCo\\Desktop\\sonic-the-hedgehog-movie.jpg"); // Replace with your image path
            ImageView greenRect = new ImageView(image_2);
            greenRect.setFitWidth(50);
            greenRect.setFitHeight(50);
            if(num_of_players >= 2){
            pane.getChildren().add(greenRect);
          }
            double greenRectx =Math.random() * (WIDTH - 50);
            double greenRecty =Math.random() * (HEIGHT - 50);
          
          
          
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
    
        
        directionChangeTimer++;
    if (directionChangeTimer == 60) {  // Every 3 seconds (60 ticks at 60 FPS)
      directionChangeTimer = 0;
      changeRedRectDirection();
      changegreenRectDirection();
    }   // در این تابع هر 3 ثانیه یک جهت جدید برای کاراکتر قرمز و سبز تولید میشود

    double nextX = x + dx;
    double nextY = y + dy;
    int i = (int) (x / CHECKER_SIZE);
    int j = (int) (y / CHECKER_SIZE);

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
    
        double nextredX = redRectX + redRectDx;
    double nextredY = redRectY + redRectDy;
    
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

    redRect.setX(nextredX);
    redRect.setY(nextredY);
    
    
    
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

            
    greenRect.setLayoutX(greenRectX);
    greenRect.setLayoutY(greenRectY);
    

    for(Node node :pane.getChildren()){
        if(node instanceof Rectangle){
            Rectangle rect =(Rectangle)node;
            if(num_of_players >= 1){
            if(redRect.getBoundsInParent().intersects(rect.getBoundsInParent())){
                rect.setFill(Color.RED.deriveColor(0, 1, 1,0.9));
            }
            }
            if (num_of_players >= 2){
            
        if(greenRect.getBoundsInParent().intersects(rect.getBoundsInParent())){
                rect.setFill(Color.GREEN.deriveColor(0, 1, 1,0.9));
            }
            }
            
            
            if(num_of_players >= 1){
            if (redRect.getBoundsInParent().intersects(rect1.getBoundsInParent())) {
                System.exit(1);
            }}
            
            if(num_of_players >= 2){
            if (greenRect.getBoundsInParent().intersects(rect1.getBoundsInParent())) {
                System.exit(1);
            }}
            
            if(num_of_players >= 2)            
            if (redRect.getBoundsInParent().intersects(greenRect.getBoundsInParent())) {
                System.exit(1);
            }            
        }
    }
}

    private void changeRedRectDirection() {  //حرکت بعدی کاراکتر قرمز در این تابع مشخص میشود
                
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
            
    private void changegreenRectDirection() {  // حرکت بعدی کاراکتر سبز در این تابع مشخص میشود
                
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

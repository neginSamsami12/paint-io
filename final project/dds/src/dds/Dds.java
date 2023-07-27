import java.util.Random;


import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
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
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;



public class test extends Application {

    
    int num_of_players = 2;
    int redCount = 0;
    int greenCount = 0;
    Rectangle rect1;
    final double speeds = 2; //show how fast enemies will move(speed of the game)

    private static final int WIDTH = 1000;  //طول زمین بازی
    private static final int HEIGHT = 600; //عرض زمین بازی
    private static final int CHECKER_SIZE = 50; //میتوان زمین را بزرگتر کرد یعنی هرچی این عدد کمتر زمین بزرگتر و تعداد خانه ها ریز تر میشود
    
    private Pane pane;
    private Rectangle rect;
    int bullets_of_gun = 5; //یعنی اسلحه B چهار عدد گلوله دارد
    
    private double x = WIDTH / 2;
    private double y = HEIGHT / 2;
    private double dx = 0; //مکان اولیه ابی
    private double dy = 0;//مکان اولیه ابی
    private double speed = 5; //سرعت کاراکتراصلی 
    
   
    
    
    
    double redRectX = Math.random() * WIDTH;//مکان اولیه کاراکتر قرمز
    double redRectY = Math.random() * HEIGHT;//مکان اولیه کاراکتر قرمز
    double redRectDx = 0;
    double redRectDy = 0;
    
    int directionChangeTimer = 29;
    
    boolean redlost = true;
    boolean greenlost = true;
    boolean bluelost = true;
    
    int bluedirct;
    
    int redshot = 0;
    int greenshot = 0;
    int blueshot = 0;

    int redlevel = 2;//یک یعنی سخت دو یعنی متوسط و سه یعنی اسون و این اعداد نشان دهنده دقت شلیک بازیکنان هستند برای مثال در عددیک  یا اسان بازیکن باسه بار خطا شلیک میکند یعنی در دو شلیک اول دقت لازم را ندارد و در شلیک سوم به هدف میزند
    int greenlevel = 1;
    int bluelevel = 1;
    
    int redlevel_temp = redlevel;
    int bluelevel_temp = bluelevel;
    int greenlevel_temp = greenlevel;

    
    
    
    double greenRectX = Math.random() * WIDTH; //مکان اولیه کاراکتر سبز
    double greenRectY = Math.random() * HEIGHT; //مکان اولیه کاراکتر سبز
    double greenRectDx = 0;
    double greenRectDy = 0;
          
    
     
    
    
    public int kl;
    
    
    @Override
    public void start(Stage primaryStage) {
    hi st = new hi();
    st.start(primaryStage);

    
    }
    

        
        
    public void startGame(Stage primaryStage) {
       
       
        
           // create a menu
        Menu m = new Menu("menu");
  
        // create menuitems
        MenuItem m1 = new MenuItem("quit the game");
        MenuItem m2 =new MenuItem("show score");
        
        m.getItems().add(m1);
        m.getItems().add(m2);
        MenuBar mb = new MenuBar();
        mb.getMenus().add(m);
        VBox menubox =new VBox(mb);
  
       
  
        
      

        BackgroundFill white = new BackgroundFill(Color.YELLOW,null,null);
        BackgroundFill black = new BackgroundFill(Color.BLACK,null,null);
        pane = new Pane();
        
          
        pane.setPrefSize(2000, 2000);
        pane.setBackground(new Background(new BackgroundFill[]{black,white}[0]));
        
        for(int i =0;i <10000 /CHECKER_SIZE;i++){
            for(int j =0;j<10000/CHECKER_SIZE;j++){
                Rectangle rect = new Rectangle(CHECKER_SIZE,CHECKER_SIZE,((i+j)%2==0) ? black.getFill() :white.getFill());
                
                rect.setX(i * CHECKER_SIZE);
                rect.setY(j * CHECKER_SIZE);
                
                
               
                pane.getChildren().add(rect);
                

                  
            }
        }
        
              
             

       
        
        
        ScrollPane scrollPane = new ScrollPane(pane);
        scrollPane.setPrefWidth (300); // set the preferred width
        scrollPane.setPrefHeight (200); // set the preferred height
        scrollPane.setLayoutX (50); // set the layout x position
        scrollPane.setLayoutY (60);
       
        
        m1.setOnAction(event ->{
            System.exit(1);
            
            
        }
        );
        
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
          final double chkr_size = 50;
          
          for(int i=0; i < rows; i++){
              for(int j=0; j < cols; j++){
                  Rectangle recdt = new Rectangle(chkr_size,chkr_size);
                  double xi = i * chkr_size;
                  double yj = j * chkr_size;
                  recdt.setLayoutX(xi);
                  recdt.setLayoutY(yj);
                  recdt.setFill(((i+j)%2==0)?Color.YELLOW:Color.BLACK);
                  
                  
                  
                  
                  
                  
                  pane.getChildren().add(recdt);
              }
          }
          
          Move_Images redplayer = new Move_Images(pane,num_of_players,"file:C:\\Users\\SibCo\\Desktop\\87de8500-08d0-4f53-952c-df69c72b78f8.png");
          
          redplayer.create_image();
          
          if (num_of_players >= 1){
          redplayer.getchil();
          
          }
          
                    

          Move_Images greenplayer = new Move_Images(pane,num_of_players,"file:C:\\Users\\SibCo\\Desktop\\sonic-the-hedgehog-movie.jpg");
          greenplayer.create_image();

          if (num_of_players >= 2){
          greenplayer.getchil();
          
          }
          
          
          painting red_paint = new painting(pane);
          painting green_paint = new painting(pane);
          
          Weapon gun = new Weapon();
          
          

          ///------------------------------------------------------------------------------------------
          AnimationTimer timer = new AnimationTimer() {
            @Override
public void handle(long now) {
    
        
        directionChangeTimer++;
        blueshot += 1;
        greenshot += 1;
        redshot += 1;
    if (directionChangeTimer % 30 == 0) {  // Every 3 seconds (120 ticks at 120 FPS)
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
    
    
//    for (int m = 0; m <= WIDTH; m += 50){
//        for(int n = 0; n <= HEIGHT; n += 50){
//        
//        boolean redsee = false;
//        boolean greensee = false;
//    
//    if(red_paint.redcolorX == m && red_paint.redcolorY == n){
//    
//    redsee = true;
//    
//    }
//    
//    if(redsee){
//        redCount += 1;
//    }
//    if(green_paint.redcolorX == m && green_paint.redcolorY == n){
//    
//    greensee = true;
//    
//    }
//    
//    if(greensee){
//        greenCount += 1;
//    }
//        }
//        
//        
//    
//    
//    }

    
    
    
    
        primaryStage.getScene().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                
                    dy = -speed;
                    bluedirct = 1;
            }
                if (event.getCode() == KeyCode.LEFT){
                    dx = -speed;
                    bluedirct = 2;
                
                }
                if (event.getCode() == KeyCode.DOWN){
                    dy = speed;
                    bluedirct = 3;
        }
                if (event.getCode() == KeyCode.RIGHT){
                    dx = speed;
                    bluedirct = 4;
                }
            
        });
        

         
         
          primaryStage.getScene().setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case UP:
                case DOWN:
                    dy = 0;
                    break;
                case RIGHT:
                case LEFT:
                    dx = 0;
                    break;
            }
        }
          );
          
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
    redplayer.set_layout(redRectX, redRectY);//مربوط به حرکت عکس میباشد


    
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
            
            greenplayer.set_layout(greenRectX, greenRectY);//مربوط به حرکت عکس میباشد
    
    


            red_paint.paint_node(redRectX, redRectY, CHECKER_SIZE, num_of_players, redlost, "red");
            if(num_of_players >= 1 && redlost && !gun.redkill){
            red_paint.getchill();
            }

            green_paint.paint_node(greenRectX, greenRectY, CHECKER_SIZE, num_of_players, greenlost, "green");
            if(num_of_players >= 2 && greenlost && !gun.greenkill){
            green_paint.getchill();
            }


            if (red_paint.redcolorX == green_paint.redcolorX ||red_paint.redcolorY == green_paint.redcolorY ){

            pane.getScene().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.R && greenshot >= 1) {
                
                greenlevel_temp -= 1;
                
                if(greenlevel == 0){
                    
                    greenshot = 0;
                    redlost = false;
                    redplayer.get_killed(redlost);
                    greenlevel_temp = greenlevel;
                    
                }
        
            }
            if (event.getCode() == KeyCode.G && redshot >= 1) {
                redlevel_temp -= 1;
                if(redlevel_temp == 0){
                    
                    redshot = 0;
                    greenlost = false;
                    greenplayer.get_killed(greenlost);
                    redlevel_temp = redlevel;
                    



                    
                }
    }
});

}
 

            if (xi == green_paint.redcolorX || yj == green_paint.redcolorY ){

            pane.getScene().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE  && greenshot >= 1) {
                greenlevel_temp -= 1;
                if(greenlevel_temp == 0){
                    greenshot = 0;
                    bluelost = false;
                    pane.getChildren().remove(rect1);
                    greenlevel_temp = greenlevel;
                }
        
        }
        if (event.getCode() == KeyCode.G && blueshot >= 1) {
            bluelevel_temp -= 1;
            if(bluelevel_temp == 0){
            blueshot = 0;
            greenlost = false;
            greenplayer.get_killed(greenlost);
            bluelevel_temp = bluelevel;
            }
        }
    });

        }


        if (red_paint.redcolorX == xi ||red_paint.redcolorY == yj   ){

            pane.getScene().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.R && blueshot >= 1 ) {
                bluelevel_temp -= 1;
                if(bluelevel_temp == 0){
                blueshot = 0;
                redlost = false;
                redplayer.get_killed(redlost);
                bluelevel_temp = bluelevel;
                }
        
            }
            if (event.getCode() == KeyCode.SPACE && redshot >= 1) {
                redlevel_temp -= 1;
                if(redlevel_temp == 0){
                redshot = 0;
                bluelost = false;
                pane.getChildren().remove(rect1);
                redlevel_temp = redlevel;
                }
            }
});
}
scenee.setOnMousePressed(e -> {
   if (e.getButton() == MouseButton.SECONDARY) {
       bullets_of_gun -= 1;
       if(bullets_of_gun > 0){
       gun.shoot(CHECKER_SIZE, xi, yj, pane, bluedirct, red_paint.redcolorX, red_paint.redcolorY,green_paint.redcolorX, green_paint.redcolorY );
       
       if(gun.redkill){
       
       redplayer.get_killed(false);
       
       }
       
       if(gun.greenkill){
              
       greenplayer.get_killed(false);
       
       }
       }
   }
});
        
    for(Node node :pane.getChildren()){
        if(node instanceof Rectangle){
            Rectangle rect =(Rectangle)node;
            
            
            if(num_of_players >= 1 && redlost && bluelost){
            if (redplayer.get_ret().getBoundsInParent().intersects(rect1.getBoundsInParent())) {
                System.exit(1);
            }}
            
            if(num_of_players >= 2 && greenlost && bluelost){
            if (greenplayer.get_ret().getBoundsInParent().intersects(rect1.getBoundsInParent())) {
                System.exit(1);
            }}
            
            if(num_of_players >= 2 && redlost && greenlost)            
            if (redplayer.get_ret().getBoundsInParent().intersects(greenplayer.get_ret().getBoundsInParent())) {
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
//                    m2.setOnAction(event -> {
//    timer.stop();
//    if(greenCount > redCount){
//             System.out.println("red colored: " + redCount + "green colored :"+greenCount + "winner is green" );}
//    else{
//    System.out.println("red colored: " + redCount + "green colored :" +greenCount + "winner is red" );
//    
//    
//    }
//                });
    
    }
    
    
    

   
    public static void main(String[] args) {

        launch(args);
    }
    
}

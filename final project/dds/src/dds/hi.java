
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SibCo
 */
public class hi {
    
    boolean strt;
    
    
    
        public void start(Stage primaryStage) {

        // Start button
        Button startButton = new Button("Start Game");
        
        // Handle button click

        startButton.setOnAction(e -> {
            test ts = new test();
            ts.startGame(primaryStage);
        });
        BorderPane root = new BorderPane();
        root.setCenter(startButton);

        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setScene(scene); 
        primaryStage.show();
        
                
                
        
    }
            
}

/*
A maze that is square themed
Project 1
by Isaac Shaw
*/
   
import java.net.*;
import java.util.*;
import java.io.*;
import java.lang.*;

import javafx.geometry.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.application.*;

import javafx.beans.*;
import javafx.beans.property.*;
import javafx.beans.binding.*;
import javafx.beans.value.*;

import javafx.animation.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.input.*;

public class project1 extends Application{
   //Create needed Main Member Variables
   FlowPane root;
   Scene scene;
   Graphics image;
   GraphicsContext gc = new GraphicsContext2D();
   
   int[][] maze = new int[25][25];
   
   public void start(Stage stage){
      //Read in Maze file and put it in a 2D array
      Scanner read = new Scanner(new File("mazeFile"));
      for(int i = 0; i < 25; i++){
         for(int j = 0; j < 25; j++){
            maze[i][j] = read.netInt();
         }
      }
      
      //Create root and set pref size
      root = new FlowPane();
      root.setPrefSize(800, 200);
      
      //Create the Drawer class and add it to root
      image = new Graphics(525, 525);
      
      root.getChildren().add(image);
      root.setOnKeyPressed(new KeyPressedHandler());
      
      //Set Scence
      scene = new Scene(root, 800, 200);
      stage.setTitle("My First Animation");
      stage.setScene(scene);
      stage.show();
      
      //Request Focus
      root.requestFocus();
   }
   
   //Key Handler Class for awsd
   public class KeyPressedHandler implements EventHandler<KeyEvent>{
      public void handle(KeyEvent e){
         switch(e.getCode()){
            case KeyCode.A:
               break;
            case KeyCode.W:
               break;
            case KeyCode.S:
               break;
            case KeyCode.D:
               break;
         }
      }
   }
   
   //Drawer class for loading bar
   public class Graphics extends Canvas{
      
      //Create (and instantiate) variables
      private int x, y;  

      public Graphics(int width, int height){
         
         this.width = width;
         this.height = height;
         
         setWidth(width);
         setHeight(height);
         
      }

      public void draw(GraphicsContext gc){
      }
   } 
  
  
   //Launch the program
   public static void main(String[] args)
   {
      launch(args);
   }
}

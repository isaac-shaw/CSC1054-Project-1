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
   Canvas image = new Canvas();
   GraphicsContext gc = image.getGraphicsContext2D();
   
   int[][] maze = new int[25][25];
   
   public void start(Stage stage){
      //Read in Maze file and put it in a 2D array with a try/catch
      try{
         Scanner read = new Scanner(new File("mazeFile"));
         for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++){
               maze[i][j] = read.nextInt();
               System.out.print(maze[i][j] + " ");
            }
            System.out.println();
         }
      }catch(FileNotFoundException fnfe){
         System.out.println("File not Found :(");
      }
      
      //Paint the maze
      image.setWidth(525);
      image.setHeight(525);
      int x = 0, y = 0;
      
      for(int i = 0; i < 21; i++){
         for(int j = 0; j < 21; j++){
            if(maze[i][j] == 0){
               gc.setFill(Color.WHITE);
               gc.fillRect(x, y, 25, 25);
               x = x + 25;
            }else if(maze[i][j] == 1){
               gc.setFill(Color.BLACK);
               gc.fillRect(x, y, 25, 25);
               x = x + 25;
            }
         }
         y = y + 25;
         System.out.println(y + " ");
      }
      
      //Create root and set pref size
      root = new FlowPane();
      root.setPrefSize(800, 200);
      
      //Add the canvas to root
      root.getChildren().add(image);
      root.setOnKeyPressed(new KeyPressedHandler());
      
      //Set Scence
      scene = new Scene(root, 525, 525);
      stage.setTitle("A Fun Little Maze");
      stage.setScene(scene);
      stage.show();
      
      //Request Focus
      root.requestFocus();
   }
   
   //Key Handler Class for awsd
   public class KeyPressedHandler implements EventHandler<KeyEvent>{
      public void handle(KeyEvent e){
         switch(e.getText()){
            case "a":
               break;
            case "w":
               break;
            case "s":
               break;
            case "d":
               break;
         }
      }
   }
   
   //Launch the program
   public static void main(String[] args)
   {
      launch(args);
   }
}

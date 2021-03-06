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
   int[][] maze = new int[21][21];//2DArray that holds the maze in a coordinate system
   int start = 0, end = 0, playerX, playerY, proX, proY; //Pro Coords are where the player wants to go
   
   public void start(Stage stage){
      //Read in Maze file and put it in a 2D array with a try/catch
      try{
         Scanner read = new Scanner(new File("mazeFile.txt"));
         for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++){
               maze[j][i] = read.nextInt();
            }
         }
      }catch(FileNotFoundException fnfe){
         System.out.println("File not Found :(");
      }
      
      //Paint the maze
      image.setWidth(525);
      image.setHeight(525);
            
      for(int i = 0; i < 21; i++){
         for(int j = 0; j < 21; j++){
            if(maze[j][i] == 0){
               gc.setFill(Color.WHITE);
               gc.fillRect(j*25, i*25, 25, 25);
               //Find starting X Coord
               if(i == 0){
                  start = j;
               }
            }else if(maze[j][i] == 1){
               gc.setFill(Color.BLACK);
               gc.fillRect(j*25, i*25, 25, 25);
            }
         }
      }
      
      //Creating Player
      playerX = start;
      playerY = 0;
            
      gc.setFill(Color.CYAN);
      gc.fillRect(25*playerX, 25*playerY, 25, 25);
      
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
   
   //Key Handler Class for arrow keys
   public class KeyPressedHandler implements EventHandler<KeyEvent>{
      public void handle(KeyEvent e){
         switch(e.getCode()){
            case LEFT:
               proX = playerX - 1;
               proY = playerY;
               
               if(valid(proX, proY)){
                  refresh();
               }
               break;
            case UP:
               proX = playerX;
               proY = playerY - 1;
               if(valid(proX, proY)){
                  refresh();
               }
               break;
            case DOWN:
               proX = playerX;
               proY = playerY + 1;
               if(valid(proX, proY)){
                  refresh();
               }
               break;
            case RIGHT:
               proX = playerX + 1;
               proY = playerY;
               if(valid(proX, proY)){
                  refresh();
               }
               break;
         }
      }
   }
   
   //Refresh Player method
   public void refresh(){
      //Clears Player's current location
      gc.clearRect(25*playerX, 25*playerY, 25, 25);
      
      //Updates current location to new loaction
      playerX = proX;
      playerY = proY;
      
      //Redraws character
      gc.fillRect(25*playerX, 25*playerY, 25, 25);
   }
   
   
   public boolean valid(int checkProX, int checkProY){
      //Try Catch for out of bounds moves
      try{
         //Check if future location is valid (not a border), if vaild: return true
         if(maze[checkProX][checkProY] == 0){
            //If at the bottom, print the winning statement
            if(checkProY == 20){
               System.out.println("YOU WIN!!");
            }
            return true;
         }else{
            System.out.println("Cannot go through boundaries (black spaces)");
            return false;
         }
      }catch(ArrayIndexOutOfBoundsException aioobe){
         System.out.println("That is outside of the maze");
         return false;
      }
   }
   
   //Launch the program
   public static void main(String[] args){
      launch(args);
   }
}
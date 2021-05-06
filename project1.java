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
   
   public void start(Stage stage){
      
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
   
   //Key Handler Class for a and s
   public class KeyPressedHandler implements EventHandler<KeyEvent>{
      public void handle(KeyEvent e){
         if(e.getCode()==KeyCode.A){
            image.stop();
         }else if(e.getCode()==KeyCode.S){
            image.start();
         }
      }
   }
   
   //Drawer class for loading bar
   public class Graphics extends Canvas{
      
      //Create (and instantiate) variables
      private int width, height, totalLength = 0, padding = 10, 
         positionX, timer=0, step=2, color1=20, color2 = 255;
      protected GraphicsContext gc;
      Random rand = new Random();
      
      //Create and AnimationTimer within AnimationHandler
      AnimationTimer at = new AnimationHandler();   

      public Graphics(int width, int height){
         
         this.width = width;
         this.height = height;
         
         setWidth(width);
         setHeight(height);
         
         //Set starting position for loading bar
         positionX = (width/4)+padding;
                  
         gc = getGraphicsContext2D();
         
         //Create background color
         gc.setFill(Color.BLACK);
         gc.fillRect(0, 0, width, height);
         
         //Create Static Border
         gc.setStroke(Color.WHITE);
         gc.setLineWidth(5);
         gc.strokeRect(width/4, height/4, width/2, height/2);
         
         //XPositon for total length of loading bar
         totalLength = (width/2)-(padding)+(width/4);
         
         at.start();
         
      }
      
      //Mutators for AnimationTimer
      public void stop(){
         at.stop();
      }
      
      public void start(){
         at.start();
      }
      
      //Animation Timer
      public class AnimationHandler extends AnimationTimer{
         public void handle(long currenTimeInNanoSeconds){
            //Draws
            draw(gc);
            //Resets loading bar once it reaches necessary length
            if(positionX >= totalLength-step){
               timer = 0;
               color1 = 20;
               color2 = 255;
               positionX = (width/4)+padding+timer;
               gc.setFill(Color.BLACK);
               gc.fillRect(positionX, (height/4)+padding, (width/2)-(2*padding), (height/2)-(2*padding));
            }
         }
      } 
      
      //Draws 'step' more along the loading bar as the timer continue
      public void draw(GraphicsContext gc){
         positionX = (width/4)+padding+timer;
         
         gc.setFill(Color.rgb(0, color1++, color2--));
         gc.fillRect(positionX, (height/4)+padding, step, (height/2)-(2*padding));
         
         timer = timer + step;
      }
   } 
  
  
   //Launch the program
   public static void main(String[] args)
   {
      launch(args);
   }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EightQueensProblemSolver;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 *
 * @author mikap
 */
public class GameStart {

    /**
     * @param args the command line arguments
     */ 
    public static boolean checkIfStuck(ArrayList trackList){
          if(trackList.size() > 2){
              int lastCost = (int)trackList.get(trackList.size() - 1);
              int beforeLastCost = (int)trackList.get(trackList.size() - 2);
              if(lastCost == beforeLastCost){
                  return false;
              }
          }
          return true;
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        int step=0;
        int restart=0;
        
        JFrame frame= new JFrame("Eight Queens Problem Solver");
        JPanel gamePanel = new JPanel();
        BorderLayout experimentLayout = new BorderLayout();
        EightQueens eq = new EightQueens();
        int[][] map = eq.randomGenerator();
        JLabel myLabel2 = new JLabel("<html><p style=\"font-size: 16px\">&nbsp;&nbsp;Total number of steps: " + step + "</p><br/>" + "<p style=\"font-size: 16px\">&nbsp;&nbsp;Total number of restarts: " + restart + "&nbsp;&nbsp;</p></html>");

        
        frame.setLayout(experimentLayout);
        frame.add(myLabel2, BorderLayout.LINE_START); 
        gamePanel = Board.gamePanel(map);
        
        
        frame.add(gamePanel);
        frame.setSize(1024, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
        frame.setVisible(true);
        
        TimeUnit.SECONDS.sleep(1);
   
        State root = eq.cost(map);
        QueenTree eightQueenTree = new QueenTree(root);
        ArrayList trackList = new ArrayList<Integer>();

        while(eightQueenTree.getRoot().getCost() != 0){
           eightQueenTree.movement();
           trackList.add(eightQueenTree.getRoot().getCost());
           if(!checkIfStuck(trackList)){
               restart++;
               int[][] newMap = eq.randomGenerator();
               eightQueenTree.setRoot(eq.cost(newMap));
               trackList.clear();

           }
               step++;
               frame.remove(myLabel2);
               myLabel2.setText("<html><p style=\"font-size: 16px\">&nbsp;&nbsp;Total number of steps: " + step + "</p><br/>" + "<p style=\"font-size: 16px\">&nbsp;&nbsp;Total number of restarts: " + restart + "&nbsp;&nbsp;</p></html>");
               frame.setLayout(experimentLayout);
               frame.add(myLabel2, BorderLayout.LINE_START); 
               frame.remove(gamePanel);
               gamePanel = Board.gamePanel(eightQueenTree.getRoot().getState());
               frame.add(gamePanel);
               frame.revalidate();
               frame.repaint();
               TimeUnit.SECONDS.sleep(1);
           
        }
        int[][] successState = eightQueenTree.getRoot().getState();
         frame.remove(myLabel2);
               myLabel2.setText("<html><p style=\"font-size: 18px; color:green;\">&nbsp;&nbsp;SUCCESSFUL!&nbsp;&nbsp;</p><p style=\"font-size: 16px\">&nbsp;&nbsp;Total number of steps: " + step + "</p><br/>" + "<p style=\"font-size: 16px\">&nbsp;&nbsp;Total number of restarts: " + restart + "&nbsp;&nbsp;</p></html>");
               frame.setLayout(experimentLayout);
               frame.add(myLabel2, BorderLayout.LINE_START); 
               frame.remove(gamePanel);
               gamePanel = Board.gamePanel(successState);
               frame.add(gamePanel);
               frame.revalidate();
               frame.repaint();
               
        System.out.println("The success state has been found!");
        eightQueenTree.printMatrix(successState);
        System.out.println(step + " steps to success.");
        System.out.println(restart + " restarts to success.");
        

        
        
        
        
    }
    
}

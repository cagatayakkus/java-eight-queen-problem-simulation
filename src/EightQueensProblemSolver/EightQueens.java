/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EightQueensProblemSolver;

import java.util.Random;

/**
 *
 * @author mikap
 */
public class EightQueens {
    public int[][] randomGenerator(){
        int[][] matrix = new int[8][8];
        for (int i = 0; i < 8; i++) {
            Random rand = new Random();
            int randomInt = rand.nextInt(8);
            for (int j = 0; j < 8; j++) {
                if(j == randomInt){
                    matrix[j][i] = 1;
                }else {
                    matrix[j][i] = 0;
                }
            }
        }
        return matrix;   
    }
    
    public State cost(int[][] matrix){
    int totalCost = 0;
        for (int i = 0; i < 8; i++) {
            int y = findQueen(i, matrix);
            totalCost += eachCost(y, i, matrix);
        }
    State newState = new State(matrix, totalCost);
    return newState;
    }
    //
    public int eachCost(int x, int y, int[][] matrix){
        int cost = 0;
        int crossed = isCrossed(x, y, matrix);
        int horizontal = isHorizontal(x, y, matrix);
        cost = crossed + horizontal;
        return cost;
    }
    
    
    
    public int isHorizontal(int x, int y, int[][] matrix){
        int cost = 0;
        int tempY = y;
        while (tempY < 7){
            if(matrix[x][++tempY] == 1){
                cost++;
            }
        }
        tempY = y;
        //3
        while (tempY > 0){
                
            if(matrix[x][--tempY] == 1){
                cost++;
            }
        }
        return cost;
    }
    
    
    
    public int isCrossed(int x, int y, int[][] matrix){
        int cost = 0;
        int tempX = x;
        int tempY = y;
        while (tempY > 0){
            if(tempX > 6){
                break;
            }
            if((matrix[++tempX][--tempY] == 1)){
                cost++;
            }
        }
        tempX = x;
        tempY = y;
        while (tempX > 0){
            if(tempY > 6){
                break;
            }
            if((matrix[--tempX][++tempY] == 1)){
                cost++;
            }
        }
        tempX = x;
        tempY = y;
        while (tempX > 0){
            if(tempY < 1){
                break;
            }
            if((matrix[--tempX][--tempY] == 1)){
                cost++;
            }
        }
        
        
        tempX = x;
        tempY = y;
        while (tempX < 7){
            if(tempY >= 7){
                break;
            }
            if((matrix[++tempX][++tempY] == 1)){
                cost++;
            }
        }
        return cost;
    }
    
    
    
    
    public int findQueen(int column, int[][] matrix){
        int position = 0;
        for (int i = 0; i < 8; i++) {
            if(matrix[i][column] == 1){
                position = i;
            }
        }
        
        return position;
    }
}

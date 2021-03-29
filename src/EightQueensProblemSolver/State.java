/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EightQueensProblemSolver;

/**
 *
 * @author mikap
 */
public class State {
    int[][] state;
    int cost;
    public State(int[][] matrix, int cost){
        state = matrix;
        this.cost = cost;
    }
    public int[][] getState(){
        int[][] clone = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                clone[i][j] = state[i][j];
            }
        }
        return clone;
    }
    public int getCost(){
        return cost;
    }
}

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
public class QueenTree {
    State root;
    State[] childs = new State[64];
    public QueenTree(State root){
        this.root = root;
        System.out.println("New root assigned: ");
        printMatrix(root.getState());
        System.out.println("");
        
    }
    public State getRoot(){
        return root;
    }
    public void setRoot(State root){
        this.root = root;
        System.out.println("New root assigned: ");
        printMatrix(root.getState());
        System.out.println("");
    }
    public void movement(){
        int k = 0;
        int possibility = 1;
        for (int i = 0; i < 8; i++) {
            
            int[][] state = root.getState();
            int y = findQueen(i, state);
            state[y][i] = 0;
            for (int j = 0; j < 8; j++) {
                    int[][] innerState = state.clone();
                    innerState[j][i] = 1;
                    EightQueens eq = new EightQueens();
                    State oneChild = new State(eq.cost(innerState).getState(), eq.cost(innerState).getCost());
                    System.out.println("The " + possibility + ". possibility of total 64 possibilities of the root: ");
                    printMatrix(oneChild.getState());
                    System.out.println("");
                    childs[k] = oneChild;
                    k++; possibility++;
                    state[j][i] = 0;
            }
        }

        State newRoot = findMinimum(childs);
        root = newRoot;
    }

    public State findMinimum(State[] list){
        State min = list[0];
        for (Object child : list) {
            State childState = (State)child;
            if(childState.getCost() < min.getCost()){
                min = childState;
            }
        }
        return min;
    }
        public void printMatrix(int[][] matrix){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
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

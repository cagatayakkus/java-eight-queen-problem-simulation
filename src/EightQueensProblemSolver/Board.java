/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EightQueensProblemSolver;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author mikap
 */
public class Board {
    public static JPanel gamePanel(int[][] state){
        JPanel gamePanel = new JPanel( new GridLayout(state.length,state[0].length));
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                           JLabel label = new JLabel();
                           label.setBorder(new LineBorder(Color.BLACK));
                           if(state[i][j] == 1)
                             label.setIcon(new ImageIcon("images/queen.png"));
                           gamePanel.add( label ); 
            }

        }
        return gamePanel;
    }
}

package com.company;

import com.company.MyJButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Main {

    public static JLabel top = new JLabel("TicTacToe: Choose Game Mode");
    public static JPanel center = new JPanel();
    public static JPanel center2 = new JPanel();
    public static JButton buttons[][];
    public static MyJButton b[][];
    public static int dim = 3;
    public static int moves = 0;

    public static int checkPvp() {
        boolean ok = true;
        for (int i=1;i<dim;i++) {
            if (b[i][i].getValue() != b[0][0].getValue()) {
                ok = false;
            }
        }
        if (ok && b[0][0].getValue() != -1) {
            return b[0][0].getValue();
        }

        ok = true;
        for (int i=1;i<dim;i++) {
            if (b[i][dim - i - 1].getValue() != b[0][dim - 1].getValue()) {
                ok = false;
            }
        }
        if (ok  && b[0][dim-1].getValue() != -1) {
            return b[0][dim-1].getValue();
        }

        for (int i=0;i<dim;i++) {
            ok = true;
            for (int j=1;j<dim;j++)
                if (b[i][j].getValue() != b[i][0].getValue())
                    ok = false;
            if (ok  && b[i][0].getValue() != -1) {
                return b[i][0].getValue();
            }

        }

        for (int j=0;j<dim;j++) {
            ok = true;
            for (int i=1;i<dim;i++)
                if (b[i][j].getValue() != b[0][j].getValue())
                    ok = false;
            if (ok  && b[0][j].getValue() != -1) {
                return b[0][j].getValue();
            }
        }

        return -1;
    }

    public static int checkPvAi(){

        return -1;
    }

    public static void removeAll() {
        for (int i=0;i<dim;i++)
            for (int j=0;j<dim;j++)
                b[i][j].setEnabled(false);
    }

    public static int checkIfDanger() {
        //checking each line
        for (int i=0; i<dim; i++){
            int nrX=0;
            int nr0=0;
            for (int j=0; j<dim; j++){
                if (b[i][j].getValue()==0){
                    nr0++;
                }
                if (b[i][j].getValue()==1){
                    nrX++;
                }
            }
            if (nrX==2 && nr0==0){
                for (int j=0; j<dim; j++){
                    if (b[i][j].getValue()==-1){
                        b[i][j].setEnabled(false);
                        b[i][j].setValue(0);
                        b[i][j].draw();
                        moves++;
                        return 1;
                    }
                }
            }
        }

        //checking each column
        for (int j=0; j<dim; j++){
            int nrX=0;
            int nr0=0;
            for (int i=0; i<dim; i++){
                if (b[i][j].getValue()==0){
                    nr0++;
                }
                if (b[i][j].getValue()==1){
                    nrX++;
                }
            }
            if (nrX==2 && nr0==0){
                for (int i=0; i<dim; i++){
                    if (b[i][j].getValue()==-1){
                        b[i][j].setEnabled(false);
                        b[i][j].setValue(0);
                        b[i][j].draw();
                        moves++;
                        return 1;
                    }
                }
            }
        }

        //checking first diagonal
        int nr0=0;
        int nrX=0;
        for (int i=0; i<dim; i++){
            if (b[i][i].getValue()==0){
                nr0++;
            }
            if (b[i][i].getValue()==1){
                nrX++;
            }
        }
        if (nrX==2 && nr0==0){
            for (int i=0; i<dim; i++){
                if (b[i][i].getValue()==-1){
                    b[i][i].setEnabled(false);
                    b[i][i].setValue(0);
                    b[i][i].draw();
                    moves++;
                    return 1;
                }
            }
        }

        //checking second diagonal
        nr0=0;
        nrX=0;
        for (int j=0, i=dim-1; i>=0 && j<dim; i--, j++){
            if (b[i][j].getValue()==0){
                nr0++;
            }
            if (b[i][j].getValue()==1){
                nrX++;
            }
        }

        if (nrX==2 && nr0==0){
            for (int j=0, i=dim-1; i>=0 && j<dim; i--, j++){
                if (b[i][j].getValue()==-1){
                    b[i][j].setEnabled(false);
                    b[i][j].setValue(0);
                    b[i][j].draw();
                    moves++;
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int checkIfWinable() {
        //checking each line
        for (int i=0; i<dim; i++){
            int nrX=0;
            int nr0=0;
            for (int j=0; j<dim; j++){
                if (b[i][j].getValue()==0){
                    nr0++;
                }
                if (b[i][j].getValue()==1){
                    nrX++;
                }
            }
            if (nrX==0 && nr0==2){
                for (int j=0; j<dim; j++){
                    if (b[i][j].getValue()==-1){
                        b[i][j].setEnabled(false);
                        b[i][j].setValue(0);
                        b[i][j].draw();
                        moves++;
                        return 1;
                    }
                }
            }
        }

        //checking each column
        for (int j=0; j<dim; j++){
            int nrX=0;
            int nr0=0;
            for (int i=0; i<dim; i++){
                if (b[i][j].getValue()==0){
                    nr0++;
                }
                if (b[i][j].getValue()==1){
                    nrX++;
                }
            }
            if (nrX==0 && nr0==2){
                for (int i=0; i<dim; i++){
                    if (b[i][j].getValue()==-1){
                        b[i][j].setEnabled(false);
                        b[i][j].setValue(0);
                        b[i][j].draw();
                        moves++;
                        return 1;
                    }
                }
            }
        }

        //checking first diagonal
        int nr0=0;
        int nrX=0;
        for (int i=0; i<dim; i++){
            if (b[i][i].getValue()==0){
                nr0++;
            }
            if (b[i][i].getValue()==1){
                nrX++;
            }
        }
        if (nrX==0 && nr0==2){
            for (int i=0; i<dim; i++){
                if (b[i][i].getValue()==-1){
                    b[i][i].setEnabled(false);
                    b[i][i].setValue(0);
                    b[i][i].draw();
                    moves++;
                    return 1;
                }
            }
        }

        //checking second diagonal
        nr0=0;
        nrX=0;
        for (int j=0, i=dim-1; i>=0 && j<dim; i--, j++){
            if (b[i][j].getValue()==0){
                nr0++;
            }
            if (b[i][j].getValue()==1){
                nrX++;
            }
        }

        if (nrX==0 && nr0==2){
            for (int j=0, i=dim-1; i>=0 && j<dim; i--, j++){
                if (b[i][j].getValue()==-1){
                    b[i][j].setEnabled(false);
                    b[i][j].setValue(0);
                    b[i][j].draw();
                    moves++;
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int aiTurn() {
        int icurr = 0;
        int jcurr = 0;
        if (moves==1){
            for (int i=0;i<dim;i++) {
                for (int j = 0; j < dim; j++) {
                    if (b[i][j].getValue()==1){
                        icurr=i;
                        jcurr=j;
                    }
                }
            }
            if ( (icurr == 0 && jcurr ==0) || (icurr == 0 && jcurr ==2) || (icurr == 2 && jcurr ==0) || (icurr == 2 && jcurr ==2)) {
                if (jcurr == 0) {
                    b[1][1].setEnabled(false);
                    b[1][1].setValue(0);
                    b[1][1].draw();
                    moves++;
                }
            }
            if (moves==1) {
                if (b[1][1].getValue()==-1){
                    b[1][1].setEnabled(false);
                    b[1][1].setValue(0);
                    b[1][1].draw();
                    moves++;
                }
                else{
                    b[2][2].setEnabled(false);
                    b[2][2].setValue(0);
                    b[2][2].draw();
                    moves++;
                }
            }
            return 0;
        }
        else{
            if (checkIfWinable()==1){
                return 1;
            }
            else {
                if (checkIfDanger()==1){
                    return 0;
                }
                else{
                    if (b[1][0].getValue()==-1){
                        b[1][0].setEnabled(false);
                        b[1][0].setValue(0);
                        b[1][0].draw();
                        moves++;
                        return 0;
                    }
                    if (b[1][2].getValue()==-1){
                        b[1][2].setEnabled(false);
                        b[1][2].setValue(0);
                        b[1][2].draw();
                        moves++;
                        return 0;
                    }
                    if (b[2][1].getValue()==-1){
                        b[2][1].setEnabled(false);
                        b[2][1].setValue(0);
                        b[2][1].draw();
                        moves++;
                        return 0;
                    }
                    if (b[1][2].getValue()==-1){
                        b[1][2].setEnabled(false);
                        b[1][2].setValue(0);
                        b[1][2].draw();
                        moves++;
                        return 0;
                    }
                    if (b[0][0].getValue()==-1){
                        b[0][0].setEnabled(false);
                        b[0][0].setValue(0);
                        b[0][0].draw();
                        moves++;
                        return 0;
                    }
                    if (b[2][2].getValue()==-1){
                        b[2][2].setEnabled(false);
                        b[2][2].setValue(0);
                        b[2][2].draw();
                        moves++;
                        return 0;
                    }
                    if (b[2][0].getValue()==-1){
                        b[2][0].setEnabled(false);
                        b[2][0].setValue(0);
                        b[2][0].draw();
                        moves++;
                        return 0;
                    }
                    if (b[0][2].getValue()==-1){
                        b[0][2].setEnabled(false);
                        b[0][2].setValue(0);
                        b[0][2].draw();
                        moves++;
                        return 0;
                    }
                }
            }
            return 0;
        }
    }


    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300, 300);
        window.setLayout(new BorderLayout());
        center.setLayout(new GridLayout(1, 2));
        buttons = new JButton[1][2];
        buttons[0][0] = new JButton("Player vs Player");
        buttons[0][1] = new JButton("Player vs AI");

        center.add(buttons[0][0]);
        center.add(buttons[0][1]);

        window.add(top, BorderLayout.NORTH);
        window.add(center, BorderLayout.CENTER);

        window.setVisible(true);

        // playing pvp
        buttons[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent pvp) {

                window.remove(center);
                top.setText("TicTacToe: Player vs Player");
                window.revalidate();
                window.repaint();

                // so far so good
                JLabel bottom = new JLabel("X's Move");
                center = new JPanel();
                center.setLayout(new GridLayout(dim, dim));
                b = new MyJButton[dim][dim];

                for (int i = 0; i < dim; i++){
                    for (int j = 0; j < dim; j++) {
                        b[i][j] = new MyJButton(-1);
                        b[i][j].draw();

                        b[i][j].addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub

                                MyJButton currentObject = (MyJButton) e.getSource();
                                currentObject.setEnabled(false);
                                if (currentObject.getValue() != -1)
                                    return;
                                moves++;

                                if (moves % 2 == 1) {
                                    currentObject.setValue(1);
                                    bottom.setText("0's move");

                                } else {
                                    currentObject.setValue(0);
                                    bottom.setText("X's move");
                                }

                                int end = checkPvp();

                                if (end == 0) {
                                    bottom.setText("0 won!");
                                    removeAll();
                                } else {
                                    if (end == 1) {
                                        bottom.setText("X won!");
                                        removeAll();
                                    } else {
                                        if (moves == dim * dim) {
                                            bottom.setText("Draw!");
                                            removeAll();
                                        }
                                    }
                                }
                                currentObject.draw();

                            }
                        });

                        center.add(b[i][j]);
                    }
                }
                window.add(top, BorderLayout.NORTH);
                window.add(bottom, BorderLayout.SOUTH);
                window.add(center, BorderLayout.CENTER);
            }
        });

        // playing pvai
        buttons[0][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent pvai) {
                window.remove(center);
                top.setText("TicTacToe: Player vs AI");
                window.revalidate();
                window.repaint();
                JLabel bottom2 = new JLabel("Playing against AI...");

                center2.setLayout(new GridLayout(dim, dim));
                b = new MyJButton[dim][dim];
                for (int i=0;i<dim;i++) {
                    for (int j = 0; j < dim; j++) {
                        b[i][j] = new MyJButton(-1);
                        b[i][j].draw();

                        b[i][j].addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub

                                MyJButton currentObject = (MyJButton) e.getSource();
                                currentObject.setEnabled(false);
                                if (currentObject.getValue() != -1)
                                    return;
                                moves++;
                                currentObject.setValue(1);
                                currentObject.draw();
                                int end = checkPvAi();
                                if (end==1){
                                    removeAll();
                                    bottom2.setText("Player won!");
                                }
                                else{
                                    if (moves==dim*dim){
                                        removeAll();
                                        bottom2.setText("Draw!");
                                    }
                                    else {
                                        if (aiTurn()==1){
                                            removeAll();
                                            bottom2.setText("AI won!");
                                        }
                                    }
                                }



                            }
                        });

                        center2.add(b[i][j]);
                    }
                }
                window.add(top, BorderLayout.NORTH);
                window.add(center2, BorderLayout.CENTER);
                window.add(bottom2, BorderLayout.SOUTH);
            }
        });

    }
}

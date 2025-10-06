package com.javarush.games.ticktacktoe;

import com.javarush.engine.cell.*;

public class TicTacToeGame extends Game {
    private int[][] model = new int[3][3];
    private int currentPlayer;
    private boolean isGameStopped;

    public void initialize(){
        setScreenSize(3,3);
        startGame();
        updateView();
    }

    public void startGame(){
        isGameStopped = false;
        for (int i = 0; i < model.length; i++){
            for (int j = 0; j < model[i].length; j++){
                model[i][j] = 0;
            }
        }
        currentPlayer = 1;
    }


    public void updateCellView( int x, int y, int value){
        String displayedValue = null;
        Color displayedColor = Color.WHITE;

        //setCellValueEx(x, y, Color.WHITE, displayedValue, Color.WHITE);
        if (value == 0){
            displayedValue = " ";
        }
        else if (value == 1){
            displayedValue = "X";
            //setCellValueEx(x, y, Color.WHITE, displayedValue, Color.RED);
            displayedColor = Color.RED;
        }
        else if (value == 2){
            displayedValue = "O";
            //setCellValueEx(x, y, Color.WHITE, displayedValue, Color.BLUE);
            displayedColor = Color.BLUE;
        }
        else{
            displayedValue = null;
        }
        if (displayedValue == null){
            System.out.println("Ошибка значения value: " + value);
        }
        setCellValueEx(x, y, Color.WHITE, displayedValue, displayedColor);

    }

    public void updateView(){
        for (int i = 0; i < model.length; i ++){
            for (int j = 0; j < model[i].length; j++){
                updateCellView(i, j, model[i][j]);
            }
        }
    }

    /**
     * Called when the user clicks on the game field with the mouse.
     * @param x :Position (coordinate) on the game field
     * @param y :Position (coordinate) on the game field
     */
    public void onMouseLeftClick(int x, int y){
        if ((isGameStopped)||(model[x][y] != 0)) {
            return;
        }
        else {
            model[x][y] = currentPlayer;
            updateView();
            currentPlayer = 3 - currentPlayer;
        }
    }

}
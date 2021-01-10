package com.example.sudokugame;

import android.content.Context;
import android.widget.Chronometer;

import com.example.sudokugame.view.sudokugrid.GameGrid;

public class GameEngine {
    //Chronometer chronometer;
    private static GameEngine instance;

    private static GameGrid grid = null;

    private int selectedPosX = -1, selectedPosY = -1;

    private GameEngine(){}

    public static GameEngine getInstance(){
        if( instance == null ){
            instance = new GameEngine();
        }
        return instance;
    }

    public void createGrid( Context context ){
        int[][] Sudoku = SudokuGenerator.getInstance().generateGrid();
        Sudoku = SudokuGenerator.getInstance().removeElementss(Sudoku);
        grid = new GameGrid(context);
        grid.setGrid(Sudoku);
      // chronometer.start();
    }

    public GameGrid getGrid(){
        return grid;
    }

    public void setSelectedPosition( int x , int y ){
        selectedPosX = x;
        selectedPosY = y;
    }

    public void setNumber( int number ){
        if( selectedPosX != -1 && selectedPosY != -1 ){
            grid.setItem(selectedPosX,selectedPosY,number);
        }
      //  grid.checkGame();


    }
    public boolean chk(){

        if(grid.checkGamee()){
            return true;
        }
        else {
            return false;
        }
    }

//    public static boolean isChronoStop(){
//        if(grid.chronoStop()){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }
}

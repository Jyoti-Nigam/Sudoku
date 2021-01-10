package com.example.sudokugame.view.sudokugrid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Chronometer;
import android.widget.Toast;

import com.example.sudokugame.MainActivity;
import com.example.sudokugame.SudokuChecker;

public class GameGrid {
    private SudokuCell[][] Sudoku = new SudokuCell[9][9];
    AlertDialog.Builder builder;

    private Context context;

    public GameGrid(Context context) {
        this.context = context;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                Sudoku[x][y] = new SudokuCell(context);
            }
        }
    }

    public void setGrid(int[][] grid) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                Sudoku[x][y].setInitValue(grid[x][y]);
                if (grid[x][y] != 0) {
                    Sudoku[x][y].setNotModifiable();
                }
            }
        }
    }

    public SudokuCell[][] getGrid() {
        return Sudoku;
    }

    public SudokuCell getItem(int x, int y) {
        return Sudoku[x][y];
    }

    public SudokuCell getItem(int position) {
        int x = position % 9;
        int y = position / 9;

        return Sudoku[x][y];
    }

    public void setItem(int x, int y, int number) {
        Sudoku[x][y].setValue(number);
    }

    public void checkGame() {
        //builder = new AlertDialog.Builder(context);
        int[][] sudGrid = new int[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                sudGrid[x][y] = getItem(x, y).getValue();
            }
        }

       // if (SudokuChecker.getInstance().checkSudoku(sudGrid)) {
            // Toast.makeText(context, "You solved the sudoku.", Toast.LENGTH_LONG).show();
            // return true;
       // }
    }

    public boolean checkGamee() {

        int[][] sudGrid = new int[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                sudGrid[x][y] = getItem(x, y).getValue();
            }
        }

        if (SudokuChecker.getInstance().checkSudoku(sudGrid)) {
            // Toast.makeText(context, "You solved the sudoku.", Toast.LENGTH_LONG).show();
             return true;


        }
        else{
            return false;
        }
    }

}
//       else {
//            return false;
//        }


//            //Setting message manually and performing action on button click
//            builder.setMessage("Do you want to close this application ?")
//                    .setCancelable(false)
//                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//
//                            Toast.makeText(context,"you choose yes action for alertbox",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            //  Action for 'NO' Button
//                            dialog.cancel();
//                            Toast.makeText(context,"you choose no action for alertbox",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    });
//            //Creating dialog box
//            AlertDialog alert = builder.create();
//            //Setting the title manually
//            alert.setTitle("AlertDialogExample");
//            alert.show();




//    public boolean chronoStop(){
//        int [][] sudGrid = new int[9][9];
//        if(SudokuChecker.getInstance().checkSudoku(sudGrid)){
//            return true;
//        }
//        else {
//            return false;
//        }
//    }


package com.example.sudokugame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity{
    Button done;
   public Chronometer simpleChronometerr;
    //String[] users = { "Easy", "Medium", "Hard"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        simpleChronometerr =findViewById(R.id.simpleChronometer);
        done=findViewById(R.id.btn_done);
        View contextView = findViewById(android.R.id.content);
//        Spinner spin = (Spinner) findViewById(R.id.spinner1);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spin.setAdapter(adapter);
//        spin.setOnItemSelectedListener(this);

       // tx=findViewById(R.id.txt);
       // String t=tx.getText().toString();
//        SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("value", t);
//        editor.commit();
//        GameEngine.getInstance().createGrid(this);

        GameEngine.getInstance().createGrid(this);
        simpleChronometerr.start();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GameEngine.getInstance().chk()){
                    Toast.makeText(getApplicationContext(),"You solve sudoku in "+simpleChronometerr.getText().toString()+" Minutes",Toast.LENGTH_SHORT).show();
                    simpleChronometerr.stop();
                    finish();
                }
                else if(!GameEngine.getInstance().chk()){
                    Toast.makeText(getApplicationContext(),"Try again ",Toast.LENGTH_SHORT).show();
                    recreate();



                }
            }


        });




//        }
//        if(GameEngine.isChronoStop()){
//            simpleChronometerr.stop();
//           //Toast.makeText(getApplicationContext())
//            Toast.makeText(getApplicationContext(), "You solved the sudoku.", Toast.LENGTH_LONG).show();
////
//        }

    }
    private void snakact() {
        //finish();
        recreate();
    }
    private void printSudoku(int Sudoku[][]) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print(Sudoku[x][y] + "|");
            }
            System.out.println();
        }
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String t=users[position];
//        SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putString("value", t);
//        editor.commit();
//        GameEngine.getInstance().createGrid(this);
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        Toast.makeText(getApplicationContext(),"Select level",Toast.LENGTH_LONG).show();
//    }
}
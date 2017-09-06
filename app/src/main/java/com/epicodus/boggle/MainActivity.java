package com.epicodus.boggle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<String> roll = new ArrayList<String>();
    private String[][] die = new String[][] {
            {"R","I","F","O","B","X"},
            {"I","F","E","H","E","Y"},
            {"D","E","N","O","W","S"},
            {"U","T","O","K","N","D"},
            {"H","M","S","R","A","O"},
            {"L","U","P","E","T","S"},
            {"A","C","I","T","O","A"},
            {"Y","L","G","K","U","E"},
            {"Qu","B","M","J","O","A"},
            {"E","H","I","S","P","N"},
            {"V","E","T","I","G","N"},
            {"B","A","L","I","Y","T"},
            {"E","Z","A","V","N","D"},
            {"R","A","L","E","S","C"},
            {"U","W","I","L","R","G"},
            {"P","A","C","E","M","D"}};

    //@Bind(R.id.testRandom) TextView tester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        for(int i=0; i<=15; i++){

            roll.add(die[i][rollDie()]);
        }

     //   tester.setText(roll.toString());

        gridView = (GridView) findViewById(R.id.baseGridView);
        gridView.setAdapter(new BoggleAdapter(this, roll));

    }


    public int rollDie() {

        // NOTE: This will (intentionally) not run as written so that folks
        // copy-pasting have to think about how to initialize their
        // Random instance.  Initialization of the Random instance is outside
        // the main scope of the question, but some decent options are to have
        // a field that is initialized once and then re-used as needed or to
        // use ThreadLocalRandom (if using at least Java 1.7).
        int min = 0;
        int max  = 5;
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int rollResults = rand.nextInt((max - min) + 1) + min;

        return rollResults;
    }
}

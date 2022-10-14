package com.example.kockadobas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView dice1;
    ImageView dice2;
    Button oneDice;
    Button twoDice;
    Button generate;
    Button reset;
    TextView results;

    private int dices = 2;
    private int dice1Result;
    private int dice2Result;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice1 = (ImageView) findViewById(R.id.dice1);
        dice2 = (ImageView) findViewById(R.id.dice2);
        oneDice = (Button) findViewById(R.id.oneDice);
        twoDice = (Button) findViewById(R.id.twoDice);
        generate = (Button) findViewById(R.id.generate);
        reset = (Button) findViewById(R.id.reset);
        results = (TextView) findViewById(R.id.results);

        oneDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dices = 1;
                dice2.setVisibility(View.GONE);
            }
        });

        twoDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dices = 2;
                dice2.setVisibility(View.VISIBLE);
            }
        });

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dices == 1){
                    generateOne();
                    result = dice1Result;
                    results.append(String.valueOf(result) + "\n");
                } else {
                    generateOne();
                    generateTwo();
                    result = dice1Result + dice2Result;
                    results.append(String.valueOf(result) + " (" + String.valueOf(dice1Result) + "+" + String.valueOf(dice2Result) + ")\n");
                }
            }
        });
    }

    private void generateOne(){
        dice1Result = (int)(Math.random() * 7 + 1);
        if (dice1Result == 1){
            dice1.setImageResource(R.drawable.kocka1);
        } else if (dice1Result == 2){
            dice1.setImageResource(R.drawable.kocka2);
        } else if (dice1Result == 3){
            dice1.setImageResource(R.drawable.kocka3);
        } else if (dice1Result == 4){
            dice1.setImageResource(R.drawable.kocka4);
        } else if (dice1Result == 5){
            dice1.setImageResource(R.drawable.kocka5);
        } else {
            dice1.setImageResource(R.drawable.kocka6);
        }
    }

    private void generateTwo(){
        dice2Result = (int)(Math.random() * 7 + 1);
        if (dice2Result == 1){
            dice2.setImageResource(R.drawable.kocka1);
        } else if (dice2Result == 2){
            dice2.setImageResource(R.drawable.kocka2);
        } else if (dice2Result == 3){
            dice2.setImageResource(R.drawable.kocka3);
        } else if (dice2Result == 4){
            dice2.setImageResource(R.drawable.kocka4);
        } else if (dice2Result == 5){
            dice2.setImageResource(R.drawable.kocka5);
        } else {
            dice2.setImageResource(R.drawable.kocka6);
        }
    }
}
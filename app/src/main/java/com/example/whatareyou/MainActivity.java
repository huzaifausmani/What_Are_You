package com.example.whatareyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] questions = {"1. You just entered a crowded party. Everyone is having conversations and stuff. What will you do?",
            "2","3","4","5","6","7","8","9","10"};
    ArrayList<String> answers1 = new ArrayList<>(Arrays.asList("1Stand in a corner alone","2Talk with first person I see","3","4","5","6"));
    ArrayList<String> answers2 = new ArrayList<>(Arrays.asList("","","","","",""));
    ArrayList<String> answers3 = new ArrayList<>(Arrays.asList("","","","","",""));
    ArrayList<String> answers4 = new ArrayList<>(Arrays.asList("","","","","",""));
    ArrayList<String> answers5 = new ArrayList<>(Arrays.asList("","","","","",""));
    ArrayList<String> answers6 = new ArrayList<>(Arrays.asList("","","","","",""));
    ArrayList<String> answers7 = new ArrayList<>(Arrays.asList("","","","","",""));
    ArrayList<String> answers8 = new ArrayList<>(Arrays.asList("","","","","",""));
    ArrayList<String> answers9 = new ArrayList<>(Arrays.asList("","","","","",""));
    ArrayList<String> answers10 = new ArrayList<>(Arrays.asList("","","","","",""));
    Random random = new Random();
    TextView questionText, endStatementText;
    Button[] options;
    Button playAgain, exit;
    ProgressBar progressBar;
    int count = 0, introvert = 0, extrovert = 0, antisocial = 0, psychopath = 0, sociopath = 0,
            amb = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        options = new Button[]{(Button)findViewById(R.id.option7), (Button)findViewById(R.id.option2), (Button)findViewById(R.id.option3),
                (Button)findViewById(R.id.option4), (Button)findViewById(R.id.option5), (Button)findViewById(R.id.option6)};
        for(int i = 0; i < 6; i++){
            options[i].setOnClickListener(this::onClick);
        }
        playAgain = findViewById(R.id.playAgain);
        playAgain.setOnClickListener(this::onClick);
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(this::onClick);
        questionText = findViewById(R.id.questionText);
        endStatementText = findViewById(R.id.endStatement);
            if (count == 0) {
                playAgain.setVisibility(View.INVISIBLE);
                exit.setVisibility(View.INVISIBLE);
                endStatementText.setText("");
                questionText.setText(questions[count]);
                for (int i = 0; i < 6; i++) {
                    options[i].setText(answers1.remove(random.nextInt(answers1.size())).substring(1));
                }
            }

    }
    @Override
    public void onClick(View view){
        count++;
        start();
        Button pressedButton = (Button) view;
        if(pressedButton.getId() == R.id.playAgain){
            reset();
        }
        if(pressedButton.getId() == R.id.exit){
            System.exit(0);
        }
        String ourString = pressedButton.getText().toString().substring(0,1);
        if(ourString == "1"){introvert++;}
        else if(ourString == "2"){extrovert++;}
        else if(ourString == "3"){antisocial++;}
        else if(ourString == "4"){psychopath++;}
        else if(ourString == "5"){sociopath++;}
        else if(ourString == "6"){amb++;}
    }
    private void reset() {
        count = 0;
        introvert = 0;
        extrovert = 0;
        antisocial = 0;
        psychopath = 0;
        sociopath = 0;
        amb = 0;
    }

    private void start() {
        if (count == 1) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers1.remove(random.nextInt(answers2.size())));
            }
            return;
        }
        if (count == 2) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers1.remove(random.nextInt(answers3.size())));
            }
            return;

        }
        if (count == 3) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers1.remove(random.nextInt(answers4.size())));
            }
            return;

        }
        if (count == 4) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers1.remove(random.nextInt(answers5.size())));
            }
            return;

        }
        if (count == 5) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers1.remove(random.nextInt(answers6.size())));
            }
            return;

        }
        if (count == 6) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers1.remove(random.nextInt(answers7.size())));
            }
            return;

        }
        if (count == 7) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers1.remove(random.nextInt(answers8.size())));
            }
            return;

        }
        if (count == 8) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers1.remove(random.nextInt(answers9.size())));
            }
            return;

        }
        if (count == 9) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers1.remove(random.nextInt(answers10.size())));
            }
            return;

        }
        if(count > 9){
            playAgain.setVisibility(View.VISIBLE);
            exit.setVisibility(View.VISIBLE);
            questionText.setText("");
            return;
        }
    }
}
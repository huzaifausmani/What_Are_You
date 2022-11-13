package com.example.whatareyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] questions = {"1","2","3","4","5","6","7","8","9","10"},
    answers1 = {"1abc","","","","",""},
    answers2 = {"","","","","",""},
    answers3 = {"","","","","",""},
    answers4 = {"","","","","",""},
    answers5 = {"","","","","",""},
    answers6 = {"","","","","",""},
    answers7 = {"","","","","",""},
    answers8 = {"","","","","",""},
    answers9 = {"","","","","",""},
    answers10 = {"","","","","",""},
    endStatements = {"","","","","",""};
    TextView questionText, endStatementText;
    ProgressBar progressBar;
    int count = 0, introvert = 0, extrovert = 0, antisocial = 0, psychopath = 0, sociopath = 0,
            amb = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button[] options = {(Button)findViewById(R.id.option7), (Button)findViewById(R.id.option2), (Button)findViewById(R.id.option3),
                (Button)findViewById(R.id.option4), (Button)findViewById(R.id.option5), (Button)findViewById(R.id.option6)};
        for(int i = 0; i < 6; i++){
            options[i].setOnClickListener(this);
        }
        questionText = findViewById(R.id.questionText);
        endStatementText = findViewById(R.id.endStatement);
        progressBar = findViewById(R.id.progressBar);
        start();
        reset();

    }
    @Override
    public void onClick(View view){
        count++;
        Button pressedButton = (Button) view;
        String ourString = pressedButton.getText().toString().substring(0,1);
        if(ourString == "1"){introvert++;}
        else if(ourString == "2"){extrovert++;}
        else if(ourString == "3"){antisocial++;}
        else if(ourString == "4"){psychopath++;}
        else if(ourString == "5"){sociopath++;}
        else if(ourString == "6"){amb++;}
    }
    private void reset() {
    }

    private void start() {
        if(count == 0){
            endStatementText.setText("");
        }
    }
}
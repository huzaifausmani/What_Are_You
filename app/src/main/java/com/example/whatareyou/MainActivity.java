package com.example.whatareyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] questions = {"1","2","3","4","5","6","7","8","9","10"},
    answers1 = {"","","","","",""},
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
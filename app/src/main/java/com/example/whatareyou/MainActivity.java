package com.example.whatareyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] questions = {"1. You just entered a crowded party. Everyone is having conversations and stuff. What will you do?",
            "2. When someone you don't know tries to have a conversation with you, what do you do?",
            "3. Due to the recent pandemic, in quarantine life, what were your feelings?",
            "4. You usually get joy out of:",
            "5. You like people who:","6. You feel more yourself when you are:",
            "7. The people who know you are likely to describe you as: ",
            "8. You were invited by your friends to hang out with them on an outing, What's your response?",
            "9. If you are hurt/heavy hearted, what do you do?",
            "10. What is love?"};
    ArrayList<String> answers1 = new ArrayList<>(Arrays.asList(".Stand in a corner alone",",Talk with first person I see","Find my friends - avoid others","Try to plot a murder","Kill anyone who disturbs","Talk to anyone who seems fine~"));
    ArrayList<String> answers2 = new ArrayList<>(Arrays.asList(".Respond to them awkwardly",",Respond with energy and try to be friends","Try to avoid the person-","Try to take advantage of the person","Kill the person if annoying","Respond with energy~"));
    ArrayList<String> answers3 = new ArrayList<>(Arrays.asList(".Happy and comfortable",",Bored because lack of company","Happy to be left alone-","Try fun of suffering people","Oppose the quarantine","Adjust with the conditions~"));
    ArrayList<String> answers4 = new ArrayList<>(Arrays.asList(".Reading or Writing","Partying, Travelling with friends","Reading - Travelling alone","Hurt others","Get what you want by any means","Socializing~"));
    ArrayList<String> answers5 = new ArrayList<>(Arrays.asList(".Give a warm vibe",",Interact with you once","Give you space - share feelings","Are vulnerable and can be Hurt","Give you space and are vulnerable","Anyone who seems fine~"));
    ArrayList<String> answers6 = new ArrayList<>(Arrays.asList(".In your comfort zone",",Center of attention","Invisible to others-","Hurt someone","You get what you want","Being with your friends~"));
    ArrayList<String> answers7 = new ArrayList<>(Arrays.asList(".Quiet but friendly",",Talkative","Quiet - Reserved","Horrifying and scary","Scary when angered","Normal Person~"));
    ArrayList<String> answers8 = new ArrayList<>(Arrays.asList(".Accept and go (hesitantly)",",You were the planner","Try to ditch them-","Willing to spoil the outing","You don't have friends","Accept, go and enjoy~"));
    ArrayList<String> answers9 = new ArrayList<>(Arrays.asList(".Cry in a corner alone",",Try to vent with everyone","Only Vent to your Bestie-","Try to hurt others to feel good","Take revenge from the one responsible","Vent or just try to let it go~"));
    ArrayList<String> answers10 = new ArrayList<>(Arrays.asList(".An uncontrollable emotion",",Butterflies in the stomache","A warm - fuzzy emotion","Weakness","Baby don't hurt me","A controllable emotion~"));
    Random random = new Random();
    TextView questionText, endStatementText;
    Button[] options;
    Button exit;
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
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(this::onClick);
        questionText = findViewById(R.id.questionText);
        endStatementText = findViewById(R.id.endStatement);
            if (count == 0) {
                exit.setVisibility(View.INVISIBLE);
                endStatementText.setVisibility(View.INVISIBLE);
                questionText.setText(questions[count]);
                for (int i = 0; i < 6; i++) {
                    options[i].setText(answers1.remove(random.nextInt(answers1.size())));
                }
            }
    }
    @Override
    public void onClick(View view){
        count++;
        Button pressedButton = (Button) view;
        if(pressedButton.getId() == R.id.exit){
            System.exit(0);
        }
        String ourString = pressedButton.getText().toString().toLowerCase(Locale.ROOT);
        endStatementText.setText(ourString);
        if(ourString.contains(".")){introvert++;}
        else if(ourString.contains(",")){extrovert++;}
        else if(ourString.contains("-")){antisocial++;}
        else if(ourString.contains("try") || ourString.contains("hurt")|| ourString.contains("scary")|| ourString.contains("spoil")|| ourString.contains("weakness")){psychopath++;}
        else if(ourString.contains("get what you want") || ourString.contains("kill") || ourString.contains("oppose") || ourString.contains("and are vulnerable") || ourString.contains("revenge") || ourString.contains("You don't have friends")){sociopath++;}
        else if(ourString.contains("~")){amb++;}
        start();
    }
/*
    private void reset() {
        count = 0;
        introvert = 0;
        extrovert = 0;
        antisocial = 0;
        psychopath = 0;
        sociopath = 0;
        amb = 0;
        String[] questions = {"1. You just entered a crowded party. Everyone is having conversations and stuff. What will you do?",
                "2. When someone you don't know tries to have a conversation with you, what do you do?",
                "3. Due to the recent pandemic, in quarantine life, what were your feelings?",
                "4. You usually get joy out of:",
                "5. You like people who:","6. You feel more yourself when you are:",
                "7. The people who know you are likely to describe you as: ",
                "8. You were invited by your friends to hang out with them on an outing, What's your response?",
                "9. If you are hurt/heavy hearted, what do you do?",
                "10. What is love?"};
        ArrayList<String> answers1 = new ArrayList<>(Arrays.asList("1Stand in a corner alone","2Talk with first person I see","3Find my friends, avoid others","4Try to plot a murder","5Kill anyone who disturbs","6Talk to anyone who seems fine"));
        ArrayList<String> answers2 = new ArrayList<>(Arrays.asList("1Respond to them awkwardly","2Respond with energy and try to be friends","3Try to avoid the person","4Try to take advantage of the person","5Kill the person if annoying","6Respond with energy"));
        ArrayList<String> answers3 = new ArrayList<>(Arrays.asList("1Happy and comfortable","2Bored because lack of company","3Happy to be left alone","4Make fun of suffering people","5Try to oppose the quarantine","6Adjust with the conditions"));
        ArrayList<String> answers4 = new ArrayList<>(Arrays.asList("1Reading, Writing","2Partying, Travelling with friends","3Reading, Travelling alone","4Harming others","5Getting what you want by any means","6Socializing"));
        ArrayList<String> answers5 = new ArrayList<>(Arrays.asList("1Give a warm vibe","2Interact with you once","3Give you space and share feelings","4Are vulnerable and can be hurt","5Give you space and are vulnerable","6Anyone who seems fine"));
        ArrayList<String> answers6 = new ArrayList<>(Arrays.asList("1In your comfort zone","2Center of attention","3Invisible to others","4Hurting someone","5You get what you wanted","6Being with your friends"));
        ArrayList<String> answers7 = new ArrayList<>(Arrays.asList("1Quiet but friendly","2Talkative","3Quiet and Reserved","4Horrifying and scary","5Scary when angered","6Normal Person"));
        ArrayList<String> answers8 = new ArrayList<>(Arrays.asList("1Accept and go (hesitantly)","2You were the planner","3Try to ditch them","4Try to spoil the outing","5You don't have friends","6Accept, go and enjoy"));
        ArrayList<String> answers9 = new ArrayList<>(Arrays.asList("1Cry in a corner alone","2Try to vent with everyone","3Vent to your Bestie","4Try to hurt others to feel good","5Take revenge from one who hurt you","6Vent or just try to let it go"));
        ArrayList<String> answers10 = new ArrayList<>(Arrays.asList("1An uncontrollable emotion","2Butterflies in the stomache","3A warm and fuzzy emotion","4Weakness","5Baby don't hurt me","6A controllable emotion"));

    }
*/

    private void start() {
        if(count == 0){return;}
        if (count == 1) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers2.remove(random.nextInt(answers2.size())));
            }
            return;
        }
        if (count == 2) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers3.remove(random.nextInt(answers3.size())));
            }
            return;

        }
        if (count == 3) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers4.remove(random.nextInt(answers4.size())));
            }
            return;

        }
        if (count == 4) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers5.remove(random.nextInt(answers5.size())));
            }
            return;

        }
        if (count == 5) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers6.remove(random.nextInt(answers6.size())));
            }
            return;

        }
        if (count == 6) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers7.remove(random.nextInt(answers7.size())));
            }
            return;

        }
        if (count == 7) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers8.remove(random.nextInt(answers8.size())));
            }
            return;

        }
        if (count == 8) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers9.remove(random.nextInt(answers9.size())));
            }
            return;

        }
        if (count == 9) {
            questionText.setText(questions[count]);
            for (int i = 0; i < 6; i++) {
                options[i].setText(answers10.remove(random.nextInt(answers10.size())));
            }
            return;

        }
        if(count > 9){
            exit.setVisibility(View.VISIBLE);
            questionText.setText("");
            endStatementText.setVisibility(View.VISIBLE);
            for (int i = 0; i < options.length; i++) {
                options[i].setVisibility(View.INVISIBLE);
            }
            if(introvert > extrovert && introvert > amb && introvert > antisocial && introvert > psychopath && introvert > sociopath){
                endStatementText.setText("You are an Introvert !");
            }
            else if(extrovert > introvert && extrovert > amb && extrovert > antisocial && extrovert > psychopath && extrovert > sociopath){
                endStatementText.setText("You are an Extrovert !");
            }
            else if(antisocial > extrovert && antisocial > amb && antisocial > introvert && antisocial > psychopath && antisocial > sociopath){
                endStatementText.setText("You are an Anti-Social Person !");
            }
            else if(psychopath > extrovert && psychopath > amb && psychopath > antisocial && psychopath > introvert && psychopath > sociopath){
                endStatementText.setText("You are a Psychopath !");
            }
            else if(sociopath > extrovert && sociopath > amb && sociopath > antisocial && sociopath > psychopath && sociopath > introvert){
                endStatementText.setText("You are a Sociopath !");
            }
            else if(amb > extrovert && amb > introvert && amb > antisocial && amb > psychopath && amb > sociopath){
                endStatementText.setText("You are an Ambivert(Introvert + Extrovert) !");
            }
            else{
                endStatementText.setText("You are a Rare Personality, we are unable to depict you !");
            }
            return;
        }
    }
}
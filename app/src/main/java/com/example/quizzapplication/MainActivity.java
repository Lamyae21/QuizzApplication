package com.example.quizzapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizzapplication.answerclass;

public class MainActivity extends AppCompatActivity {
    private TextView optionA,optionB,optionC,optionD ;
    private  TextView questionnumber,score,question;
    private TextView checkout1,checkout2;
    int currentIndex;
    int mscore=0;
    int qn=1;
    ProgressBar progressBar;
    int CurrentQuestion,CurrentOptionA,CurrentOptionB,CurrentOptionC,CurrentOptionD;

    private answerclass[] questionBank = new answerclass[]
            {
                    new answerclass(R.string.question1,R.string.question1_A,R.string.question1_B,R.string.question1_c,R.string.question1_D,R.string.answer1),
                    new answerclass(R.string.question2,R.string.question2_A,R.string.question2_B,R.string.question2_c,R.string.question2_D,R.string.answer2),
                    new answerclass(R.string.question3,R.string.question3_A,R.string.question3_B,R.string.question3_c,R.string.question3_D,R.string.answer3),
                    new answerclass(R.string.question4,R.string.question4_A,R.string.question4_B,R.string.question4_c,R.string.question4_D,R.string.answer4),
                    new answerclass(R.string.question5,R.string.question5_A,R.string.question5_B,R.string.question5_c,R.string.question5_D,R.string.answer5),
                    new answerclass(R.string.question6,R.string.question6_A,R.string.question6_B,R.string.question6_c,R.string.question6_D,R.string.answer6),
                    new answerclass(R.string.question7,R.string.question7_A,R.string.question7_B,R.string.question7_c,R.string.question7_D,R.string.answer7),
                    new answerclass(R.string.question8,R.string.question8_A,R.string.question8_B,R.string.question8_c,R.string.question8_D,R.string.answer8),




            };
    final int PROGRESS= (int) Math.ceil(100/questionBank.length);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        optionA=findViewById(R.id.optionA);
        optionB=findViewById(R.id.optionB);
        optionC=findViewById(R.id.optionC);
        optionD=findViewById(R.id.optionD);

        question = findViewById(R.id.question);
        score=findViewById(R.id.score);
        questionnumber=findViewById(R.id.questionnumber);
        checkout1=findViewById(R.id.selectoption);
        checkout2=findViewById(R.id.correctanswer);
        progressBar=findViewById(R.id.progressbar);



       /* CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);
        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);

        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);

        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);

        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);*/

        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionA);
                updateQuestion();



            }
        });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionB);
                updateQuestion();
            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionC);
                updateQuestion();
            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(CurrentOptionD);
                updateQuestion();
            }
        });








    }

    private void updateQuestion() {
        currentIndex=(currentIndex+1)%questionBank.length;
        if(currentIndex==0){
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your score"+mscore+"points");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mscore=0;
                    qn=1;
                    progressBar.setProgress(0);
                    score.setText("Score"+mscore+"/"+questionBank.length );
                    questionnumber.setText(qn + "/" + questionBank.length+"Question");
                }
            });

            alert.show();
        }


        CurrentQuestion=questionBank[currentIndex].getQuestionid();
        question.setText(CurrentQuestion);

        CurrentOptionA=questionBank[currentIndex].getOptionA();
        optionA.setText(CurrentOptionA);

        CurrentOptionB=questionBank[currentIndex].getOptionB();
        optionB.setText(CurrentOptionB);

        CurrentOptionC=questionBank[currentIndex].getOptionC();
        optionC.setText(CurrentOptionC);

        CurrentOptionD=questionBank[currentIndex].getOptionD();
        optionD.setText(CurrentOptionD);

        qn=qn+1;
        if(qn<=questionBank.length){
            questionnumber.setText(qn + "/" + questionBank.length+"Question");
        }
        score.setText("Score"+mscore+"/"+questionBank.length );
        progressBar.incrementProgressBy(PROGRESS);
    }

    private void checkAnswer(int userSelection) {
        int correctanswer=questionBank[currentIndex].getAnswerid();
        checkout1.setText(Integer.toString(userSelection));
        checkout2.setText(Integer.toString(correctanswer));
        String m =checkout1.getText().toString().trim();
        String n =checkout2.getText().toString().trim();
        if(m.equals(n)){
            Toast.makeText(getApplicationContext(), "Right!", Toast.LENGTH_SHORT).show();
            mscore=mscore+1;
        }
        else {
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
        }







    }
}

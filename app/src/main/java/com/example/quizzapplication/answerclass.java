package com.example.quizzapplication;

public class answerclass {
    private  int optionA,optionB,optionC,optionD,questionid,answerid;

    public answerclass(int optionA ,int optionB, int optionD,int optionC , int questionid , int qnswerid ) {
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answerid = answerid;
        this.questionid = questionid;
    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionid() {
        return questionid;
    }

    public int getAnswerid() {
        return answerid;
    }

    public int getOptionC() {
        return optionC;
    }
}


package com.is2all.as2ila_jawab;

/**
 * Created by andr on 16/08/2017.
 */

public class item {

    public int ID;
    public String Question;
    public String Answer_1;
    public String Answer_2;
    public String Answer_3;
    public String Answer_4;
    public int ID_answer;

    public item(int ID, String question, String answer_1, String answer_2, String answer_3, String answer_4, int ID_answer) {
        this.ID = ID;
        Question = question;
        Answer_1 = answer_1;
        Answer_2 = answer_2;
        Answer_3 = answer_3;
        Answer_4 = answer_4;
        this.ID_answer = ID_answer;
    }
}

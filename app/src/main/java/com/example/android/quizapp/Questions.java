package com.example.android.quizapp;

public class Questions {

    public int questionNo = 13;
    public int optionNo = 3;
    public String[][] option = new String[questionNo][optionNo];
    public int[] answers = new int[questionNo];


    public Questions(){
        //Options
        option[0][0] = "Lord of Rings";
        option[0][1] = "Star Wars";
        option[0][2] = "The Hobbit";

        option[1][0] = "The Matrix";
        option[1][1] = "Star Wars";
        option[1][2] = "Back To The Future";

        option[2][0] = "The Matrix";
        option[2][1] = "E.T";
        option[2][2] = "Back to the Future";

        option[3][0] = "Harry Potter";
        option[3][1] = "Now You See Me";
        option[3][2] = "The Sorcerer's Apprentice";

        option[4][0] = "GhostBusters";
        option[4][1] = "John Wick";
        option[4][2] = "The Matrix";

        option[5][0] = "Interstellar";
        option[5][1] = "Star Wars";
        option[5][2] = "The Martian";

        option[6][0] = "Surrogates";
        option[6][1] = "Mad Max";
        option[6][2] = "Sin City";

        option[7][0]="GoodFellas";
        option[7][1]="Scar Face";
        option[7][2]="The GodFather";

        option[8][0]="";
        option[8][1]="";
        option[8][2]="";

        option[9][0]="";
        option[9][1]="";
        option[9][2]="";

        option[10][0]="";
        option[10][1]="";
        option[10][2]="";


    }
}

package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.yildi.quizApp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioButton[] radioButtons;
    RadioGroup radioGroup;
    Button button;
    ArrayList trueOption;
    Questions questions;
    ImageView imageView;
    CheckBox[] checkBoxes;
    TextView textView, questionTextView;
    RadioButton selectedButton;
    LinearLayout linearLayout;
    String answer;
    int questionNo = 0;
    int correctNo = 0;
    int selectedButtonId;
    EditText editText;
    int wrongNumber = 0;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxes = new CheckBox[3];
        trueOption = new ArrayList();
        radioButtons = new RadioButton[3];
        questions = new Questions();
        questionTextView = findViewById(R.id.question1);
        imageView = new ImageView(this);
        button = new Button(this);
        button = findViewById(R.id.buttonOne);
        relativeLayout = findViewById(R.id.relative);
        textView = findViewById(R.id.finalText);
        linearLayout = findViewById(R.id.checkboxLayout);
        editText = findViewById(R.id.textAnswer);

        checkBoxes[0] = findViewById(R.id.checkbox1);
        checkBoxes[1] = findViewById(R.id.checkbox2);
        checkBoxes[2] = findViewById(R.id.checkbox3);


        radioGroup = findViewById(R.id.radioGroup1);

        radioButtons[0] = findViewById(R.id.radioButton1);
        radioButtons[1] = findViewById(R.id.radioButton2);
        radioButtons[2] = findViewById(R.id.radioButton3);

        questions.answers[0] = radioButtons[0].getId();
        questions.answers[1] = radioButtons[2].getId();
        questions.answers[2] = radioButtons[1].getId();
        questions.answers[3] = radioButtons[0].getId();
        questions.answers[4] = radioButtons[2].getId();
        questions.answers[5] = radioButtons[1].getId();
        questions.answers[6] = radioButtons[1].getId();
        questions.answers[7] = radioButtons[2].getId();
        questions.answers[8] = radioButtons[2].getId();


        button = findViewById(R.id.buttonOne);

        imageView = findViewById(R.id.image);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.thelordoftherings));
    }

    public void controller(View v) {
        selectedButtonId = radioGroup.getCheckedRadioButtonId();
        selectedButton = findViewById(selectedButtonId);
    }

    public void TrueFalse(View v) {
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setText(questions.option[questionNo][i]);
        }

        if (questionNo == 7) {
            answer = editText.getText().toString().toLowerCase();
            if (answer.contains(questions.option[7][2].toLowerCase())) {
                Toast.makeText(this, getText(R.string.true_option), Toast.LENGTH_SHORT).show();
                questionNo++;
                correctNo++;
            } else {
                Toast.makeText(this, R.string.false_option, Toast.LENGTH_SHORT).show();
                wrongNumber++;
                questionNo++;
            }
        }
        else if (questionNo == 8) {
            if (checkBoxes[0].isChecked() && checkBoxes[2].isChecked()) {
                questionNo++;
                Toast.makeText(this,getText(R.string.true_option)+" "+getText(R.string.final_message) +" "+ correctNo +" "+getText(R.string.total_wrong) +" "+ wrongNumber, Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this,getText(R.string.false_option)+" "+getText(R.string.final_message) +" "+ correctNo + " "+getText(R.string.total_wrong) +" "+ wrongNumber, Toast.LENGTH_LONG).show();
                wrongNumber++;
                questionNo++;}
        }
        else {
            if (questionNo != questions.questionNo - 1) {
                if (selectedButtonId == 0) {
                    Toast.makeText(this,getText(R.string.empty), Toast.LENGTH_SHORT).show();
                } else if (questions.answers[questionNo] == selectedButtonId) {
                    Toast.makeText(this, getText(R.string.true_option), Toast.LENGTH_SHORT).show();
                    correctNo++;
                    questionNo++;
                } else if (!(questions.answers[questionNo] == selectedButtonId)) {

                    Toast.makeText(this,getText(R.string.false_option), Toast.LENGTH_SHORT).show();
                    wrongNumber++;
                    questionNo++;
                }

            }
        }
        switch (questionNo) {
            case 1:

                imageView.setImageDrawable(getResources().getDrawable(R.drawable.backtofuture));
                break;
            case 2:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.e_t));
                break;
            case 3:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.harrypotter));
                break;
            case 4:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.matrix));
                break;
            case 5:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.starwars));
                break;
            case 6:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.madmax));
                break;
            case 7:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.thegodfather));
                radioGroup.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                break;
            case 8:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.blade_runner));
                editText.setVisibility(View.GONE);
                questionTextView.setText(R.string.final_question);
                radioGroup.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                break;
        }
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setText(questions.option[questionNo][i]);
        }
    }
}


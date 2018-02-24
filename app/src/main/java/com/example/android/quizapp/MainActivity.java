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

import com.example.yildi.quizApp.Questions;
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
    TextView textView, questionTextView, feedbackTextView;
    RadioButton selectedButton;
    LinearLayout linearLayout;
    String message, answer;
    int questionNo = 0;
    int correctNo = 0;
    int selectedButtonId;
    EditText editText;
    int wrongNumber = 0;
    boolean go = false;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxes = new CheckBox[4];
        trueOption = new ArrayList();
        radioButtons = new RadioButton[3];
        questions = new Questions();
        questionTextView = findViewById(R.id.question1);
        imageView = new ImageView(this);
        button = new Button(this);
        button = findViewById(R.id.buttonOne);
        relativeLayout = findViewById(R.id.relative);
        textView = findViewById(R.id.finalText);
        feedbackTextView = findViewById(R.id.feedback_question);
        linearLayout = findViewById(R.id.checkboxLayout);
        editText = findViewById(R.id.textAnswer);


        checkBoxes[0] = findViewById(R.id.checkbox1);
        checkBoxes[1] = findViewById(R.id.checkbox2);
        checkBoxes[2] = findViewById(R.id.checkbox3);
        checkBoxes[3] = findViewById(R.id.checkbox4);


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
        boolean checked = ((RadioButton) v).isChecked();
        selectedButtonId = radioGroup.getCheckedRadioButtonId();
        selectedButton = findViewById(selectedButtonId);
//        switch (v.getId()) {
//            case R.id.radioButton1:
//                break;
//
//            case R.id.radioButton2:
//                break;
//
//            case R.id.radioButton3:
//                break;
//
//        }
    }

    public void TrueFalse(View v) {
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setText(questions.option[questionNo][i]);
        }

        if (questionNo == 7) {
            answer = editText.getText().toString();
            if (answer.contains(questions.option[7][2])) {
                Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
                questionNo++;
                correctNo++;
            } else {
                Toast.makeText(this, "False.Just Try Again!", Toast.LENGTH_SHORT).show();
                wrongNumber++;
            }
        }
        else if (questionNo == 8) {
            if (checkBoxes[0].isChecked() || checkBoxes[1].isChecked() || checkBoxes[2].isChecked() || checkBoxes[3].isChecked()) {
                questionNo++;
            }
        }
        else {
            if (questionNo != questions.questionNo - 1) {
                if (selectedButtonId == 0) {
                    Toast.makeText(this, "Pls Select One of these ", Toast.LENGTH_SHORT).show();
                } else if (questions.answers[questionNo] == selectedButtonId) {
                    Toast.makeText(this, "True.Go on!!", Toast.LENGTH_SHORT).show();
                    correctNo++;
                    questionNo++;
                } else if (!(questions.answers[questionNo] == selectedButtonId)) {
                    Toast.makeText(this, "False.Just Try Again!", Toast.LENGTH_SHORT).show();
                    wrongNumber++;
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
                editText.setVisibility(View.GONE);
                questionTextView.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                radioGroup.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                feedbackTextView.setVisibility(View.VISIBLE);
                break;

            case 9:
                textView.setText("Good Work. You Finished All Quiz Your Total Corrects " + correctNo + " Your Total Wrong " + wrongNumber);
                break;
        }


        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setText(questions.option[questionNo][i]);
        }
    }
}


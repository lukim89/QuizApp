package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int numberOfQuestions = 9;
    int numberOfNotAnsweredQuestions = numberOfQuestions;
    CheckBox answer_1_1, answer_1_2, answer_1_3, answer_1_4;
    CheckBox answer_5_1, answer_5_2, answer_5_3, answer_5_4;
    CheckBox answer_9_1, answer_9_2, answer_9_3, answer_9_4;
    RadioButton answer_2_1, answer_3_2, answer_6_3, answer_7_4, answer_8_1;
    RadioGroup radioGroup_2, radioGroup_3, radioGroup_6, radioGroup_7, radioGroup_8;
    EditText answer_4;
    ScrollView scroll_view;
    int answer_4int, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scroll_view = findViewById(R.id.scroll_view);

        answer_1_1 = findViewById(R.id.answer_1_1);
        answer_1_2 = findViewById(R.id.answer_1_2);
        answer_1_3 = findViewById(R.id.answer_1_3);
        answer_1_4 = findViewById(R.id.answer_1_4);

        radioGroup_2 = findViewById(R.id.radioGroup_2);
        answer_2_1 = findViewById(R.id.answer_2_1);

        radioGroup_3 = findViewById(R.id.radioGroup_3);
        answer_3_2 = findViewById(R.id.answer_3_2);

        answer_4 = findViewById(R.id.answer_4);

        answer_5_1 = findViewById(R.id.answer_5_1);
        answer_5_2 = findViewById(R.id.answer_5_2);
        answer_5_3 = findViewById(R.id.answer_5_3);
        answer_5_4 = findViewById(R.id.answer_5_4);

        radioGroup_6 = findViewById(R.id.radioGroup_6);
        answer_6_3 = findViewById(R.id.answer_6_3);

        radioGroup_7 = findViewById(R.id.radioGroup_7);
        answer_7_4 = findViewById(R.id.answer_7_4);

        radioGroup_8 = findViewById(R.id.radioGroup_8);
        answer_8_1 = findViewById(R.id.answer_8_1);

        answer_9_1 = findViewById(R.id.answer_9_1);
        answer_9_2 = findViewById(R.id.answer_9_2);
        answer_9_3 = findViewById(R.id.answer_9_3);
        answer_9_4 = findViewById(R.id.answer_9_4);
    }

    public void questionCheck1() {
        if (answer_1_1.isChecked() || answer_1_2.isChecked() || answer_1_3.isChecked() || answer_1_4.isChecked())
            numberOfNotAnsweredQuestions--;
        if (answer_1_1.isChecked() && answer_1_2.isChecked() && !answer_1_3.isChecked() && answer_1_4.isChecked())
            score++;
    }

    public void questionCheck2() {
        if (!(radioGroup_2.getCheckedRadioButtonId() == -1)) {
            numberOfNotAnsweredQuestions--;
            if (answer_2_1.isChecked())
                score++;
        }
    }

    public void questionCheck3() {
        if (!(radioGroup_3.getCheckedRadioButtonId() == -1)) {
            numberOfNotAnsweredQuestions--;
            if (answer_3_2.isChecked())
                score++;
        }
    }

    public void questionCheck4() {
        boolean hasValue = !answer_4.getText().toString().trim().isEmpty();
        if (hasValue) {
            numberOfNotAnsweredQuestions--;
            answer_4int = Integer.parseInt(answer_4.getText().toString());
            if (answer_4int > 36 && answer_4int < 40)
                score++;
        }
    }

    public void questionCheck5() {
        if (answer_5_1.isChecked() || answer_5_2.isChecked() || answer_5_3.isChecked() || answer_5_4.isChecked())
            numberOfNotAnsweredQuestions--;
        if (!answer_5_1.isChecked() && answer_5_2.isChecked() && !answer_5_3.isChecked() && answer_5_4.isChecked())
            score++;
    }

    public void questionCheck6() {
        if (!(radioGroup_6.getCheckedRadioButtonId() == -1)) {
            numberOfNotAnsweredQuestions--;
            if (answer_6_3.isChecked())
                score++;
        }
    }

    public void questionCheck7() {
        if (!(radioGroup_7.getCheckedRadioButtonId() == -1)) {
            numberOfNotAnsweredQuestions--;
            if (answer_7_4.isChecked())
                score++;
        }
    }

    public void questionCheck8() {
        if (!(radioGroup_8.getCheckedRadioButtonId() == -1)) {
            numberOfNotAnsweredQuestions--;
            if (answer_8_1.isChecked())
                score++;
        }
    }

    public void questionCheck9() {
        if (answer_9_1.isChecked() || answer_9_2.isChecked() || answer_9_3.isChecked() || answer_9_4.isChecked())
            numberOfNotAnsweredQuestions--;
        if (answer_9_1.isChecked() && answer_9_2.isChecked() && !answer_9_3.isChecked() && answer_9_4.isChecked())
            score++;
    }

    public void clearRadioAnswers() {
        radioGroup_2.clearCheck();
        radioGroup_3.clearCheck();
        radioGroup_6.clearCheck();
        radioGroup_7.clearCheck();
        radioGroup_8.clearCheck();
    }

    public void clearCheckBoxAnswers() {
        answer_1_1.setChecked(false);
        answer_1_2.setChecked(false);
        answer_1_3.setChecked(false);
        answer_1_4.setChecked(false);
        answer_5_1.setChecked(false);
        answer_5_2.setChecked(false);
        answer_5_3.setChecked(false);
        answer_5_4.setChecked(false);
        answer_9_1.setChecked(false);
        answer_9_2.setChecked(false);
        answer_9_3.setChecked(false);
        answer_9_4.setChecked(false);
    }

    public void clearEditTextAnswer() {
        answer_4.setText(null);
        answer_4.clearFocus();
    }

    public void check(View view) {
        score = 0;
        numberOfNotAnsweredQuestions = numberOfQuestions;
        questionCheck1();
        questionCheck2();
        questionCheck3();
        questionCheck4();
        questionCheck5();
        questionCheck6();
        questionCheck7();
        questionCheck8();
        questionCheck9();

        if (numberOfNotAnsweredQuestions == 0) {
            Toast.makeText(this, "Yours score is " + score + "/9", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "First answer all the questions.", Toast.LENGTH_SHORT).show();
    }

    public void reset(View view) {
        clearEditTextAnswer();
        clearRadioAnswers();
        clearCheckBoxAnswers();
        scroll_view.fullScroll(ScrollView.FOCUS_UP);
    }
}
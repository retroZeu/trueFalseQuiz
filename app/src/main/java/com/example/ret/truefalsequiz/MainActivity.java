package com.example.ret.truefalsequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**  instance variable  **/
    private List<Question> qArray;
    private int currentIndex;

    private Button trueButton, falseButton, nextButton;
    private TextView questionText;



    /**  CONSTRUCTOR  **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
        initQArray();
        currentIndex = 0;
        setQuestionText(currentIndex);
    }

    public void initQArray() {
        qArray = new ArrayList<>();
        qArray.add(new Question(getString(R.string.q1), true));
        qArray.add(new Question(getString(R.string.q2), false));
    }

    public void wireWidgets() {
        questionText = (TextView) findViewById(R.id.text_question);
        trueButton = (Button) findViewById(R.id.button_true);
        falseButton = (Button) findViewById(R.id.button_false);
        nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setEnabled(false);
    }

    public void setListeners() {
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }



    /**  METHODS  **/
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_true:
                ableButtons();
                answer(true, currentIndex);
                break;
            case R.id.button_false:
                ableButtons();
                answer(false, currentIndex);
                break;
            case R.id.button_next:
                ableButtons();
                currentIndex++;
                setQuestionText(currentIndex);
        }
    }

    public void setQuestionText(int index) {
        questionText.setText(qArray.get(index).getQuestion());
    }

    public void ableButtons() {
        if (trueButton.isEnabled()) {trueButton.setEnabled(false); falseButton.setEnabled(false); nextButton.setEnabled(true);}
        else {trueButton.setEnabled(true); falseButton.setEnabled(true); nextButton.setEnabled(false);}
    }

    public void answer(boolean ansGiven, int num) {
        if (qArray.get(num).check(ansGiven)) {
            Toast.makeText(this, "Correct, mate!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Incorrect, mate!", Toast.LENGTH_SHORT).show();
        }
    }
}

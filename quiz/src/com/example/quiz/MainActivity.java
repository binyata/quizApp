package com.example.quiz;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private int currentQuestion;
	private String [] questions;
	private String [] answers;
	
	private Button answerButton;
	private Button questionButton;
	private TextView questionView;
	private TextView answerView;
	private EditText answerText;
	
	
public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		showQuestion();
	}
	
	public void init()
	{
		
		questions = new String[]{"What school do you go to?",
				"What is the best programming language to learn?"};
		answers = new String[]{"BYUI", "java"};
		currentQuestion = -1;
		answerButton = (Button)findViewById(R.id.AnswerButton);
		questionButton = (Button)findViewById(R.id.QuestionButton);
		questionView = (TextView)findViewById(R.id.QuestionTextView);
		answerView = (TextView)findViewById(R.id.AnswerTextView);
		answerText = (EditText)findViewById(R.id.AnswerText);
		answerButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				checkAnswer();
			}
		});
	
		questionButton.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v){
				showQuestion();
			}
		});
		
		
	}
	
	public void showQuestion()
	{
		
		currentQuestion++;
		if(currentQuestion == questions.length)
			currentQuestion = 0;
		
		questionView.setText(questions[currentQuestion]);
		answerView.setText("");
		answerText.setText("");
	}
	
	
	public boolean isCorrect(String answer)
	{
		return (answer.equalsIgnoreCase(answers[currentQuestion]));
	}
	
	
	public void checkAnswer()
	{
		
		String answer = answerText.getText().toString();
		if(isCorrect(answer))
			answerView.setText("You're right!");
		else
			answerView.setText("Sorry, the correct answer is "+answers[currentQuestion]);
		
	}
	
	

	
}
	

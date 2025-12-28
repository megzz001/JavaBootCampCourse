package Quiz_Application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
//Timer for the quiz
public class TimerPanel extends Framework implements ActionListener {
	Timer timer = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		seconds--;// Update the timer display
		seconds_left.setText(String.valueOf(seconds));
		// If time is up, display the answer
		if(seconds<=0) {	
		displayAnswer();
		}
		}
		});
    // ActionPerformed method for button clicks
	@Override
	public void actionPerformed(ActionEvent e) {
	// Disable buttons to prevent multiple clicks
	buttonA.setEnabled(false);
	buttonB.setEnabled(false);
	buttonC.setEnabled(false);
	buttonD.setEnabled(false);
	

    // Determine which button was clicked and update the answer
	if(e.getSource()==buttonA) {
	answer= 'A';
	if(answer == answers[index]) {
	// Update correct guesses if the answer is correct
	correct_guesses++;
	}
	}
	if(e.getSource()==buttonB) {
	answer= 'B';
	if(answer == answers[index]) {
    // Update correct guesses if the answer is correct
	correct_guesses++;
	}
	}
	if(e.getSource()==buttonC) {
	answer= 'C';
	if(answer == answers[index]) {
    // Update correct guesses if the answer is correct
	correct_guesses++;
	}
	}
	if(e.getSource()==buttonD) {
	answer= 'D';
	if(answer == answers[index]) {
	// Update correct guesses if the answer is correct		
	correct_guesses++;
	}
	}
	// Display the answer and move to the next question
	displayAnswer();
	}
	 // Implement logic to display the next question
	public void nextQuestion() {
		// Check if all questions have been answered
		if(index>=total_questions) {
	    // Display the results
		results();
		}
		else {
		// Display the current question
		textfield.setText("Question "+(index+1));
		textarea.setText(questions[index]);
		answer_labelA.setText(options[index][0]);
		answer_labelB.setText(options[index][1]);
		answer_labelC.setText(options[index][2]);
		answer_labelD.setText(options[index][3]);
		// Start the timer for the current question
		timer.start();
		}
		}
	// Implement logic to display results and handle the transition to the next question
	public void displayAnswer() {
		// Stop the timer
		timer.stop();
		 // Disable buttons
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		// Highlight the correct answer for all other options 
		if(answers[index] != 'A')
		answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
		answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
		answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
		answer_labelD.setForeground(new Color(255,0,0));
		// Create a pause timer to wait before moving to the next question
		Timer pause = new Timer(2000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		// Reset the colors
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelD.setForeground(new Color(25,255,0));
		// Reset variables and enable buttons for the next question
		answer = ' ';
		seconds=10;
		seconds_left.setText(String.valueOf(seconds));
		buttonA.setEnabled(true);
		buttonB.setEnabled(true);
		buttonC.setEnabled(true);
		buttonD.setEnabled(true);
		// Move to the next question
		index++;
		nextQuestion();
		}
		});
		// Start the pause timer
		pause.setRepeats(false);
		pause.start();
		}
	// Method to display the quiz results
	public void results(){
		// Disable all buttons
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		// Calculate the result percentage
		result = (int)((correct_guesses/(double)total_questions)*100);
		// Display the results
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		// Add result components to the frame
		frame.add(number_right);
		frame.add(percentage);
		}
}

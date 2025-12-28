package Quiz_Application;
import java.awt.*;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
import javax.swing.*;
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextArea;
//import javax.swing.JTextField
import java.awt.event.*;

public class Framework extends Questions{
// Variables to track user's choices and results
char guess; // User's guess
char answer; // Correct answer
int index; // Index of the current question
int correct_guesses = 0; // Number of correct answers
int total_questions = questions.length; // Total number of questions
int result; // Percentage of correct answers
int seconds = 10; // Initial timer_panel value

// JFrame components
//these are all the objects created to use in frame.
JFrame frame = new JFrame();
JTextField textfield = new JTextField();
JTextArea textarea = new JTextArea();
JButton buttonA = new JButton();
JButton buttonB = new JButton();
JButton buttonC = new JButton();
JButton buttonD = new JButton();
JLabel answer_labelA = new JLabel();
JLabel answer_labelB = new JLabel();
JLabel answer_labelC = new JLabel();
JLabel answer_labelD = new JLabel();
JLabel time_label = new JLabel();
JLabel seconds_left = new JLabel();
JTextField number_right = new JTextField();
JTextField percentage = new JTextField();
}

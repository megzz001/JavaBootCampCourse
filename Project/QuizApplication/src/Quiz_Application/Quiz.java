package Quiz_Application;
//---------------------------- Quiz ----------------------------
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz extends TimerPanel {
// Constructor to initialize the GUI
public Quiz() {
// Frame settings
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set up the main frame
frame.setSize(650,650);
frame.getContentPane().setBackground(new Color(63,30,20));
frame.setLayout(null);
frame.setResizable(false);
//Textfield settings
textfield.setBounds(0,0,650,50);
textfield.setBackground(new Color(25,25,25));
textfield.setForeground(new Color(25,255,0));
textfield.setFont(new Font("Ink Free",Font.BOLD,30));
textfield.setBorder(BorderFactory.createBevelBorder(1));//For Displaying Question no. on the UI.
textfield.setHorizontalAlignment(JTextField.CENTER);
textfield.setEditable(false);
// Textarea settings
textarea.setBounds(0,50,650,50);
textarea.setLineWrap(true);
textarea.setWrapStyleWord(true);
textarea.setBackground(new Color(25,25,25));
textarea.setForeground(new Color(25,255,0));// For Displaying Question on the UI
textarea.setFont(new Font("MV Boli",Font.BOLD,25));
textarea.setBorder(BorderFactory.createBevelBorder(1));
textarea.setEditable(false);
//Button settings (A, B, C, D)
buttonA.setBounds(0,100,100,100);
buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
buttonA.setFocusable(false);
buttonA.addActionListener(this);
buttonA.setText("A");

buttonB.setBounds(0,200,100,100);
buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
buttonB.setFocusable(false);
buttonB.addActionListener(this);
buttonB.setText("B");

buttonC.setBounds(0,300,100,100);
buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
buttonC.setFocusable(false);
buttonC.addActionListener(this);
buttonC.setText("C");

buttonD.setBounds(0,400,100,100);
buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
buttonD.setFocusable(false);
buttonD.addActionListener(this);
buttonD.setText("D");

//Answer label settings for each option
answer_labelA.setBounds(125,100,500,100);
answer_labelA.setBackground(new Color(50,50,50));
answer_labelA.setForeground(new Color(25,255,0));
answer_labelA.setFont(new Font("MV Boli",Font.PLAIN,35));

answer_labelB.setBounds(125,200,500,100);
answer_labelB.setBackground(new Color(50,50,50));
answer_labelB.setForeground(new Color(25,255,0));
answer_labelB.setFont(new Font("MV Boli",Font.PLAIN,35));

answer_labelC.setBounds(125,300,500,100);
answer_labelC.setBackground(new Color(50,50,50));
answer_labelC.setForeground(new Color(25,255,0));
answer_labelC.setFont(new Font("MV Boli",Font.PLAIN,35));

answer_labelD.setBounds(125,400,500,100);
answer_labelD.setBackground(new Color(50,50,50));
answer_labelD.setForeground(new Color(25,255,0));
answer_labelD.setFont(new Font("MV Boli",Font.PLAIN,35));

// Seconds left label settings
seconds_left.setBounds(535,510,100,100);
seconds_left.setBackground(new Color(25,25,25));
seconds_left.setForeground(new Color(255,0,0));
seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
seconds_left.setBorder(BorderFactory.createBevelBorder(1));
seconds_left.setOpaque(true);
seconds_left.setHorizontalAlignment(JTextField.CENTER);
seconds_left.setText(String.valueOf(seconds));
//Add settings for answer_labelB, answer_labelC, and answer_labelD here...

////Timer label settings
time_label.setBounds(535,475,100,25);
time_label.setBackground(new Color(50,50,50));
time_label.setForeground(new Color(255,0,0));
time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
time_label.setHorizontalAlignment(JTextField.CENTER);
time_label.setText("time ");

// Number right textfield settings
number_right.setBounds(225,225,200,100);
number_right.setBackground(new Color(25,25,25));
number_right.setForeground(new Color(25,255,0));
number_right.setFont(new Font("Ink Free",Font.BOLD,50));
number_right.setBorder(BorderFactory.createBevelBorder(1));
number_right.setHorizontalAlignment(JTextField.CENTER);
number_right.setEditable(false);

// Percentage textfield settings
percentage.setBounds(225,325,200,100);
percentage.setBackground(new Color(25,25,25));
percentage.setForeground(new Color(25,255,0));
percentage.setFont(new Font("Ink Free",Font.BOLD,50));
percentage.setBorder(BorderFactory.createBevelBorder(1));
percentage.setHorizontalAlignment(JTextField.CENTER);
percentage.setEditable(false);

// Add components to the frame
frame.add(time_label);
frame.add(seconds_left);
frame.add(answer_labelA);
frame.add(answer_labelB);
frame.add(answer_labelC);
frame.add(answer_labelD);
frame.add(buttonA);
frame.add(buttonB);
frame.add(buttonC);
frame.add(buttonD);
frame.add(textarea);
frame.add(textfield);
frame.setVisible(true);

// Start the quiz by displaying the first question
nextQuestion();
}

}
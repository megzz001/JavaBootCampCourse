package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rupee_Converter {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Rupee Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel rupeesLabel = new JLabel("Rupees:");
        JTextField rupeesTextField = new JTextField();

        JLabel dollarsLabel = new JLabel("Dollars:");
        JTextField dollarsTextField = new JTextField();

        JButton toDollarButton = new JButton("Convert to Dollar");
        JButton toRupeeButton = new JButton("Convert to Rupee");

        panel.add(rupeesLabel);
        panel.add(rupeesTextField);
        panel.add(dollarsLabel);
        panel.add(dollarsTextField);
        panel.add(toDollarButton);
        panel.add(toRupeeButton);

        toDollarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double rupees = Double.parseDouble(rupeesTextField.getText());
                    double dollars = rupees / 65.25; // Conversion rate assumed, you may adjust this
                    dollarsTextField.setText(String.format("%.2f", dollars));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                }
            }
        });

        toRupeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double dollars = Double.parseDouble(dollarsTextField.getText());
                    double rupees = dollars * 65.25; // Conversion rate assumed, you may adjust this
                    rupeesTextField.setText(String.format("%.2f", rupees));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                }
            }
        });

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}


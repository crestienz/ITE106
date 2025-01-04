import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private double num1, num2, result;
    private String operator;
    private ArrayList<String> history; // to store calculation history

    public Calculator() {
        history = new ArrayList<>(); // to initialize history list

        // for frame settings
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setResizable(false);
        setLayout(new BorderLayout());

        // for dark theme background
        getContentPane().setBackground(Color.BLACK);

        // for display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH);

        // for button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(Color.BLACK);

        // for buttons
        String[] buttons = {
            "C", "History", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "="
        };

        for (String text : buttons) {
            JButton button = createButton(text);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusPainted(false);
        button.setBackground(new Color(48, 48, 48)); // dark gray rgb color 
        button.setForeground(new Color(211, 211, 211)); // light gray rgb color
        button.setPreferredSize(new Dimension(80, 80)); // adjusted button size
        if (text.equals("C")) {
            button.setForeground(Color.RED); // Red color for 'C'
        } else if (text.equals("=")) {
            button.setBackground(new Color(128, 0, 128)); // purple rgb color for '='
            button.setForeground(Color.WHITE);
        }
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("\\d") || command.equals(".")) { // numbers and decimal
            display.setText(display.getText() + command);
        } else if (command.equals("C")) { // clear button
            display.setText("");
            num1 = num2 = result = 0;
            operator = "";
        } else if (command.equals("History")) { // to show calculation history
            showHistory();
        } else if (command.matches("[+\\-×÷]")) { // operators button
            num1 = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        } else if (command.equals("%")) { // percentage button
            num1 = Double.parseDouble(display.getText());
            result = num1 / 100;
            display.setText(String.valueOf(result));
            history.add(num1 + "% = " + result);
        } else if (command.equals("+/-")) { // for toggle sign
            if (!display.getText().isEmpty()) {
                double value = Double.parseDouble(display.getText());
                value = -value;
                display.setText(String.valueOf(value));
            }
        } else if (command.equals("=")) { // equals button
            num2 = Double.parseDouble(display.getText());
            calculate();
            String historyEntry = num1 + " " + operator + " " + num2 + " = " + result;
            history.add(historyEntry); // every new entered calculations will be added to history
            display.setText(String.valueOf(result));
        }
    }

    private void calculate() {
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "×":
                result = num1 * num2;
                break;
            case "÷":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Error");
                    result = 0;
                }
                break;
        }
    }
	// history panel 
    private void showHistory() {
        if (history.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No history available", "History", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder historyText = new StringBuilder("Calculation History:\n");
            for (String entry : history) {
                historyText.append(entry).append("\n");
            }
            JOptionPane.showMessageDialog(this, historyText.toString(), "History", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

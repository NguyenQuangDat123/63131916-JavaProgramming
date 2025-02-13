package Casio_Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class CasioCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String input = "";

    private final String[] buttonLabels = {
        "AC", "DEL", "(", ")",
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+"
    };

    public CasioCalculator() {
        setTitle("Máy Tính Casio");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("AC")) {
            input = "";
            display.setText("");
        } else if (command.equals("DEL")) {
            if (!input.isEmpty()) {
                input = input.substring(0, input.length() - 1);
                display.setText(input);
            }
        } else if (command.equals("=")) {
            try {
                double result = evaluate(input);
                display.setText(String.valueOf(result));
                input = String.valueOf(result);
            } catch (Exception ex) {
                display.setText("Lỗi!");
                input = "";
            }
        } else {
            input += command;
            display.setText(input);
        }
    }

    // Hàm xử lý phép tính toán học
    private double evaluate(String expression) {
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            Object result = engine.eval(expression);
            return Double.parseDouble(result.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        new CasioCalculator();
    }
}

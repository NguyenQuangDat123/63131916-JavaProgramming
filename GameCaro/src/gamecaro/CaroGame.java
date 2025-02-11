package gamecaro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaroGame extends JFrame {
    private static final int SIZE = 15;  // Kích thước bàn cờ 15x15
    private JButton[][] buttons;
    private char currentPlayer = 'X';
    private boolean gameOver = false;

    public CaroGame() {
        setTitle("Game Caro - 15x15");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(SIZE, SIZE));

        buttons = new JButton[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 20));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!gameOver && buttons[row][col].getText().equals("")) {
                buttons[row][col].setText(String.valueOf(currentPlayer));
                buttons[row][col].setEnabled(false);
                if (checkWin(row, col)) {
                    JOptionPane.showMessageDialog(null, "Người chơi " + currentPlayer + " thắng!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    JOptionPane.showMessageDialog(null, "Hòa!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    private boolean checkWin(int row, int col) {
        return checkDirection(row, col, 1, 0)  // Kiểm tra ngang
            || checkDirection(row, col, 0, 1)  // Kiểm tra dọc
            || checkDirection(row, col, 1, 1)  // Kiểm tra chéo chính
            || checkDirection(row, col, 1, -1); // Kiểm tra chéo phụ
    }

    private boolean checkDirection(int row, int col, int dRow, int dCol) {
        int count = 1;

        // Đếm về một phía
        for (int i = 1; i < 5; i++) {
            int newRow = row + i * dRow;
            int newCol = col + i * dCol;
            if (isValid(newRow, newCol) && buttons[newRow][newCol].getText().equals(String.valueOf(currentPlayer))) {
                count++;
            } else {
                break;
            }
        }

        // Đếm về phía ngược lại
        for (int i = 1; i < 5; i++) {
            int newRow = row - i * dRow;
            int newCol = col - i * dCol;
            if (isValid(newRow, newCol) && buttons[newRow][newCol].getText().equals(String.valueOf(currentPlayer))) {
                count++;
            } else {
                break;
            }
        }

        return count >= 5; // Cần đủ 5 ký tự liên tiếp
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CaroGame().setVisible(true));
    }
}

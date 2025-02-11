package chessgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessGame extends JFrame {
    private static final int SIZE = 8;
    private JButton[][] squares = new JButton[SIZE][SIZE];
    private String[][] board = new String[SIZE][SIZE];
    private String currentPlayer = "W";
    private JButton selectedButton = null;
    private int selectedRow = -1, selectedCol = -1;

    public ChessGame() {
        setTitle("Cờ Vua");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE));
        initializeBoard();
        initializeUI();
    }

    private void initializeBoard() {
        String[] backRow = {"R", "N", "B", "Q", "K", "B", "N", "R"};
        for (int i = 0; i < SIZE; i++) {
            board[0][i] = "B" + backRow[i];
            board[1][i] = "BP";
            board[6][i] = "WP";
            board[7][i] = "W" + backRow[i];
        }
    }

    private void initializeUI() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                squares[row][col] = new JButton();
                squares[row][col].setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                squares[row][col].setOpaque(true);
                squares[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                squares[row][col].setFocusPainted(false);
                String piece = board[row][col];
                if (piece != null) {
                    squares[row][col].setIcon(loadPieceImage(piece));
                }
                squares[row][col].addActionListener(new MoveListener(row, col));
                add(squares[row][col]);
            }
        }
    }

    private ImageIcon loadPieceImage(String piece) {
        String filePath = "images/" + piece + ".png";
        return new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
    }

    private class MoveListener implements ActionListener {
        private int row, col;

        public MoveListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = squares[row][col];
            String clickedPiece = board[row][col];

            if (selectedButton == null) {
                if (clickedPiece != null && clickedPiece.startsWith(currentPlayer)) {
                    selectedButton = clickedButton;
                    selectedRow = row;
                    selectedCol = col;
                    selectedButton.setBackground(Color.YELLOW);
                }
            } else {
                if (isValidMove(selectedRow, selectedCol, row, col)) {
                    board[row][col] = board[selectedRow][selectedCol];
                    board[selectedRow][selectedCol] = null;
                    squares[row][col].setIcon(selectedButton.getIcon());
                    selectedButton.setIcon(null);
                    selectedButton.setBackground((selectedRow + selectedCol) % 2 == 0 ? Color.WHITE : Color.GRAY);
                    currentPlayer = currentPlayer.equals("W") ? "B" : "W";
                    selectedButton = null;
                } else {
                    selectedButton.setBackground((selectedRow + selectedCol) % 2 == 0 ? Color.WHITE : Color.GRAY);
                    selectedButton = null;
                }
            }
        }
    }

    private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
        if (board[fromRow][fromCol] == null) return false;
        String piece = board[fromRow][fromCol];
        String targetPiece = board[toRow][toCol];
        if (targetPiece != null && targetPiece.startsWith(currentPlayer)) return false;
        
        switch (piece.substring(1)) {
            case "P": // Tốt
                int direction = piece.startsWith("W") ? -1 : 1;
                if (fromCol == toCol && board[toRow][toCol] == null) {
                    return (toRow - fromRow == direction) || (fromRow == (piece.startsWith("W") ? 6 : 1) && toRow - fromRow == 2 * direction);
                }
                if (Math.abs(fromCol - toCol) == 1 && toRow - fromRow == direction && targetPiece != null) {
                    return true;
                }
                break;
            case "R": // Xe
                return isStraightMoveValid(fromRow, fromCol, toRow, toCol);
            case "B": // Tượng
                return isDiagonalMoveValid(fromRow, fromCol, toRow, toCol);
            case "Q": // Hậu
                return isStraightMoveValid(fromRow, fromCol, toRow, toCol) || isDiagonalMoveValid(fromRow, fromCol, toRow, toCol);
            case "K": // Vua
                return Math.abs(fromRow - toRow) <= 1 && Math.abs(fromCol - toCol) <= 1;
            case "N": // Mã
                return (Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 1) || (Math.abs(fromRow - toRow) == 1 && Math.abs(fromCol - toCol) == 2);
        }
        return false;
    }

    private boolean isStraightMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromRow == toRow) {
            for (int i = Math.min(fromCol, toCol) + 1; i < Math.max(fromCol, toCol); i++) {
                if (board[fromRow][i] != null) return false;
            }
        } else if (fromCol == toCol) {
            for (int i = Math.min(fromRow, toRow) + 1; i < Math.max(fromRow, toRow); i++) {
                if (board[i][fromCol] != null) return false;
            }
        } else return false;
        return true;
    }

    private boolean isDiagonalMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        if (Math.abs(fromRow - toRow) != Math.abs(fromCol - toCol)) return false;
        int rowStep = (toRow - fromRow) / Math.abs(toRow - fromRow);
        int colStep = (toCol - fromCol) / Math.abs(toCol - fromCol);
        for (int i = 1; i < Math.abs(toRow - fromRow); i++) {
            if (board[fromRow + i * rowStep][fromCol + i * colStep] != null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChessGame().setVisible(true));
    }
}

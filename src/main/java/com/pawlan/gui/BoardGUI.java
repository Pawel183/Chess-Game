package com.pawlan.gui;

import com.pawlan.common.Cordinate;
import com.pawlan.map.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardGUI extends JFrame implements ActionListener {

    public Board board;
    static final int screenWidth = 1000;
    static final int screenHeight = 1000;
    public JButton[][] boardsButtons = new JButton[8][8];
    public JPanel chessBoard = new JPanel();
    JLabel playerOneLabel = new JLabel();
    JLabel playerOneTimeLabel = new JLabel();
    JLabel playerTwoLabel = new JLabel();
    JLabel playerTwoTimeLabel = new JLabel();
//    char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    char[] alphabet = {'0', '1', '2', '3', '4', '5', '6', '7'};

    BoardGUI(String playerOne, String playerTwo, Double time) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenWidth, screenHeight);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(42, 117, 42));
        this.setResizable(false);

        displayPlayerInfo(playerOne, playerTwo, time);
        displayBoard();

        this.board = new Board();

        this.drawPieces();

        this.add(chessBoard);
        this.add(playerOneLabel);
        this.add(playerTwoLabel);
        this.add(playerOneTimeLabel);
        this.add(playerTwoTimeLabel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {

                if (e.getSource() != boardsButtons[x][y])
                    continue;

                var cordinate = new Cordinate(x, y);
                board.handleClick(cordinate);
                drawGame();
                return;
            }
        }
    }

    public void drawGame()
    {
        clearMap();
        setDefaultColor();
        drawPieces();
        drawLegalMoves();
    }

    public void clearMap()
    {
        System.out.println("Clear");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardsButtons[i][j].setIcon(null);
            }
        }
    }

    public void drawPieces() {
        System.out.println("Draw Pieces");
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                var cord = new Cordinate(x, y);
                var piece = board.getPiece(cord);

                if (piece == null) continue;

                var image = piece.getImage();
                boardsButtons[cord.x()][cord.y()].setIcon(image);
            }
        }
    }

    public void drawLegalMoves()
    {
        for (Cordinate cordinate : board.getLegalMoves()) {
            boardsButtons[cordinate.x()][cordinate.y()].setBackground(new Color(124, 111, 68, 255));
        }
    }

    public void setDefaultColor() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
                    boardsButtons[i][j].setBackground(new Color(42, 77, 11));
                    boardsButtons[i][j].setBorderPainted(false);
                } else {
                    boardsButtons[i][j].setBackground(new Color(239, 233, 229));
                    boardsButtons[i][j].setBorderPainted(false);
                }
            }
        }
    }

    public void displayBoard() {
        chessBoard.setBounds((getWidth() - 800) / 2, (getHeight() - 800) / 2, 800, 800);
        chessBoard.setLayout(new GridLayout(8, 8, 0, 0));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boardsButtons[i][j] = new JButton();
                boardsButtons[i][j].setPreferredSize(new Dimension(100, 100));
                boardsButtons[i][j].setBounds(i * 100, j * 100, 100, 100);
                boardsButtons[i][j].setBorderPainted(false);
                chessBoard.add(boardsButtons[i][j]);
                boardsButtons[i][j].addActionListener(this);
            }
        }
        setDefaultColor();


        for (int i = 1; i < 9; i++) {
            JLabel alphabetLabel = new JLabel();
            alphabetLabel.setText(String.valueOf(alphabet[i - 1]));
            alphabetLabel.setBounds(i * 100 + 50, 75, 20, 20);
            alphabetLabel.setFont(new Font("PortagoITC TT", Font.ITALIC, 20));
            alphabetLabel.setForeground(Color.BLACK);
            this.add(alphabetLabel);

            JLabel alphabetLabel2 = new JLabel();
            alphabetLabel2.setText(String.valueOf(alphabet[i - 1]));
            alphabetLabel2.setBounds(i * 100 + 50, 910, 20, 20);
            alphabetLabel2.setFont(new Font("PortagoITC TT", Font.ITALIC, 20));
            alphabetLabel2.setForeground(Color.BLACK);
            this.add(alphabetLabel2);
        }

        int number = 0;

        for (int i = 1; i < 9; i++) {
            JLabel numbersLabel = new JLabel();
            numbersLabel.setText(String.valueOf(number));
            numbersLabel.setBounds(80, i * 100 + 40, 20, 20);
            numbersLabel.setFont(new Font("PortagoITC TT", Font.ITALIC, 20));
            numbersLabel.setForeground(Color.BLACK);
            this.add(numbersLabel);

            JLabel numbersLabel2 = new JLabel();
            numbersLabel2.setText(String.valueOf(number));
            numbersLabel2.setBounds(910, i * 100 + 40, 20, 20);
            numbersLabel2.setFont(new Font("PortagoITC TT", Font.ITALIC, 20));
            numbersLabel2.setForeground(Color.BLACK);
            this.add(numbersLabel2);

            number++;
        }
    }

    private void displayPlayerInfo(String playerOne, String playerTwo, Double time) {
        playerOneLabel.setBounds(200, 10, 200, 30);
        playerOneLabel.setText(playerOne);
        playerOneLabel.setFont(new Font("PortagoITC TT", Font.ITALIC, 20));
        playerOneLabel.setForeground(new Color(0, 0, 0));

        playerOneTimeLabel.setBounds(200, 40, 200, 30);
        playerOneTimeLabel.setText("Czas: " + String.format(String.valueOf(time)));
        playerOneTimeLabel.setFont(new Font("PortagoITC TT", Font.ITALIC, 20));
        playerOneTimeLabel.setForeground(new Color(0, 0, 0));

        playerTwoLabel.setBounds(700, 10, 200, 30);
        playerTwoLabel.setText(playerTwo);
        playerTwoLabel.setFont(new Font("PortagoITC TT", Font.ITALIC, 20));
        playerTwoLabel.setForeground(new Color(0, 0, 0));

        playerTwoTimeLabel.setBounds(700, 40, 200, 30);
        playerTwoTimeLabel.setText("Czas: " + String.format(String.valueOf(time)));
        playerTwoTimeLabel.setFont(new Font("PortagoITC TT", Font.ITALIC, 20));
        playerTwoTimeLabel.setForeground(new Color(0, 0, 0));
    }

}

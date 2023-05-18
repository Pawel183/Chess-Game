package com.pawlan.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    static final int screenWidth = 800;
    static final int screenHeight = 800;

    JLabel titleLabel = new JLabel("CHESS GAME");
    JLabel playerOneNameLabel = new JLabel("Podaj nick pierwszego gracza: (Biały)");
    JTextField playerOneNameTextField = new JTextField();
    JLabel playerTwoNameLabel = new JLabel("Podaj nick drugiego gracza: (Czarny)");
    JTextField playerTwoNameTextField = new JTextField();
    JButton startButton = new JButton("Start Game");
    Double[] timeToPlay = {1.0, 3.0, 5.0, 10.0, 15.0, 30.0};
    JComboBox<Double> timerComboBox = new JComboBox<>(timeToPlay);
    JLabel timerLabel = new JLabel("Wybierz ilość minut dla każdego gracza:");

    String playerOne = "Gracz 1";
    String playerTwo = "Gracz 2";
    Double time;

    public MainWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(screenWidth, screenHeight);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(126, 59, 30));
        this.setTitle("Chess Game");
        this.setResizable(false);

        titleLabel.setBounds(150, 50, 800, 200);
        titleLabel.setFont(new Font("Ink Free", Font.BOLD, 80));
        titleLabel.setForeground(new Color(255, 255, 255));

        playerOneNameLabel.setBounds(150, 250, 450, 50);
        playerOneNameLabel.setFont(new Font("Lucida Fax", Font.ITALIC, 20));
        playerOneNameLabel.setForeground(new Color(255, 255, 255));

        playerOneNameTextField.setBounds(150, 300, 450, 30);
        playerOneNameTextField.setFont(new Font("Lucida Fax", Font.ITALIC, 20));
        playerOneNameTextField.setForeground(Color.BLACK);

        playerTwoNameLabel.setBounds(150, 350, 450, 50);
        playerTwoNameLabel.setFont(new Font("Lucida Fax", Font.ITALIC, 20));
        playerTwoNameLabel.setForeground(new Color(255, 255, 255));

        playerTwoNameTextField.setBounds(150, 400, 450, 30);
        playerTwoNameTextField.setFont(new Font("Lucida Fax", Font.ITALIC, 20));
        playerTwoNameTextField.setForeground(Color.BLACK);

        timerLabel.setBounds(150, 500, 450, 50);
        timerLabel.setFont(new Font("Lucida Fax", Font.ITALIC, 20));
        timerLabel.setForeground(new Color(255, 255, 255));

        timerComboBox.addActionListener(this);
        timerComboBox.setBounds(520, 500, 80, 50);
        timerComboBox.setFont(new Font("Lucida Fax", Font.ITALIC, 20));
        timerComboBox.setSelectedItem(timeToPlay[3]);

        startButton.setBounds(300, 600, 200, 70);
        startButton.setFont(new Font("Monospaced", Font.BOLD, 25));
        startButton.setBackground(new Color(33, 47, 33));
        startButton.setForeground(new Color(255, 255, 255));
        startButton.setBorderPainted(false);
        startButton.addActionListener(this);

        this.add(playerOneNameLabel);
        this.add(playerOneNameTextField);
        this.add(playerTwoNameLabel);
        this.add(playerTwoNameTextField);
        this.add(titleLabel);
        this.add(timerComboBox);
        this.add(timerLabel);
        this.add(startButton);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            time = (Double) timerComboBox.getSelectedItem();
            if (!playerOneNameTextField.getText().equals("")) {
                playerOne = playerOneNameTextField.getText();
            }
            if (!playerTwoNameTextField.getText().equals("")) {
                playerTwo = playerTwoNameTextField.getText();
            }
            this.dispose();
            BoardGUI gui = new BoardGUI(playerOne, playerTwo, time);
        }
    }
}

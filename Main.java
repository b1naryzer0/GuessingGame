package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer tries = 0;
    static JLabel text = new JLabel("Gib eine Zahl zwischen 0 und 100 ein");
    static JLabel counter = new JLabel("Versuche: 0");
    static JTextField textField = new JTextField();
    static JButton button = new JButton("Raten!");

    public static void main(String[] args) {
        openUI();
    }

    public static void openUI(){
        JFrame frame = new JFrame("Rate die Zahl");
        frame.setSize(400, 300);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setLocationRelativeTo(null);

        text.setBounds(50, 50, 200, 30);
        textField.setBounds(50, 100,200,30);
        button.setBounds(50,150,200,30);
        counter.setBounds(50, 200, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String textFromTextField = textField.getText();
                    Integer number = Integer.parseInt(textFromTextField);
                    guess(number);
                } catch (Exception error){
                    text.setText("Bitte gib eine Zahl ein!");
                    textField.setText("");
                    textField.requestFocus();
                }
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String textFromTextField = textField.getText();
                    Integer number = Integer.parseInt(textFromTextField);
                    guess(number);
                } catch (Exception error){
                    text.setText("Bitte gib eine Zahl ein!");
                    textField.setText("");
                    textField.requestFocus();
                }
            }
        });

        frame.add(text);
        frame.add(textField);
        frame.add(button);
        frame.add(counter);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void guess(Integer number){
        tries++;
        counter.setText("Versuche: " + String.valueOf(tries));
        if(number == myNumber){
            text.setText(myNumber + " richtig geraten mit " + tries + " Versuchen");
            tries = 0;
            textField.setText("");
            myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        } else {
            if(number < myNumber){
                text.setText(number + " ist zu klein!");
            } else {
                text.setText(number + " ist zu groß!");
            }
            textField.setText("");
            textField.requestFocus();
        }
    }
}

package com.hotel.view;

/**
 * Created by Eric on 2016/7/7.
 */
import com.hotel.conn.ConnOra;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ThMangeDemo extends JFrame {

    private JPanel contentPane;
    private JButton button;
    private JTextField textField;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ThMangeDemo frame = new ThMangeDemo();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public void setvilt(){
        setVisible(true);
    }

    public ThMangeDemo() {
        ini();
    }
    public void ini(){

        setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u8BFE\u7A0B\u8BBE\u8BA1\\\u56FE\u6807\\money_gold_48px_1184846_easyicon[1].net.png"));
        setTitle("\u53F0\u53F7\u7BA1\u7406");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setBounds(10, 47, 100, 70);
        contentPane.add(textArea);


        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBackground(Color.LIGHT_GRAY);
        textArea_1.setBounds(153, 47, 100, 70);
        contentPane.add(textArea_1);

        JTextArea textArea_2 = new JTextArea();
        textArea_2.setBackground(Color.LIGHT_GRAY);
        textArea_2.setBounds(296, 47, 100, 70);
        contentPane.add(textArea_2);

        JTextArea textArea_3 = new JTextArea();
        textArea_3.setBackground(Color.LIGHT_GRAY);
        textArea_3.setBounds(10, 172, 100, 70);
        contentPane.add(textArea_3);

        JTextArea textArea_4 = new JTextArea();
        textArea_4.setBackground(Color.LIGHT_GRAY);
        textArea_4.setBounds(153, 172, 100,70);
        contentPane.add(textArea_4);

        JTextArea textArea_5 = new JTextArea();
        textArea_5.setBackground(Color.LIGHT_GRAY);
        textArea_5.setBounds(296, 172, 100, 70);
        contentPane.add(textArea_5);

        JLabel label = new JLabel("\u53F0-01");
        label.setBounds(10, 22, 54, 15);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u53F0-02");
        label_1.setBounds(153, 22, 54, 15);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("\u53F0-03");
        label_2.setBounds(296, 22, 54, 15);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("\u53F0-04");
        label_3.setBounds(10, 145, 54, 15);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("\u53F0-05");
        label_4.setBounds(153, 147, 54, 15);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("\u53F0-06");
        label_5.setBounds(296, 145, 54, 15);
        contentPane.add(label_5);

        textField = new JTextField();
        textField.setBounds(387, 0, 45, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("B");
        btnNewButton.setBounds(400, 29, 32, 25);
        contentPane.add(btnNewButton);


        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnOra connOra = new ConnOra();
                try {
                    connOra.getConn();
                } catch (ClassNotFoundException e3) {
                    e3.printStackTrace();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }

                try {
                    if (connOra.thManage(textField.getText())){
                        textArea.setBackground(Color.red);
                        textArea_1.setBackground(Color.green);
                        textArea_2.setBackground(Color.green);
                        textArea_3.setBackground(Color.green);
                        textArea_4.setBackground(Color.green);
                        textArea_5.setBackground(Color.green);

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}



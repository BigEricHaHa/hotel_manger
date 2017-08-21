package com.hotel.view;

/**
 * Created by Eric on 2016/7/7.
 */
import com.hotel.conn.ConnOra;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class YueJieDemo extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    YueJieDemo frame = new YueJieDemo();
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

    public void setvil(){
        setVisible(true);
    }
    public YueJieDemo() {
        ini();
    }
    public void ini(){
        setTitle("\u6708\u6D41\u6C34\u7ED3\u8D26");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("\u6708\u6D41\u6C34\u7ED3\u8D26");
        label.setFont(new Font("黑体", Font.PLAIN, 18));
        label.setBounds(162, 23, 209, 28);
        contentPane.add(label);

        textField = new JTextField();
        textField.setBounds(123, 61, 104, 28);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("\u7ED3\u8D26");
        btnNewButton.setBounds(282, 83, 95, 25);
        contentPane.add(btnNewButton);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(70, 162, 314, 85);
        contentPane.add(textArea);

        textField_1 = new JTextField();
        textField_1.setBounds(123, 99, 104, 28);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel = new JLabel("\u5230");
        lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 13));
        lblNewLabel.setBounds(90, 88, 27, 15);
        contentPane.add(lblNewLabel);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ConnOra connOra = new ConnOra();
                try {
                    connOra.getConn();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                try {
                    int sr = connOra.yjZhang(textField.getText(),textField_1.getText());
                    textArea.setText(String.valueOf(sr));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

}


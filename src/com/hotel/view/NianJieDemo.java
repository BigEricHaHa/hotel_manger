package com.hotel.view;

/**
 * Created by Eric on 2016/7/7.
 */
import com.hotel.conn.ConnOra;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class NianJieDemo extends JFrame {

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
//                    NianJieDemo frame = new NianJieDemo();
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
    public NianJieDemo() {
        ini();
    }
    public void ini(){
        setTitle("\u5E74\u6D41\u6C34\u7ED3\u8D26");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("\u5E74\u6D41\u6C34\u7ED3\u8D26");
        lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 18));
        lblNewLabel.setBounds(171, 29, 120, 35);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(124, 74, 95, 23);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("\u7ED3\u8D26");
        btnNewButton.setBounds(269, 93, 95, 25);
        contentPane.add(btnNewButton);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(62, 158, 311, 93);
        contentPane.add(textArea);

        textField_1 = new JTextField();
        textField_1.setBounds(124, 114, 95, 23);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u5230");
        lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(96, 98, 54, 15);
        contentPane.add(lblNewLabel_1);



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


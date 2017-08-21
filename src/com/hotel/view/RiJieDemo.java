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


public class RiJieDemo extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    RiJieDemo frame = new RiJieDemo();
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
    public RiJieDemo() {
        ini();
    }
    public void ini(){
        setTitle("\u65E5\u6D41\u6C34\u7ED3\u8D26");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setBounds(59, 92, 157, 32);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("\u5F53\u65E5\u6D41\u6C34\u7ED3\u8D26");
        lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 18));
        lblNewLabel.setBounds(163, 10, 136, 32);
        contentPane.add(lblNewLabel);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(59, 161, 332, 102);
        contentPane.add(textArea);

        JButton btnNewButton = new JButton("\u7ED3\u8D26");
        btnNewButton.addActionListener(new ActionListener() {
            //日结账活动
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
                    int sr = connOra.rjZhang(textField.getText());
                    textArea.setText(String.valueOf(sr));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setBounds(296, 95, 95, 25);
        contentPane.add(btnNewButton);


    }
}



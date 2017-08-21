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


public class YhInsertDemo extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    YhInsertDemo frame = new YhInsertDemo();
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
    public YhInsertDemo() {
        ini();
    }
    public void ini(){
        setTitle("\u589E\u52A0\u7528\u6237");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("\u65B0\u7528\u6237\u540D\uFF1A");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel.setBounds(99, 70, 71, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(116, 139, 54, 15);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(203, 64, 106, 28);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(203, 133, 106, 28);
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("\u786E\u8BA4");
        btnNewButton.setBounds(85, 216, 95, 25);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
        btnNewButton_1.setBounds(264, 216, 95, 25);
        contentPane.add(btnNewButton_1);

        //确定
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
                connOra.yhInsert(textField.getText(), String.valueOf(passwordField.getPassword()));
                JOptionPane.showMessageDialog(contentPane,"用户已增加！");
            }
        });

        //返回
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YhManageDemo yhManageDemo = new YhManageDemo();
                yhManageDemo.ini();
                yhManageDemo.setvil();
                setVisible(false);
            }
        });
    }
}



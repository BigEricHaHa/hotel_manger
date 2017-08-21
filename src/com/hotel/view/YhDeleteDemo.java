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


public class YhDeleteDemo extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    YhDeleteDemo frame = new YhDeleteDemo();
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
    public YhDeleteDemo() {
        ini();
    }
    public void ini(){
        setTitle("\u5220\u9664\u7528\u6237");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
        lblNewLabel.setBounds(109, 73, 77, 35);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(196, 80, 95, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("\u786E\u8BA4");
        btnNewButton.setBounds(91, 199, 95, 25);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
        btnNewButton_1.setBounds(244, 199, 95, 25);
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
                connOra.yhDelete(textField.getText());
                JOptionPane.showMessageDialog(contentPane,"用户已删除！");
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


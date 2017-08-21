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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class CpUpdateDemo extends JFrame {

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
//                    CpUpdateDemo frame = new CpUpdateDemo();
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
    public  void vit(){
        setVisible(true);
    }
    public  void vif(){
        setVisible(false);
    }
    public CpUpdateDemo() {
        gz();
    }
    public void gz(){
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Documents and Settings\\Administrator\\\u684C\u9762\\\u65B0\u5EFA\u6587\u4EF6\u5939\\1193472.gif"));
        setTitle("\u4FEE\u6539\u4EF7\u683C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 294, 277);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7");
        lblNewLabel.setBounds(60, 50, 85, 26);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(143, 53, 66, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel label = new JLabel("\u65B0\u4EF7\u683C");
        label.setBounds(60, 110, 85, 18);
        contentPane.add(label);

        textField_1 = new JTextField();
        textField_1.setBounds(143, 109, 66, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JButton button = new JButton("\u786E\u8BA4");
        button.addActionListener(new ActionListener() {
            //确认活动
            public void actionPerformed(ActionEvent e) {
                ConnOra connOra = new ConnOra();
                try {
                    connOra.getConn();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                connOra.updatePrice(textField.getText(),textField_1.getText());
                JOptionPane.showMessageDialog(contentPane,"商品价格已修改！");
                textField.setText("");
                textField_1.setText("");
            }
        });
        button.setBounds(60, 170, 66, 21);
        contentPane.add(button);

        JButton button_1 = new JButton("回退");
        button_1.addActionListener(new ActionListener() {
            //回退活动
            public void actionPerformed(ActionEvent e) {
                CpManageDemo cpManageDemo = new CpManageDemo();
                cpManageDemo.gzff();
                cpManageDemo.vit();
                setVisible(false);
            }
        });
        button_1.setBounds(143, 170, 66, 21);
        contentPane.add(button_1);
    }

}

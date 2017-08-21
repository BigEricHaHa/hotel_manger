package com.hotel.view;

/**
 * Created by Eric on 2016/7/7.
 */
import com.hotel.conn.ConnOra;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class CpDeleteDemo {

    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    CpDeleteDemo window = new CpDeleteDemo();
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the application.
     */
    public  void vit(){
        frame.setVisible(true);
    }
    public  void vif(){
        frame.setVisible(false);
    }
    public CpDeleteDemo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setTitle("\u5220\u9664\u83DC\u54C1");
        frame.setBounds(100, 100, 313, 272);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("\u83DC\u54C1\u7F16\u53F7\uFF1A");
        label.setFont(new Font("宋体", Font.PLAIN, 15));
        label.setBounds(64, 77, 84, 18);
        frame.getContentPane().add(label);

        textField = new JTextField();
        textField.setBounds(135, 74, 66, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

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
                connOra.deleteCai(textField.getText());
                JOptionPane.showMessageDialog(frame,"商品已删除!");
                textField.setText("");
            }
        });
        button.setBounds(57, 160, 66, 21);
        frame.getContentPane().add(button);

        JButton button_1 = new JButton("回退");
        button_1.addActionListener(new ActionListener() {
            //回退活动
            public void actionPerformed(ActionEvent e) {
                CpManageDemo cpManageDemo = new CpManageDemo();
                cpManageDemo.gzff();
                cpManageDemo.vit();
                frame.setVisible(false);
            }
        });
        button_1.setBounds(160, 160, 66, 21);
        frame.getContentPane().add(button_1);
    }
}


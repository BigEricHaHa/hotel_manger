package com.hotel.view;

/**
 * Created by Eric on 2016/7/7.
 */
import com.hotel.conn.ConnOra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class CpInsertDemo {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    CpInsertDemo window = new CpInsertDemo();
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
    public CpInsertDemo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\hotel\\hotel52.jpg"));
        frame.setTitle("\u6DFB\u52A0\u83DC\u54C1");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("\u83DC\u54C1\u7F16\u53F7\uFF1A");
        lblNewLabel.setBounds(10, 102, 76, 15);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u83DC\u54C1\u540D\u79F0\uFF1A");
        lblNewLabel_1.setBounds(169, 102, 76, 15);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u4EF7\u683C\uFF1A");
        lblNewLabel_2.setBounds(318, 102, 54, 15);
        frame.getContentPane().add(lblNewLabel_2);

        JButton btnNewButton = new JButton("确认");
        //确定活动
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConnOra connOra = new ConnOra();
                try {
                    connOra.getConn();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                connOra.insertCai(textField.getText(),textField_1.getText(),textField_2.getText());
                JOptionPane.showMessageDialog(frame,"添加菜品成功！");
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
            }
        });
        btnNewButton.setBounds(77, 177, 95, 25);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("回退");
        //回退活动
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CpManageDemo cpManageDemo = new CpManageDemo();
                cpManageDemo.gzff();
                cpManageDemo.vit();
                frame.setVisible(false);

            }
        });
        btnNewButton_1.setBounds(272, 177, 95, 25);
        frame.getContentPane().add(btnNewButton_1);

        textField = new JTextField();
        textField.setBounds(81, 99, 78, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(232, 99, 76, 21);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(356, 99, 76, 21);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon("H:\\hotel\\soup_256px_566634_easyicon[1].net.png"));
        lblNewLabel_3.setBounds(184, -12, 248, 167);
        frame.getContentPane().add(lblNewLabel_3);
    }
}

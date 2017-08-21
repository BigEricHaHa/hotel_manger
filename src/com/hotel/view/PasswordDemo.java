package com.hotel.view;

/**
 * Created by Eric on 2016/7/7.
 */
import com.hotel.conn.ConnOra;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class PasswordDemo extends JFrame {

    private JFrame frame;
    private JPanel contentPane;
    private JTextField textField_1,textField_2;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    PasswordDemo frame = new PasswordDemo();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     *
     */
    public PasswordDemo() {
        ini();
    }
    public void ini(){
        setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\hotel\\hotel52.jpg"));
        setBackground(new Color(0, 0, 0));
        setTitle("\u4FEE\u6539\u5BC6\u7801");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.inactiveCaptionBorder);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_2 = new JLabel("新密码：");
        label_2.setBounds(85, 90, 54, 15);
        contentPane.add(label_2);

        textField_1 = new JTextField();
        textField_1.setBounds(173, 90, 123, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);



        JLabel label_3 = new JLabel("用户名：");
        label_3.setBounds(85, 60, 54, 15);
        contentPane.add(label_3);


        textField_2 = new JTextField();
        textField_2.setBounds(173, 60, 123, 21);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JButton btnNewButton = new JButton("\u786E\u8BA4");
        btnNewButton.addActionListener(new ActionListener() {
            //确定活动
            public void actionPerformed(ActionEvent e) {
                ConnOra connOra = new ConnOra();
                try {
                    connOra.getConn();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                connOra.updatePassword(textField_2.getText(),textField_1.getText());
                LoginDemo loginDemo = new LoginDemo();
                loginDemo.init();
                loginDemo.vit();
                setVisible(false);
            }
        });
        btnNewButton.setBounds(68, 193, 95, 25);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("回退");
        btnNewButton_1.addActionListener(new ActionListener() {
            //回退活动
            public void actionPerformed(ActionEvent e) {
                ManageDemo manageDemo = new ManageDemo();
                manageDemo.initialize();
                manageDemo.setvilt();
                setVisible(false);
            }
        });
        btnNewButton_1.setBounds(260, 193, 95, 25);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("H:\\hotel\\password_pencil_256px_1112528_easyicon[1].net.png"));
        lblNewLabel.setBounds(203, -35, 239, 271);
        contentPane.add(lblNewLabel);
    }

}


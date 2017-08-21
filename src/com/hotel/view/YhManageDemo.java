package com.hotel.view;

/**
 * Created by Eric on 2016/7/7.
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class YhManageDemo extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    YhManageDemo frame = new YhManageDemo();
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
    public void setvilf(){
        setVisible(false);
    }
    public YhManageDemo() {
        ini();
    }
    public void ini(){
        setTitle("\u589E\u5220\u7528\u6237");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JButton btnNewButton = new JButton("\u589E\u52A0\u7528\u6237");
        btnNewButton.setBounds(82, 23, 95, 25);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u5220\u9664\u7528\u6237");
        btnNewButton_1.setBounds(235, 23, 95, 25);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("H:\\Hotel\\user.jpg"));
        lblNewLabel.setBounds(82, 100, 263, 173);
        contentPane.add(lblNewLabel);


        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YhInsertDemo yhInsertDemo = new YhInsertDemo();
                yhInsertDemo.ini();
                yhInsertDemo.setvil();
                setVisible(false);
            }
        });


        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YhDeleteDemo yhDeleteDemo = new YhDeleteDemo();
                yhDeleteDemo.ini();
                yhDeleteDemo.setvil();
                setVisible(false);
            }
        });
    }
}



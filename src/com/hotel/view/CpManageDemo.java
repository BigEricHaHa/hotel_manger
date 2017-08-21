package com.hotel.view;

/**
 * Created by Eric on 2016/7/7.
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CpManageDemo extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    CpManageDemo frame = new CpManageDemo();
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
    public CpManageDemo() {
        gzff();
    }
    public void gzff(){
        setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\hotel\\hotel52.jpg"));
        setTitle("\u83DC\u54C1\u7BA1\u7406");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 180, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton button = new JButton("\u5220\u9664\u83DC\u54C1");
        button.addActionListener(new ActionListener() {
            //删除菜品活动
            public void actionPerformed(ActionEvent e) {
                CpDeleteDemo cpDeleteDemo = new CpDeleteDemo();
                cpDeleteDemo.initialize();
                cpDeleteDemo.vit();
                setVisible(false);
            }
        });
        button.setBounds(31, 124, 95, 25);
        contentPane.add(button);

        JButton button_1 = new JButton("\u6DFB\u52A0\u83DC\u54C1");
        button_1.addActionListener(new ActionListener() {
            //添加菜品活动
            public void actionPerformed(ActionEvent e) {
                CpInsertDemo cpInsertDemo = new CpInsertDemo();
                cpInsertDemo.initialize();
                cpInsertDemo.vit();
                setVisible(false);
            }
        });
        button_1.setBounds(31, 53, 95, 25);
        contentPane.add(button_1);

        JButton button_2 = new JButton("\u4FEE\u6539\u4EF7\u683C");
        button_2.addActionListener(new ActionListener() {
            //修改价格活动
            public void actionPerformed(ActionEvent e) {
                CpUpdateDemo cpUpdateDemo = new CpUpdateDemo();
                cpUpdateDemo.gz();
                cpUpdateDemo.vit();
                setVisible(false);
            }
        });
        button_2.setBounds(31, 197, 95, 25);
        contentPane.add(button_2);
    }
}



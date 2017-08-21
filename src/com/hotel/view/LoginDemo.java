package com.hotel.view;

/**
 * Created by Eric on 2016/7/7.
 */
import com.hotel.conn.ConnOra;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JTable;


public class LoginDemo extends JFrame {

    private JPanel contentPane;
    private JFrame ab_frame;
    private JTextField ab_userName;
    private JPasswordField ab_password;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginDemo frame = new LoginDemo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     *
     *
     */
    public  void vit(){
        setVisible(true);
    }
    public  void vif(){
        setVisible(false);
    }
    public LoginDemo() {
        init();
    }
    public void init(){
        setResizable(false);
        setTitle("\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF\u7BA1\u7406\u5458\u767B\u5F55\u7A0B\u5E8F");
        Image img = Toolkit.getDefaultToolkit().getImage("H:\\Hotel\\hotel52.jpg");
        setIconImage(img);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
        label.setBounds(80, 85, 52, 26);
        contentPane.add(label);

        JLabel lblNewLabel = new JLabel("\u5BC6\u7801\uFF1A");
        lblNewLabel.setBounds(80, 139, 49, 33);
        contentPane.add(lblNewLabel);

        ab_password = new JPasswordField();
        ab_password.setBounds(142, 145, 123, 21);
        contentPane.add(ab_password);

        JLabel lblNewLabel_1 = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u672C\u7CFB\u7EDF");
        lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(138, 24, 144, 40);
        contentPane.add(lblNewLabel_1);

        JButton jb_login = new JButton("\u767B\u9646");
        jb_login.addActionListener(new ActionListener() {

            //按钮1的活动
            public void actionPerformed(ActionEvent e) {
                ConnOra connOra = new ConnOra();
                try {
                    connOra.getConn();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
//                if (connOra.login(ab_userName.getText(), String.valueOf(ab_password.getPassword()))) {

//                    JOptionPane.showMessageDialog(contentPane, "登陆成功！");
                    ManageDemo window = new ManageDemo();
                    window.initialize();
                    window.setvilt();
                    setVisible(false);
//                } else {
//                    JOptionPane.showMessageDialog(contentPane, "登陆异常！");
//                    dispose();
//                }
            }
        });
        jb_login.setFont(new Font("黑体", Font.PLAIN, 16));
        jb_login.setBounds(315, 85, 93, 32);
        contentPane.add(jb_login);

        ab_userName = new JTextField();
        ab_userName.setToolTipText("");
        ab_userName.setBounds(142, 88, 123, 21);
        contentPane.add(ab_userName);
        ab_userName.setColumns(10);

        table = new JTable();
        table.setBounds(423, 73, 1, 1);
        contentPane.add(table);

        JButton jb_reset = new JButton("退出");
        jb_reset.addActionListener(new ActionListener() {
            //按钮2的活动
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        jb_reset.setFont(new Font("黑体", Font.PLAIN, 16));
        jb_reset.setBounds(315, 139, 93, 32);
        contentPane.add(jb_reset);
    }

}


package com.hotel.view;

/**
 * Created by Eric on 2016/7/7.
 */
import com.hotel.conn.ConnOra;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import static java.awt.BorderLayout.CENTER;

public class ManageDemo {

    private JFrame yp_frame;
    private JTextField yp_spbhFiled;
    private JTextField yp_spmcField;
    private JTextField yp_slFiled;
    private JTable table;
    private JTable table_1;
    private JTextArea yp_xfjeArea;
    private JTextField yp_ssjeField;
    private JTextArea yp_zljeArea;
    public static int count = 0;
    private static int count1 = 0;

    /**
     * Launch the application.
     */
//public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ManageDemo window = new ManageDemo();
//                    window.yp_frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the application.
     */
    public ManageDemo() {
        initialize();
    }

    public void countPlus(){
        count++;
    }

    public void count1Plus(){
        count1++;
    }

    /**
     * Initialize the contents of the frame.
     */
    public void setvilt(){
        yp_frame.setVisible(true);
    }
    public void setvilf(){
        yp_frame.setVisible(false);
    }
    public void initialize() {
        yp_frame = new JFrame();
        yp_frame.setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\Hotel\\hotel52.jpg"));
        yp_frame.setTitle("\u9152\u5E97\u7BA1\u7406\u7CFB\u7EDF");
        yp_frame.setResizable(false);
        yp_frame.setBounds(100, 100, 680, 500);
        yp_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        yp_frame.getContentPane().setLayout(null);
        yp_frame.setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("签单列表：");
        lblNewLabel.setBounds(10, 107, 66, 28);
        yp_frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("H:\\Hotel\\主页面横条.png"));
        lblNewLabel_1.setBounds(0, 0, 744, 104);
        yp_frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u5F00\u53F0\u5217\u8868\uFF1A");
        lblNewLabel_2.setBounds(446, 114, 78, 15);
        yp_frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("台号：");
        lblNewLabel_3.setBounds(10, 296, 40, 15);
        yp_frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("商品编号：");
        lblNewLabel_4.setBounds(112, 296, 71, 15);
        yp_frame.getContentPane().add(lblNewLabel_4);

        yp_spbhFiled = new JTextField();
        yp_spbhFiled.setBounds(176, 293, 54, 21);
        yp_frame.getContentPane().add(yp_spbhFiled);
        yp_spbhFiled.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("商品名称：");
        lblNewLabel_5.setBounds(240, 296, 78, 15);
        yp_frame.getContentPane().add(lblNewLabel_5);

        yp_spmcField = new JTextField();
        yp_spmcField.setBounds(308, 293, 87, 21);
        yp_frame.getContentPane().add(yp_spmcField);
        yp_spmcField.setColumns(10);

        JLabel label = new JLabel("价格：");
        label.setBounds(405, 296, 54, 15);
        yp_frame.getContentPane().add(label);

        yp_slFiled = new JTextField();
        yp_slFiled.setBounds(440, 295, 32, 17);
        yp_frame.getContentPane().add(yp_slFiled);
        yp_slFiled.setColumns(10);

        Choice yp_choice = new Choice();
        yp_choice.setBounds(52, 293, 56, 21);
        yp_frame.getContentPane().add(yp_choice);


        yp_choice.add("001");
        yp_choice.add("002");
        yp_choice.add("003");
        yp_choice.add("004");
        yp_choice.add("005");
        yp_choice.add("006");
        yp_frame.add(yp_choice);


        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_2.setBounds(10, 321, 126, 144);
        yp_frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JTextArea yp_textArea = new JTextArea();
        yp_textArea.setBounds(10, 10, 106, 124);
        panel_2.add(yp_textArea);


        //获取时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        SimpleDateFormat sim = new SimpleDateFormat("yy-MM-dd");
//        SimpleDateFormat si = new SimpleDateFormat("HH:mm:ss");
        yp_textArea.setText("\n\n\n" + simpleDateFormat.format(new Date()));

        JButton yp_kdButton;
        yp_kdButton = new JButton("点菜");
        //点菜活动
        yp_kdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConnOra connOra = new ConnOra();
                try {
                    connOra.getConn();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                connOra.jiLu(yp_spbhFiled.getText(),yp_choice.getSelectedItem(),yp_slFiled.getText(),sim.format(new Date()));
                connOra.dianCai(yp_choice.getSelectedItem(),yp_spbhFiled.getText(),yp_slFiled.getText());
                table.setValueAt(yp_choice.getSelectedItem(),count1,0);
                table.setValueAt(yp_spbhFiled.getText(),count1,1);
                table.setValueAt(yp_spmcField.getText(),count1,2);
                table.setValueAt(yp_slFiled.getText(),count1,3);
                count1Plus();
                yp_spbhFiled.setText("");
                yp_slFiled.setText("");
                yp_spmcField.setText("");
            }
        });
        yp_kdButton.setBackground(new Color(255, 255, 204));
        yp_kdButton.setBounds(479, 291, 64, 26);
        yp_frame.getContentPane().add(yp_kdButton);

        //hhhhh

        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(10, 135, 429, 151);
        yp_frame.getContentPane().add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 409, 131);
        panel.add(scrollPane);


        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null,null},
                        {null, null, null,null},
                        {null, null, null,null},
                        {null, null, null,null},
                        {null, null, null,null},
                        {null, null, null,null},
                        {null, null, null,null},
                },
                new String[] {
                        "台号","商品编号", "商品名称","金额"
                }
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, true, true, true, true, true
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_1.setBounds(446, 135, 218, 148);
        yp_frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 10, 198, 128);
        panel_1.add(scrollPane_1);

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                },
                new String[] {
                        "台号", "开台时间"
                }
        ));
        table_1.getColumnModel().getColumn(1).setPreferredWidth(150);
        scrollPane_1.setViewportView(table_1);

        JButton yp_qdButton = new JButton("开台");
        yp_qdButton.addActionListener(new ActionListener() {
            //开台按钮活动
            public void actionPerformed(ActionEvent e) {
                ConnOra connOra = new ConnOra();
                try {
                    connOra.getConn();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                String a = yp_choice.getSelectedItem();
                String b = simpleDateFormat.format(new Date());
                connOra.kaiTai(a,b);
                table_1.setValueAt(a,count,0);
                table_1.setValueAt(b,count,1);
                countPlus();
            }
        });
        yp_qdButton.setBackground(new Color(255, 255, 204));
        yp_qdButton.setBounds(564, 291, 64, 26);
        yp_frame.getContentPane().add(yp_qdButton);


        JLabel lblNewLabel_7 = new JLabel("菜品名称：");
        lblNewLabel_7.setBounds(104, 135, 48, 15);
        yp_frame.getContentPane().add(lblNewLabel_7);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(91, 135, 108, 18);
        yp_frame.getContentPane().add(panel_3);
        panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));





        //时间位置

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel_4.setBounds(139, 321, 257, 144);
        yp_frame.getContentPane().add(panel_4);
        panel_4.setLayout(null);

        JLabel lblNewLabel_8 = new JLabel("实收金额：");
        lblNewLabel_8.setBounds(80, 44, 67, 15);
        panel_4.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("消费金额：\n");
        lblNewLabel_9.setBounds(80, 10, 67, 15);
        panel_4.add(lblNewLabel_9);

        JLabel lblNewLabel_6 = new JLabel("找零金额：");
        lblNewLabel_6.setBounds(80, 116, 67, 15);
        panel_4.add(lblNewLabel_6);

        yp_xfjeArea = new JTextArea();
        yp_xfjeArea.setBounds(157, 7, 66, 21);
        panel_4.add(yp_xfjeArea);
        yp_xfjeArea.setColumns(10);

        yp_ssjeField = new JTextField();
        yp_ssjeField.setBounds(157, 41, 66, 21);
        panel_4.add(yp_ssjeField);
        yp_ssjeField.setColumns(10);

        yp_zljeArea = new JTextArea();
        yp_zljeArea.setBounds(157, 113, 66, 21);
        panel_4.add(yp_zljeArea);
        yp_zljeArea.setColumns(10);

        JButton yp_jzButton = new JButton("结账");
        //结账活动
        yp_jzButton.addActionListener(new ActionListener() {
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
                    int a = connOra.jieZhang1(yp_choice.getSelectedItem());
                    yp_xfjeArea.append(String.valueOf(a));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        yp_jzButton.setBounds(157, 78, 68, 25);
        panel_4.add(yp_jzButton);

        JButton yp_zlButton = new JButton("找零");
//        yp_zlButton.setFont(new Font("黑体", Font.PLAIN, 12));
        //找零活动
        yp_zlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConnOra connOra = new ConnOra();
                try {
                    connOra.getConn();
                    int a = connOra.jieZhang1(yp_choice.getSelectedItem());
                    int b = Integer.parseInt(yp_ssjeField.getText());
                    yp_zljeArea.setText(String.valueOf(b-a));
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


//                try {
//                    Thread.sleep(6000);
//                } catch (InterruptedException e1) {
//                    e1.printStackTrace();
//                }
//
//                yp_xfjeArea.setText("");
//                yp_ssjeField.setText("");
//                yp_zljeArea.setText("");

                try {
                    connOra.jieZhang2(yp_choice.getSelectedItem());
                    connOra.jieZhang3(yp_choice.getSelectedItem());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }


            }
        });
        yp_zlButton.setBounds(80, 78, 68, 25);
        panel_4.add(yp_zlButton);

        JButton yp_czButton = new JButton("重置");
        yp_czButton.setBounds(5, 113, 68, 25);
        panel_4.add(yp_czButton);

        yp_czButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yp_xfjeArea.setText("");
                yp_ssjeField.setText("");
                yp_zljeArea.setText("");
            }
        });

        JLabel lblNewLabel_10 = new JLabel("\u5143");
        lblNewLabel_10.setBounds(233, 10, 54, 15);
        panel_4.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("\u5143");
        lblNewLabel_11.setBounds(233, 47, 54, 15);
        panel_4.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("\u5143");
        lblNewLabel_12.setBounds(233, 119, 54, 15);
        panel_4.add(lblNewLabel_12);

        JLabel lblNewLabel_13 = new JLabel("");
        lblNewLabel_13.setIcon(new ImageIcon("H:\\Hotel\\money_gold_48px_1184846_easyicon[1].net.png"));
        lblNewLabel_13.setBounds(10, 27, 54, 89);
        panel_4.add(lblNewLabel_13);

        JButton yp_cpglButton = new JButton("\u83DC\u54C1\u7BA1\u7406");
        yp_cpglButton.setBounds(406, 327, 84, 25);
        yp_frame.getContentPane().add(yp_cpglButton);
        yp_cpglButton.setFont(new Font("黑体", Font.PLAIN, 12));

        JButton yp_cxglButton = new JButton("\u83DC\u7CFB\u7BA1\u7406");
        yp_cxglButton.setFont(new Font("黑体", Font.PLAIN, 12));
        //菜系管理活动（写完）
        yp_cxglButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(yp_frame,"本功能正在维护中！");

            }
        });
        yp_cxglButton.setBounds(406, 381, 87, 25);
        yp_frame.getContentPane().add(yp_cxglButton);

        JButton yp_thglButton = new JButton("台号管理");
        yp_thglButton.setFont(new Font("黑体", Font.PLAIN, 12));
        //台号管理活动
        yp_thglButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ThMangeDemo thMangeDemo = new ThMangeDemo();
                thMangeDemo.setvilt();
                yp_frame.setVisible(false);
            }
        });
        yp_thglButton.setBounds(406, 440, 87, 25);
        yp_frame.getContentPane().add(yp_thglButton);

        JButton yp_yjzButton = new JButton("\u6708\u7ED3\u8D26");
        yp_yjzButton.setFont(new Font("黑体", Font.PLAIN, 12));
        //月结账活动
        yp_yjzButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                YueJieDemo yueJieDemo = new YueJieDemo();
                yueJieDemo.ini();
                yueJieDemo.setvil();
                yp_frame.setVisible(false);
            }
        });
        yp_yjzButton.setBounds(500, 381, 78, 25);
        yp_frame.getContentPane().add(yp_yjzButton);

        JButton yp_njzButton = new JButton("年结账");
        yp_njzButton.setFont(new Font("黑体", Font.PLAIN, 12));
        //年结账活动
        yp_njzButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NianJieDemo nianJieDemo = new NianJieDemo();
                nianJieDemo.ini();
                nianJieDemo.setvil();
                yp_frame.setVisible(false);
            }
        });
        yp_njzButton.setBounds(500, 440, 78, 25);
        yp_frame.getContentPane().add(yp_njzButton);

        JButton yp_rjzButton = new JButton("\u65E5\u7ED3\u8D26");
        yp_rjzButton.setFont(new Font("黑体", Font.PLAIN, 12));
        //日结账活动
        yp_rjzButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RiJieDemo riJieDemo = new RiJieDemo();
                riJieDemo.ini();
                riJieDemo.setvil();
                yp_frame.setVisible(false);

            }
        });
        yp_rjzButton.setBounds(500, 327, 78, 25);
        yp_frame.getContentPane().add(yp_rjzButton);

        JButton yp_xgmmButton = new JButton("\u4FEE\u6539\u5BC6\u7801");
        yp_xgmmButton.setFont(new Font("黑体", Font.PLAIN, 12));
        //修改密码活动（写完）
        yp_xgmmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PasswordDemo passwordDemo = new PasswordDemo();
                passwordDemo.ini();
                passwordDemo.setVisible(true);
                setvilf();
            }
        });
        yp_xgmmButton.setBounds(579, 327, 95, 25);
        yp_frame.getContentPane().add(yp_xgmmButton);

        JButton yp_yhglButton = new JButton("用户管理");
        yp_yhglButton.setFont(new Font("黑体", Font.PLAIN, 12));
        //用户管理活动（写完）
        yp_yhglButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                YhManageDemo yhManageDemo = new YhManageDemo();
                yhManageDemo.ini();
                yhManageDemo.setvil();
                setvilf();
            }
        });
        yp_yhglButton.setBounds(581, 381, 93, 25);
        yp_frame.getContentPane().add(yp_yhglButton);

        JButton yp_tcxtButton = new JButton("\u9000\u51FA\u7CFB\u7EDF");
        yp_tcxtButton.setFont(new Font("黑体", Font.PLAIN, 12));
        //退出系统活动（写完）
        yp_tcxtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                yp_frame.dispose();
            }
        });
        yp_tcxtButton.setBounds(581, 440, 93, 25);
        yp_frame.getContentPane().add(yp_tcxtButton);
        //菜品管理活动(写完)
        yp_cpglButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CpManageDemo cpManageDemo = new CpManageDemo();
                cpManageDemo.gzff();
                cpManageDemo.vit();
                yp_frame.setVisible(false);
            }
        });
    }
}



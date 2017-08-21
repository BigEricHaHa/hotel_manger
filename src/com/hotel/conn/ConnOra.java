package com.hotel.conn;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.sql.*;

/**
 * Created by Eric on 2016/6/27.
 */
public class ConnOra {
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    private String dbuser = "system";
    private String dbpassword = "123456";
    private String sql;
    private Connection connection;
    private PreparedStatement pstmt;

    public void getConn() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, dbuser, dbpassword);
    }

    public void closeConn() throws SQLException {
        if (connection == null) {
            connection.close();
        }
    }

    public boolean login(String userName, String password) {

        try {

            pstmt = connection.prepareStatement("select * from M "
                    + "where M_USER=? and M_PASS=?");

            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            if (pstmt.executeQuery().next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePassword(String name,String password) {
        try {
            pstmt = connection.prepareStatement("update M set M_PASS=? where M_USER=?");
            pstmt.setString(2,name);
            pstmt.setString(1, password);
            if (pstmt.executeUpdate() !=0) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertCai(String no, String name, String price) {
        try {
            pstmt = connection.prepareStatement("insert into Caidan values(?,?,?)");
            pstmt.setString(1,no);
            pstmt.setString(2,name);
            pstmt.setString(3,price);
            if (pstmt.executeQuery().next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

    public boolean kaiTai(String no, String time){
        try {
            pstmt = connection.prepareStatement("insert into Taibiao values(?,?,'1')");
            pstmt.setString(1,no);
            pstmt.setString(2,time);
            if (pstmt.executeQuery().next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //    select sum(Jprice) from Jiezhang where Tnumber=?
    public int jieZhang1(String no) throws SQLException {

        Statement stmt=null;
        ResultSet rs=null;
        int str = 0;
        String sql="select sum(Jprice) from Jiezhang where Tnumber="+no;
        stmt=connection.createStatement();
        rs=stmt.executeQuery(sql);
        if (rs.next()){
            str = rs.getInt("sum(Jprice)");
        }
        return str;
    }


    public boolean jieZhang2(String no) throws SQLException {
        pstmt = connection.prepareStatement("delete from Jiezhang where Tnumber=?");
        pstmt.setString(1,no);
        if (pstmt.executeQuery().next()){
            return true;
        }
        return false;
    }


    public boolean jieZhang3(String no) throws SQLException {
        pstmt = connection.prepareStatement("delete from Taibiao where Tnumber=?");
        pstmt.setString(1,no);
        if (pstmt.executeQuery().next()){
            return true;
        }
        return false;
    }



    public boolean deleteCai(String no){
        try {
            pstmt = connection.prepareStatement("delete from Caidan where CNUMBER=?");
            pstmt.setString(1,no);
            if (pstmt.executeQuery().next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePrice(String price,String no){
        try {
            pstmt = connection.prepareStatement("update Caidan set Cprice=? where Cnumber=?");
            pstmt.setString(1,no);
            pstmt.setString(2,price);
            if(pstmt.executeQuery().next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean dianCai(String tno,String cno,String price){
        try {
            pstmt = connection.prepareStatement("insert into Jiezhang values(?,?,?)");
            pstmt.setString(1,tno);
            pstmt.setString(2,cno);
            pstmt.setString(3,price);
            if (pstmt.executeQuery().next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //select Tnumber from Taibiao where Thave='1'
    public boolean thManage(String have) throws SQLException {
        pstmt = connection.prepareStatement("select Tnumber from Taibiao where Thave=?");
        pstmt.setString(1,have);
        if (pstmt.executeQuery().next()){
            return true;
        }
        return false;
    }

    public boolean jiLu(String cno,String tno,String price,String time){

        try {
            pstmt = connection.prepareStatement("insert into History values(?,?,?,?)");
            pstmt.setString(1,cno);
            pstmt.setString(2,tno);
            pstmt.setString(3,price);
            pstmt.setString(4,time);
            if (pstmt.executeQuery().next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int rjZhang(String time) throws SQLException {

        Statement stmt=null;
        ResultSet rs=null;
        int str = 0;
        String sql="select sum(Jprice) from History where Ttime='"+time+"'";
        stmt=connection.createStatement();
        rs=stmt.executeQuery(sql);
        if (rs.next()){
            str = rs.getInt("sum(Jprice)");
        }
        return str;
    }


    public int yjZhang(String time,String time1) throws SQLException {

        Statement stmt=null;
        ResultSet rs=null;
        int str = 0;
        String sql="select sum(Jprice) from History where Ttime between '"+time+"' and  '"+time1+"'";
        stmt=connection.createStatement();
        rs=stmt.executeQuery(sql);
        if (rs.next()){
            str = rs.getInt("sum(Jprice)");
        }
        return str;
    }

    public int njZhang(String time,String time1) throws SQLException {

        Statement stmt=null;
        ResultSet rs=null;
        int str = 0;
        String sql="select sum(Jprice) from History where Ttime between '"+time+"' and  '"+time1+"'";
        stmt=connection.createStatement();
        rs=stmt.executeQuery(sql);
        if (rs.next()){
            str = rs.getInt("sum(Jprice)");
        }
        return str;
    }

    public boolean yhInsert(String name, String password){
        try {
            pstmt =connection.prepareStatement("insert into M values(?,?)");
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            if (pstmt.executeQuery().next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean yhDelete(String name){
        try {
            pstmt = connection.prepareStatement("delete from M where M_user=?");
            pstmt.setString(1,name);
            if (pstmt.executeQuery().next()){
                return  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

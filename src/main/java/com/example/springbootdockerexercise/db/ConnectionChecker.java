package com.example.springbootdockerexercise.db;

import java.sql.*;
import java.util.Map;

import static java.lang.System.getenv;

public class ConnectionChecker {
    public void check() throws ClassNotFoundException, SQLException {
        // DB 접속 코드
        Map<String, String> env = getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                dbHost,dbUser,dbPassword
        );

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SHOW DATABASES");
        rs = st.getResultSet();

        while (rs.next()) {
            String str = rs.getString(1);
            System.out.println(str);
        }
    }
    public void add() throws ClassNotFoundException, SQLException {

        Map<String, String> env = getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                dbHost,dbUser,dbPassword
        );

        PreparedStatement pstmt = con.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
        pstmt.setString(1, "2");
        pstmt.setString(2, "hyunmok2");
        pstmt.setString(3, "1234");
        pstmt.executeUpdate();
    }
    public void select() throws ClassNotFoundException, SQLException {
        Map<String, String> env = getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                dbHost,dbUser,dbPassword
        );

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM users LIMIT 50");
        rs = st.getResultSet();

        while(rs.next()){
            String col1 =rs.getString(1);
            String col2 =rs.getString(2);
            String col3 =rs.getString(3);
            System.out.printf("%s %s %s\n", col1, col2, col3);
        }

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionChecker cc = new ConnectionChecker();
//        cc.check();
//        cc.add();
        cc.select();
    }
}

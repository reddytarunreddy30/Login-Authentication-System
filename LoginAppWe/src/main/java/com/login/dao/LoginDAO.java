package com.login.dao;

import java.sql.*;

public class LoginDAO {

    public boolean checkLogin(String username, String password) {

        boolean status = false;

        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");

        	String url = "jdbc:oracle:thin:@//localhost:1521/XE";

        	Connection con = DriverManager.getConnection(
        	    url,
        	    "system",
        	    "tarun1234"
        	);




            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                status = true;
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}

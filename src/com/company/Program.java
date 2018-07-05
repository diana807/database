
package com.company;

import java.sql.*;

public class Program {

    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost/web?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&user=gareevaa&password=test";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_NAME);

        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING)) {
            Statement cmd = conn.createStatement();
            String sql = "select model,type, price from Printer";
            ResultSet result = cmd.executeQuery(sql);
            while (result.next()) {
                int model = result.getInt("model");
                String type = result.getString("type");
                int price = result.getInt("price");
                System.out.printf ("%d : %-10s : %d\n",model,type,price);
            }
            result.close();
        }
    }
}

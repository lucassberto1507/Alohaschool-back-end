package br.com.gbrsistemas.estoque.config;

import java.sql.*;


public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/alohaschool?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }

    public static void closeConnection(Connection con) {

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
				System.err.println("Erro: "+ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
				System.err.println("Erro: "+ex);
            }
        }
        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
				System.err.println("Erro: "+ex);
            }
        }
        closeConnection(con, stmt);
    }
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
    private Connection cnx;
    private PreparedStatement pstm;
    private int ok;

    public Connection getConnexion() {
        String host = "localhost";
        String dataBase = "java";
        int port = 3306;
        String user = "root";
        String mdp = "";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dataBase;

        try {
            cnx = DriverManager.getConnection(url, user, mdp);
            System.out.println("La connexion est réussie : " + cnx);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnx;
    }

    public void initPrepare(String sql) {
        try {
            pstm = getConnexion().prepareStatement(sql);
            System.out.println("Succès pstm");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeRequet() {
        ResultSet rs = null;
        try {
            rs = pstm.executeQuery();
            System.out.println("Succès résultat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeMaj() {
        try {
            ok = pstm.executeUpdate();
            System.out.println("Succès executeMaj : " + ok);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ok;
    }

    public void closeConnexion() {
        try {
            if (cnx != null) {
                cnx.close();
                System.out.println("Succès fermeture connexion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPstm() {
        return pstm;
    }
}

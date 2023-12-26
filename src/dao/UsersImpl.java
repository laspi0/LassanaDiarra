package dao;

import entity.Users;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersImpl implements IUsers{

    private final DB db = new DB();
    private ResultSet rs;
    private int ok;

    @Override
    public int add(Users users) {
        String sql = "INSERT INTO user(id, nom, email, mdp) VALUES(null, ?, ?, ?)";
        try {
            db.initPrepare(sql);
            db.getPstm().setString(1, users.getNom());
            db.getPstm().setString(2, users.getEmail());
            db.getPstm().setString(3, users.getMdp());
            ok = db.executeMaj();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout : " + e.getMessage());
        } finally {
            db.closeConnexion();
        }
        return ok;
    }

    @Override
    public int update(Users users) {
        return 0;
    }

    @Override
    public int delete(Users users) {
        return 0;
    }

    @Override
    public List<Users> list() {
        List<Users> userList = new ArrayList<>();
        String query = "SELECT * FROM user";

        try {
            db.initPrepare(query);
            ResultSet rs = db.executeRequet(); // Utilisation de la méthode de DB pour obtenir le ResultSet
            while (rs.next()) {
                Users user = new Users();
                user.setId(String.valueOf(rs.getInt("id")));
                user.setNom(rs.getString("nom"));
                user.setEmail(rs.getString("email"));
                user.setMdp(rs.getString("mdp"));
                userList.add(user);
            }
            System.out.println("Succès résultat");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnexion();
        }

        return userList;
    }



    @Override
    public Users get(int id) {
        return null;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;
import model.Noval;
import model.Type;

/**
 *
 * @author Uchitachi
 */
public class LoginDAO extends BaseDAO {

    public Login getAccountByUserNameandPassword(String user, String pass) {
        try {
            String sql = "SELECT * FROM Account where userName = ? and passWord = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            Login account = null;
            while (rs.next()) {
                if (account == null) {
                    account = new Login();
                    account.setId(rs.getInt("idLogin"));
                    account.setCreator(rs.getBoolean("creatorID"));
                    account.setUser(rs.getString("userName"));
                    account.setPass(rs.getString("passWord"));
                }
            }
            return account;

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    public static void main(String[] args) {
        LoginDAO ldb = new LoginDAO();
        Login l = ldb.getAccountByUserNameandPassword("duc", "123456");
        System.out.println(l);
    }

    

}

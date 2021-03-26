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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Chapter;
import model.Favourite;
import model.Noval;
import model.Type;

/**
 *
 * @author Nekko
 */
public class FavoriteDAO extends BaseDAO{
     public ArrayList<Noval> getFavorite(int uid) {

        //
        ArrayList<Noval> novals = new ArrayList<>();
        try {
            String sql = "select * from Favorite f join Account a "
                + "on f.idLogin = a.idLogin "
                + "join Noval n on f.idnoval = n.idnoval "
                + "where f.idLogin = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, uid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Noval n = new Noval();
                n.setIdNoval(rs.getInt("idnoval"));
                n.setName(rs.getString("namenoval"));
                n.setAuthor(rs.getString("author"));
                n.setSummary(rs.getString("summary"));
                n.setImg(rs.getString("img"));
                n.setDate(rs.getDate("date"));

                novals.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novals;
    }
     
      public void deletaNoval(int id) {
        try {
            String sql = " Delete from Favorite\n"
                     +  "where idnoval = ?";
           
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(NovalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
    }
      
//      public static void main(String[] args) {
//        FavoriteDAO dao = new FavoriteDAO();
//        dao.deletaNoval(1);
//    }
    
}

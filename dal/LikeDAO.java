/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Favourite;
import model.Noval;

/**
 *
 * @author Nekko
 */
public class LikeDAO extends BaseDAO {

    public void like(Favourite f) {
        try {
            String sql = "INSERT INTO [dbo].[Favorite]\n"
                    + "           ([idLogin]\n"
                    + "           ,[idnoval])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
             statement.setInt(1, f.getIdLogin());
            statement.setInt(2, f.getIdNoval());

            statement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(NovalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
//    public static void main(String[] args) {
//        LikeDAO fd = new LikeDAO();
//        Favourite f = new Favourite();
//        f.setIdLogin(1);
//        f.setIdNoval(1);
//        fd.like(f);  
//        
//    }

}

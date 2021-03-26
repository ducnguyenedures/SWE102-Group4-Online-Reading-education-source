/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nekko
 */
public class DeleteDAO extends BaseDAO{
    public void deletaNoval(int id) {
        
            String sql = " Delete from Favorite\n"
                     +  "where idnoval = ?";
           try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(NovalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

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
import model.Chapter;
import model.Noval;
import model.Type;

/**
 *
 * @author Uchitachi
 */
public class ChapterDAO extends BaseDAO {

    public void addChapter(Chapter c) {
        try {
            String sql = "INSERT INTO [dbo].[Chapter]\n"
                    + "           ([name]\n"
                    + "           ,[content]\n"
                    + "           ,[idn]\n"
                    + "           ,[numberofchap])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getName());
            statement.setString(2, c.getContent());
            statement.setInt(3, c.getIdn().getIdNoval());
            statement.setInt(4, c.getNumberofchapter());
            statement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(NovalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Chapter> getChapterInNoval(int id) {
        ArrayList<Chapter> chapters = new ArrayList<>();
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[content]\n"
                    + "      ,[idn]\n"
                    + "      ,[numberofchap]\n"
                    + "  FROM [dbo].[Chapter] where idn=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Chapter c = new Chapter();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setContent(rs.getString("content"));
                c.setNumberofchapter(rs.getInt("numberofchap"));

                Noval n = new Noval();
                n.setIdNoval(id);

                c.setIdn(n);

                chapters.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chapters;
    }

    public Chapter getChapter(int number, int id) {
        Chapter c = new Chapter();
        try {
            String sql = "SELECT c.id\n"
                    + "      ,c.name\n"
                    + "      ,c.content\n"
                    + "      ,c.idn\n"
                    + "      ,c.numberofchap\n"
                    + "	  , n.idnoval\n"
                    + "  FROM [dbo].Chapter c inner join Noval n on c.idn = n.idnoval "
                    + " where c.numberofchap = ? and n.idnoval=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, number);
            statement.setInt(2, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setContent(rs.getString("content"));
                c.setNumberofchapter(rs.getInt("numberofchap"));

                Noval n = new Noval();
                n.setIdNoval(id);

                c.setIdn(n);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public static void main(String[] args) {
        ChapterDAO cdb = new ChapterDAO();
        Chapter c = cdb.getChapter(1, 1);
        System.out.println(c);
    }

}

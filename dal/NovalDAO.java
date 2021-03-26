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
public class NovalDAO extends BaseDAO {

    public void addNoval(Noval n) {
        try {
            String sql = "INSERT INTO [dbo].[Noval]\n"
                    + "           ([namenoval]\n"
                    + "           ,[type]\n"
                    + "           ,[author]\n"
                    + "           ,[summary]\n"
                    + "           ,[img]\n"
                    + "           ,[date])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, n.getName());
            statement.setInt(2, n.getType().getId());
            statement.setString(3, n.getAuthor());
            statement.setString(4, n.getSummary());
            statement.setString(5, n.getImg());
            statement.setDate(6, n.getDate());
            statement.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(NovalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Noval> getNoval() {
        ArrayList<Noval> noval = new ArrayList<>();
        try {
            String sql = "SELECT n.idnoval , n.namenoval,n.type,n.author,"
                    + "n.summary,n.img,n.date, t.id, t.name "
                    + "FROM Noval n INNER JOIN Type t \n"
                    + "ON n.type = t.id";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Noval n = new Noval();
                n.setIdNoval(rs.getInt("idnoval"));
                n.setName(rs.getString("namenoval"));
                n.setAuthor(rs.getString("author"));
                n.setSummary(rs.getString("summary"));
                n.setImg(rs.getString("img"));
                n.setDate(rs.getDate("date"));

                Type t = new Type();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));

                n.setType(t);

                noval.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noval;
    }

    public ArrayList<Noval> getNovalName() {
        ArrayList<Noval> noval = new ArrayList<>();
        try {
            String sql = "SELECT idnoval, namenoval from Noval";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Noval n = new Noval();
                n.setIdNoval(rs.getInt("idnoval"));
                n.setName(rs.getString("namenoval"));
                noval.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return noval;
    }

    public Noval getNovalById(int id) {
        String sql = "SELECT n.idnoval\n"
                + "      ,n.namenoval\n"
                + "      ,n.type\n"
                + "      ,n.author\n"
                + "      ,n.summary\n"
                + "      ,n.img\n"
                + "      ,n.date\n"
                + "	  ,t.id\n"
                + "	  ,t.name\n"
                + "	  \n"
                + "  FROM [dbo].[Noval] n inner join Type t on n.type = t.id "
                + "where n.idnoval = ?";

        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Type t = new Type();
                t.setId(rs.getInt("id"));

                Noval n = new Noval();
                n.setName(rs.getString("namenoval"));
                n.setType(t);
                n.setAuthor(rs.getString("author"));
                n.setSummary(rs.getString("summary"));
                n.setImg(rs.getString("img"));
                n.setDate(rs.getDate("date"));

                return n;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NovalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Noval n) {
        try {
            String sql = "UPDATE [dbo].[Noval]\n"
                    + "   SET [namenoval] = ?\n"
                    + "      ,[type] = ?\n"
                    + "      ,[author] = ?\n"
                    + "      ,[summary] = ?\n"
                    + "      ,[img] = ?\n"
                    + "      ,[date] = ?\n"
                    + " WHERE idnoval = ?";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, n.getName());
            stm.setInt(2, n.getType().getId());
            stm.setString(3, n.getAuthor());
            stm.setString(4, n.getSummary());
            stm.setString(5, n.getImg());
            stm.setDate(6, n.getDate());
            stm.setInt(7, n.getIdNoval());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NovalDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public ArrayList<Noval> paging(int pagesize, int pageindex) {
        ArrayList<Noval> novals = new ArrayList<>();
        String sql = "SELECT idnoval,namenoval,type,author,summary,img,date  FROM \n"
                + "(SELECT ROW_NUMBER() OVER (ORDER BY idnoval ASC)\n"
                + "as rownum, *  FROM Noval) tbl\n"
                + "WHERE \n"
                + "rownum >= (? -1)*? + 1 AND rownum <= ? * ?";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Noval n = new Noval();
                n.setIdNoval(rs.getInt("idNoval"));
                n.setName(rs.getString("namenoval"));

                Type t = new Type();
                t.setId(rs.getInt("type"));
                n.setType(t);

                n.setAuthor(rs.getString("author"));
                n.setSummary(rs.getString("summary"));
                n.setImg(rs.getString("img"));
                n.setDate(rs.getDate("date"));

                novals.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NovalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novals;
    }

    public int count() {
        ArrayList<Noval> novals = new ArrayList<>();
        String sql = "SELECT COUNT(*) as total FROM Noval";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NovalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Noval> searchByName(String name) {
        ArrayList<Noval> novals = new ArrayList<>();
        String sql = "SELECT n.idnoval , n.namenoval,n.type,n.author,"
                + "n.summary,n.img,n.date, t.id, t.name "
                + "FROM Noval n INNER JOIN Type t \n"
                + "ON n.type = t.id"
                + " where namenoval like '%' + ? +'%'";
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Noval n = new Noval();
                n.setIdNoval(rs.getInt("idnoval"));
                n.setName(rs.getString("namenoval"));
                n.setAuthor(rs.getString("author"));
                n.setSummary(rs.getString("summary"));
                n.setImg(rs.getString("img"));
                n.setDate(rs.getDate("date"));

                Type t = new Type();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));

                n.setType(t);

                novals.add(n);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NovalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return novals;
    }
    
    public static void main(String[] args) {
        NovalDAO ndb = new NovalDAO();
        ArrayList<Noval> no = ndb.searchByName("T");
        for (Noval noval : no) {
            System.out.println(noval);
        }
    }

}

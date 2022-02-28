package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Slam;
import utility.ConnectionManager;

public class SlamDao {

    private final Connection con = ConnectionManager.getConnection();

    public int addSlam(Slam slam){
        int status = 0;

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO SLAM(to_whom, about_them, best_memories) values(?,?,?)");
            ps.setString(1,slam.getToWhom());  
            ps.setString(2,slam.getAboutThem());  
            ps.setString(3,slam.getBestMemories());  
            status=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return status;
    }

    public int updateSlam(Slam slam){
        int status = 0;

        PreparedStatement ps= null;
        try {
            ps =con.prepareStatement("UPDATE SLAM SET to_whom=?, about_them=?, best_memories=? where slam_id=?");  
            ps.setString(1,slam.getToWhom());  
            ps.setString(2,slam.getAboutThem());  
            ps.setString(3,slam.getBestMemories());  
            ps.setInt(4,slam.getSlamId());  
            
            status=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  finally {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } 
 
        return status;
    }

    public List<Slam> viewAllSlams(){
        List<Slam> slamList = null;

        try{  
            PreparedStatement ps=con.prepareStatement(
                "SELECT * FROM SLAM");  
            ResultSet rs=ps.executeQuery();  
            slamList = new ArrayList<Slam>();
            while(rs.next()){  
                Slam slam = new Slam();
                slam.setSlamId(rs.getInt("slam_id"));  
                slam.setToWhom(rs.getString("to_whom"));
                slam.setAboutThem(rs.getString("about_them"));
                slam.setBestMemories(rs.getString("best_memories"));
                slamList.add(slam);
            }  
        }catch(Exception e){System.out.println(e);}

        return slamList;
    }

    public Slam viewSlamById(int slamId){
        Slam slam = null;
        try{  
            PreparedStatement ps=con.prepareStatement(
                "SELECT * FROM SLAM WHERE slam_id=?");  
            ps.setInt(1,slamId);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                slam = new Slam();
                slam.setSlamId(rs.getInt("slam_id"));  
                slam.setToWhom(rs.getString("to_whom"));
                slam.setAboutThem(rs.getString("about_them"));
                slam.setBestMemories(rs.getString("best_memories"));
            }  
        }catch(Exception e){System.out.println(e);}  
        return slam;  
    }

   public Connection getCon() {
    return con;
}

 public int deleteSlamById(int slamId){
        int status=0;  
    try{  
        PreparedStatement ps=con.prepareStatement("DELETE FROM SLAM where slam_id=?");  
        ps.setInt(1,slamId);  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
    }
}
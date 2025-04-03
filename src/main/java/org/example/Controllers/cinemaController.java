package org.example.Controllers;

import jdk.jshell.spi.ExecutionControl;
import org.example.Database.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cinemaController {
    public void addCinema(int id, String name, String location){
        String sql = "INSERT INTO cinemas(id,name,location) VALUES(?,?,?)";
        try(PreparedStatement ps = DB.getConnection().prepareCall(sql))
        {
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setString(3,location);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteCinemaById(int id){
        String sql = "DELETE from cinemas WHERE id==?";
        try(PreparedStatement ps = DB.getConnection().prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Cinema with id: "+id+" successfully deleted");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void readCinema(){
        String sql = "SELECT * from cinemas";
        try(PreparedStatement ps = DB.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("id: "+rs.getInt(1)+" name: "+rs.getString(2)+" location: "+rs.getString(3));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

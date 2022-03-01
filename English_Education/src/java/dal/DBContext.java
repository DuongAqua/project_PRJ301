/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DBContext {

    private Connection connection;

    public DBContext() {
        try {
            String user = "sa";
            String pass = "123456";
            String url = "jdbc:sqlserver://LocalHost:1433;databaseName=English";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        DBContext db = new DBContext();
        
        System.out.println(""+ db.abc());
    }
    public int abc(){
        try {
            String sql ="select * from Guests ;"  ;
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
//    public ArrayList<Student> getStudents() {
//        ArrayList<Student> students = new ArrayList<>();
//        try {
//
//            String sql = "select * from student";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//
//            while (rs.next()) {
//                Student s = new Student();
//                s.setId(rs.getInt("id"));
//                s.setName(rs.getString("name"));
//                s.setGender(rs.getBoolean("gender"));
//                s.setDOB((rs.getDate("dob")));
//                s.setPhone(rs.getString("phone"));
//                students.add(s);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return students;
//    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDB extends DBContext{
    public static void main(String[] args) {
        AccountDB accDB = new AccountDB();
        System.out.println("" + accDB );
    }

    
   
    
    public ArrayList<Account> getStudents() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {

            String sql = "select * from Account a";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Account a = new Account();
                a.setId(rs.getInt("id"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setType(rs.getInt("type"));
                a.setCreate_at(rs.getString("create_at"));
                
                a.setFirstname(rs.getString("firstname"));
                a.setLastname(rs.getString("lastname"));
                a.setGender(rs.getBoolean("gender"));
                a.setDob((rs.getDate("dob")));
                a.setPhone(rs.getString("phone"));
                a.setImg(rs.getString("img"));
        
                        
                accounts.add(a);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return accounts;
    }
}

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
public class AccountDB extends DBContext {
    public static void main(String[] args) {
        AccountDB accDB = AccountDB();
        System.out.println("" + accDB );
    }

    private static AccountDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    String sql= "select * from Account a where a.Username like ?";
    
    public ArrayList<Account> getStudents() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {

            String sql = "select * from Account a";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Account a = new Account();
                a.setId(rs.getInt("id"));
                a.setFirstname(rs.getString("firstname"));
                a.setLastname(rs.getString("lastname"));
                a.setGender(rs.getBoolean("gender"));
                a.setDob((rs.getDate("dob")));
                a.setPhone(rs.getString("phone"));
                accounts.add(a);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return accounts;
    }
}

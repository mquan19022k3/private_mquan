/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class AccountDBContext extends DBContext{
   public Users getUserById(String id) {
       try {
           String sqlString = " select * from users where id=? ";
           
           PreparedStatement stm = connection.prepareStatement(sqlString);
           stm.setString(1, id);
           ResultSet rs = stm.executeQuery();
           while (rs.next()) {                
               Users u = new Users();
               u.setId(rs.getString(1));
               u.setAccount(rs.getString(2));
               u.setPass(rs.getString(3));
               u.setName(rs.getString(4));
               u.setEmail(rs.getString(5));  
               return u;
           }
       } catch (SQLException ex) {
           Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
}

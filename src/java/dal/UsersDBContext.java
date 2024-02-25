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
public class UsersDBContext extends DBContext{
    public Users checkLogin(String account, String pass) {
        try {
            String sql = "select * from users where account= ? and password= ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, account);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Users users = new Users();
                users.setId(rs.getString("id"));
                users.setAccount(rs.getString("account"));
                users.setPass(rs.getString("password"));
                users.setName(rs.getString("name"));
                users.setEmail(rs.getString("email"));
                return users;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

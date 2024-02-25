/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class Users extends DBContext {

    private String id, account, pass, name, email;

    public Users() {
        connectDB();
    }

    public Users(String id, String account, String pass, String name, String email) {
        this.id = id;
        this.account = account;
        this.pass = pass;
        this.name = name;
        this.email = email;
        connectDB();
    }

    public Users(String account, String pass, String name, String email) {
        this.account = account;
        this.pass = pass;
        this.name = name;
        this.email = email;
        connectDB();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    Connection cnn;
    PreparedStatement stm;
    ResultSet rs;

    private void connectDB() {
        cnn = connection;
        if (cnn != null) {
            System.out.println("Connect success");
        } else {
            System.out.println("Connect fail");
        }
    }

    public boolean addUsers() {
        try {
            String strSQL = "insert into users(account, password, name, email) values(?,?,?,?)";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, account);
            stm.setString(2, pass);
            stm.setString(3, name);
            stm.setString(4, email);
            stm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addUsers" + e.getMessage());
            return false;
        }
    }

    public boolean updateUsers(String id) {
        try {
            String strSQL = "update users set name=? , password=? , email=?, account= ? where id=? ";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, name);
            stm.setString(2, pass);
            stm.setString(3, email);
            stm.setString(4, account);
            stm.setString(5, id);
            stm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updateUsers:" + e.getMessage());
            return false;
        }
    }
    public void getUserById(String id) {
        try {
            String strSQL=" select * from users where id=?";
            stm=cnn.prepareStatement(strSQL);
            stm.setInt(1, Integer.parseInt(id));
            rs=stm.executeQuery();
            while(rs.next()){
                this.id=rs.getString(1);
                this.account=rs.getString(2);
                pass=rs.getString(3);
                name=rs.getString(4);
                email=rs.getString(5);
                
            }
        } catch (Exception e) {
            System.out.println("getUserById:"+e.getMessage());
        }
    }
}

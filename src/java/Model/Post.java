/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Post extends DBContext {

    private String id, user_id, title, content, created_at, category_id, tag_id, publicstatus;

    public Post() {
        connectDB();
    }

    public Post(String user_id, String title, String content, String created_at) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        connectDB();
    }

    public Post(String user_id, String title, String content, String created_at, String category_id, String tag_id) {
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.category_id = category_id;
        this.tag_id = tag_id;
        connectDB();
    }

    public Post(String id, String user_id, String title, String content, String created_at, String category_id, String tag_id) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.category_id = category_id;
        this.tag_id = tag_id;
        connectDB();
    }

    public Post(String id, String user_id, String title, String content, String created_at, String category_id, String tag_id, String publicstatus) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.category_id = category_id;
        this.tag_id = tag_id;
        this.publicstatus = publicstatus;
        connectDB();
    }

    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getPublicstatus() {
        return publicstatus;
    }

    public void setPublicstatus(String publicstatus) {
        this.publicstatus = publicstatus;
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

    public boolean createPost() {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        try {
            String strSQL = "insert into posts(user_id, title, content, created_at, category_id, tag_id) values(?,?,?,?,?,?)";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, user_id);
            stm.setString(2, title);
            stm.setString(3, content);
            stm.setString(4, date);
            stm.setString(5, category_id);
            stm.setString(6, tag_id);
            stm.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean draftPost() {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try {
            String strSQL = "insert into drafts(user_id, title, content, created_at, category_id, tag_id) values(?,?,?,?,?,?)";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, user_id);
            stm.setString(2, title);
            stm.setString(3, content);
            stm.setString(4, created_at);
            stm.setString(5, category_id);
            stm.setString(6, tag_id);
            stm.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Category> getListCategory() {
        ArrayList<Category> data = new ArrayList<Category>();
        try {
            String strSQL = "select * from categories";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                Category c = new Category(id, name);
                data.add(c);
            }
        } catch (Exception e) {
            System.out.println("getListCategory:" + e.getMessage());
        }
        return data;
    }

    public ArrayList<Tag> getListTag() {
        ArrayList<Tag> data = new ArrayList<Tag>();
        try {
            String strSQL = "select * from tags";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                Tag t = new Tag(id, name);
                data.add(t);
            }
        } catch (Exception e) {
            System.out.println("getListTag:" + e.getMessage());
        }
        return data;
    }
    
    public ArrayList<Users> getListUser() {
        ArrayList<Users> data = new ArrayList<Users>();
        try {
            String strSQL = "select * from users";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String account = rs.getString(2);
                String pass = rs.getString(3);
                String name = rs.getString(4);
                String email = rs.getString(5);
                Users u = new Users(id, account, pass, name, email);
                data.add(u);
            }
        } catch (Exception e) {
            System.out.println("getListTag:" + e.getMessage());
        }
        return data;
    }

    public ArrayList<Post> getListPost(String uid) {
        ArrayList<Post> data = new ArrayList<Post>();
        try {
            String strSQL = "   select p.id, p.user_id, p.title, p.content, p.created_at, c.name, t.name from \n"
                    + "  posts p join categories c on p.category_id = c.id\n"
                    + "  join tags t on p.tag_id = t.id\n"
                    + "  where user_id=? ";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, uid);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String created_at = String.valueOf(rs.getDate(5));
                String category = rs.getString(6);
                String tag = rs.getString(7);
                Post p = new Post(id, uid, title, content, created_at, category, tag);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListProduct:" + e.getMessage());
        }
        return data;
    }

    public void getPostById(String id) {
        try {
            String strSQL = " select p.id, p.user_id, p.title, p.content, p.created_at, c.name, t.name from "
                    + "posts p join categories c on p.category_id = c.id "
                    + "join tags t on p.tag_id = t.id "
                    + "where p.id=? ";
            stm = cnn.prepareStatement(strSQL);
            stm.setInt(1, Integer.parseInt(id));
            rs = stm.executeQuery();
            while (rs.next()) {
                this.id = rs.getString(1);
                this.user_id = rs.getString(2);
                title = rs.getString(3);
                content = rs.getString(4);
                created_at = String.valueOf(rs.getDate(5));
                category_id = rs.getString(6);
                tag_id = rs.getString(7);
            }
        } catch (Exception e) {
            System.out.println("getPostById:" + e.getMessage());
        }
    }

    public void deletePost(String id) {
        try {
            String strSQL = "delete from posts where id=?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, id);
            stm.execute();
        } catch (Exception e) {
            System.out.println("deletePost:" + e.getMessage());
        }
    }

    public boolean updatePost() {
        try {
            String strSQL = "update posts set title=?, content=?, created_at=?, category_id=?, tag_id=?, statusPublic=?  where id=? ";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, title);
            stm.setString(2, content);
            stm.setString(3, created_at);
            stm.setString(4, category_id);
            stm.setString(5, tag_id);
            stm.setString(6, publicstatus);
            stm.setString(7, id);
            stm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updatePost:" + e.getMessage());
            return false;
        }
    }
    public ArrayList<Post> getPostPublic() {
        ArrayList<Post> data = new ArrayList<Post>();
        try {
            String strSQL = " select p.id, u.name, p.title, p.content, p.created_at, c.name, t.name from \n" +
"                    posts p join categories c on p.category_id = c.id \n" +
"                    join tags t on p.tag_id = t.id \n" +
"		     join users u on p.user_id = u.id\n" +
"                    where p.statusPublic=1";
            stm = cnn.prepareStatement(strSQL);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String uid = rs.getString(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String created_at = String.valueOf(rs.getDate(5));
                String category= rs.getString(6);
                String tag = rs.getString(7);
                Post p = new Post(id, uid, title, content, created_at, category, tag);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getPostPublic:" + e.getMessage());
        }
        return data;
    }
    public ArrayList<Post> getListDraft(String uid) {
        ArrayList<Post> data = new ArrayList<Post>();
        try {
            String strSQL = "   select d.draft_id, d.user_id, d.title, d.content, d.created_at, c.name, t.name from drafts d "
                    + "join categories c on d.category_id= c.id\n"
                    + "  join tags t on d.tag_id = t.id "
                    + "where d.user_id=?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, uid);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String created_at = String.valueOf(rs.getDate(5));
                String category = rs.getString(6);
                String tag = rs.getString(7);
                Post p = new Post(id, uid, title, content, created_at, category, tag);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListDraft:" + e.getMessage());
        }
        return data;
    }

    public void deleteDraft(String id) {
        try {
            String strSQL = " delete from drafts where draft_id=?";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, id);
            stm.execute();
        } catch (Exception e) {
            System.out.println("deletDraft:" + e.getMessage());
        }
    }

    public boolean addToDiary(String id) {
        try {
            String strSQL = " insert into posts(user_id, title, content, created_at, category_id, tag_id)\n"
                    + "  select user_id, title, content, created_at, category_id, tag_id from drafts where draft_id=? ";
            stm = cnn.prepareStatement(strSQL);
            stm.setString(1, id);
            stm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addToDiary:" + e.getMessage());
            return false;
        }
    }
}

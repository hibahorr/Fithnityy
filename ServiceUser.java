/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataBase.DataBase;
import Entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import utils.BCrypt;

/**
 *
 * @author HIBA
 */
public class ServiceUser {
    Connection con;
    public static User userStatic = null;

    public ServiceUser() {
     //           con = DataBase.getInstance().getConnection();

        con = DataBase.getInstance().getConnection();
    }

    public void delete(Integer id) {
        String req = "delete from  user where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void register(User u) {
        String req = "INSERT INTO `fithnity`.`user`(username,username_canonical,email,email_canonical,enabled,password,nom,prenom,date_naissance,cin,adresse,roles) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.setString(2, u.getUsername());
            preparedStatement.setString(3, u.getEmail());
            preparedStatement.setString(4, u.getEmail());
            preparedStatement.setInt(5, u.getEnabled());
            preparedStatement.setString(6, u.getPassword());
            preparedStatement.setString(7, u.getNom());
            preparedStatement.setString(8, u.getPrenom());
            preparedStatement.setDate(9, u.getDateNaissance());
            preparedStatement.setString(10, u.getCin());
            preparedStatement.setString(11, u.getAdresse());
            preparedStatement.setString(12, u.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    public boolean Login(String username, String password) {
        boolean exist = false;
        String req = "select * from user where username=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                exist = true;
                String psw = resultSet.getString("password");
                boolean matched = BCrypt.checkpw(password, psw);
                if (!matched) {
                    exist = false;
                } else {
                    String role = resultSet.getString("roles").substring(15, resultSet.getString("roles").length() - 3);
                    userStatic = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getInt("enabled"), resultSet.getString("password"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getDate("date_naissance"), resultSet.getString("cin"), resultSet.getString("adresse"), role);
                   // Profil p = new Profil( new UserService().getUserById(userStatic.getId()), "Entrer la matière", "Editer votre description", "Préciser votre classe", "file:C:\\wamp\\www\\Photo\\images.jpg", "file:C:\\wamp\\www\\Photo\\3b82d38cdcad9e55a7afafac7add1355.jpg", "", "", "", "", "");
                   // ProfilService profilService = new ProfilService();
                  //  Profil p1=profilService.getByUserId(userStatic.getId());
                  //  if(p1 ==null){
                  //     profilService.add(p); 
                  //  }  
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return exist;
    }
       public boolean chercherUsername(String username) {
        boolean test = false;
        String req = "select * from user where username=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareCall(req);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                test = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return test;
    }
       
    

  
    public void disable(User u) {
        String req = "update user set enabled=? where username=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, u.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void enable(User u) {
        String req = "update user set enabled=? where username=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, u.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public User search(User u) {
        return u;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String req = "select * from user";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user;
                user = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getInt("enabled"), resultSet.getString("password"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getDate("date_naissance"), resultSet.getString("cin"), resultSet.getString("adress"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public User getUserById(Integer i) {
        String req = "select * from user where id=?";
        User u = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                u = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getInt("enabled"), resultSet.getString("password"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getDate("date_naissance"), resultSet.getString("cin"), resultSet.getString("adresse"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return u;
    }

    

    public boolean chercherEmail(String email) {
        boolean test = false;
        String req = "select * from user where email=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareCall(req);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                test = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return test;
    }

    public boolean chercherCIN(String cin) {
        boolean test = false;
        String req = "select * from user where cin=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareCall(req);
            preparedStatement.setString(1, cin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                test = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return test;
    }

    

 
   

  
 }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataBase.DataBase;
import Entity.Transportation;
import Entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author HIBA
 */
public class ServiceTransportation {
    Connection connection;

    public ServiceTransportation() {
        connection = DataBase.getInstance().getConnection();
    }

    public void delete(Integer r) {
        String req = "delete from transportation where id=? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public List<Transportation> getAll() {
        List<Transportation> covoiturages = new ArrayList<>();
        String req = "select * from transportation";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transportation c = new Transportation(resultSet.getInt("id"), new ServiceUser().getUserById(resultSet.getInt("id_user")), resultSet.getDouble("prix_transportation"), resultSet.getString("ville_depart"), resultSet.getString("ville_arrivee"),resultSet.getString("description"),resultSet.getInt("poids"), resultSet.getDate("date_depart"),resultSet.getString("voiture"));
                covoiturages.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return covoiturages;
    }

   
    public Transportation getById(Integer r) {
        String req = "select * from transportation where id=?";
        Transportation c = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 c = new Transportation(resultSet.getInt("id"), new ServiceUser().getUserById(resultSet.getInt("id_user")), resultSet.getDouble("prix_transportation"), resultSet.getString("ville_depart"), resultSet.getString("ville_arrive"),resultSet.getString("description"),resultSet.getInt("poids"), resultSet.getDate("date_depart"),resultSet.getString("voiture"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return c;
    }

    public List<Transportation> getByUserId(Integer id) {
        String req = "select * from transportation where user_id=?";
        List<Transportation> covoiturages= new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transportation c = new Transportation(resultSet.getInt("id"), new ServiceUser().getUserById(resultSet.getInt("id_user")), resultSet.getDouble("prix_transportation"), resultSet.getString("ville_depart"), resultSet.getString("ville_arrive"),resultSet.getString("description"),resultSet.getInt("poids"), resultSet.getDate("date_depart"),resultSet.getString("voiture"));
                 covoiturages.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return covoiturages;
    }


    public void update(Transportation t) {
        String req = "update transportation set id_user=?,prix=?,depart=?,arrive=?,descriptionv,Livraison_Express=?,poids=?,heure_depart=?,voiture where id=?";
        PreparedStatement preparedStatement;
        try {

           preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getU().getId());
            preparedStatement.setDouble(2, t.getPrix_Transportation());
            preparedStatement.setString(3, t.getVille_depart());
            preparedStatement.setString(4, t.getVille_arrivé());
            preparedStatement.setString(5, t.getDescription());
            preparedStatement.setInt(6, t.getPoids());
             preparedStatement.setInt(7, t.getLivraison_Express());
            preparedStatement.setDate(8, t.getDate_depart());
            preparedStatement.setString(9, t.getVoiture());
          //  preparedStatement.setInt(10, t.getB().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

  
    public void add(Transportation t) {
        String req = "insert into transportation(id_user,Prix_Transportation,Ville_depart,Ville_arrivee,description,poids,Date_depart,voiture) values (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
         preparedStatement.setInt(1, t.getU().getId());
            preparedStatement.setDouble(2, t.getPrix_Transportation());
            preparedStatement.setString(3, t.getVille_depart());
            preparedStatement.setString(4, t.getVille_arrivé());
            preparedStatement.setString(5, t.getDescription());
            preparedStatement.setInt(6, t.getPoids());
            preparedStatement.setDate(7, t.getDate_depart());
            preparedStatement.setString(8, t.getVoiture());
            //preparedStatement.setInt(10, t.getB().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public Transportation search(Transportation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

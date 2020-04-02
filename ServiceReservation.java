/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataBase.DataBase;
import Entity.ReserverTransportation;
import Entity.Transportation;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIBA
 */
public class ServiceReservation {
    Connection connection;

 
    public ReserverTransportation search(ServiceReservation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public ReserverTransportation getById(Integer r) {
        String req = "select * from  reservation_transportation  where id=?";
        ReserverTransportation ReserverTransportation = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ReserverTransportation = new ReserverTransportation(resultSet.getInt("id"), new Transportation(resultSet.getInt("Transportation_id")), new ServiceUser().getUserById(resultSet.getInt("user_id")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ReserverTransportation;
    }

    
    public List<ReserverTransportation> getAll() {
        List<ReserverTransportation> reserverTransportation = new ArrayList<>();
        String req = "select * from reservation_transportation";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ReserverTransportation reserver = new ReserverTransportation(resultSet.getInt("id"), new Transportation(resultSet.getInt("transportation_id")), new ServiceUser().getUserById(resultSet.getInt("id_user")));
                reserverTransportation.add(reserver);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reserverTransportation;
    }

 
    public void delete(Integer r) {
        String req = "DELETE FROM reservation_transportation WHERE transportation_id = ? and user_id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.setInt(2, ServiceUser.userStatic.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

 
    public void update(ReserverTransportation t) {
        String req = "update reservation_transportation set transportation_id=?,user_id=? where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getTransportation().getId());
            preparedStatement.setInt(2, t.getU().getId());
            preparedStatement.setInt(3, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

 
    public void add(ReserverTransportation t) {
        String req = "insert into reservation_transportation (transportation_id,user_id) values (?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getTransportation().getId());
            preparedStatement.setInt(2, t.getU().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getCouvoiturageCount(Transportation transportation) {
        int count=0;
        String req = "SELECT COUNT(*) AS count FROM `transportation` WHERE `id` = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, transportation.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
            count = resultSet.getInt("count");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }
    public boolean getUserCouvoiturage(Transportation transportation,User user) {
        Boolean participe=false;
        String req = "SELECT * FROM `transportation` WHERE `id`= ? and `id_user`= ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, transportation.getId());
            preparedStatement.setInt(2, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               participe=true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return participe;
    }
}

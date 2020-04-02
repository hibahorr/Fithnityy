/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;
import java.util.Objects;
import javafx.scene.control.ComboBox;

/**
 *
 * @author HIBA
 */
public class ReserverTransportation {

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReserverTransportation other = (ReserverTransportation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Transportation, other.Transportation)) {
            return false;
        }
        if (!Objects.equals(this.u, other.u)) {
            return false;
        }
        return true;
    }

   

    public ReserverTransportation(Transportation Transportation, User u) {
        this.Transportation = Transportation;
        this.u = u;
    }

    public ReserverTransportation(int id, Transportation Transportation, User u) {
        this.id = id;
        this.Transportation = Transportation;
        this.u = u;
    }
      private int id;
    private Transportation Transportation;
    private User u;
     public ReserverTransportation(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transportation getTransportation() {
        return Transportation;
    }

    public void setTransportation(Transportation Transportation) {
        this.Transportation = Transportation;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
  

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author HIBA
 */
public class Transportation {
     private int id;
    private Entity.User u;
    private double Prix_Transportation;
    private String ville_depart;
    private String ville_arrivé;
    private String description;
    private int poids;
    private int Livraison_Express;
    private Entity.Biens b ;
    private Date date_depart;
    private String Voiture;

    public Transportation(int id, User u, double Prix_Transportation, String ville_depart, String ville_arrivé, String description, int poids, int Livraison_Express, Biens b, Date date_depart, String Voiture) {
        this.id = id;
        this.u = u;
        this.Prix_Transportation = Prix_Transportation;
        this.ville_depart = ville_depart;
        this.ville_arrivé = ville_arrivé;
        this.description = description;
        this.poids = poids;
        this.Livraison_Express = Livraison_Express;
        this.b = b;
        this.date_depart = date_depart;
        this.Voiture = Voiture;
    }

    public Transportation(User u, double Prix_Transportation, String ville_depart, String ville_arrivé, String description, int poids, Date date_depart, String Voiture) {
        this.u = u;
        this.Prix_Transportation = Prix_Transportation;
        this.ville_depart = ville_depart;
        this.ville_arrivé = ville_arrivé;
        this.description = description;
        this.poids = poids;
        this.date_depart = date_depart;
        this.Voiture = Voiture;
    }

    public Transportation(int id, User u, double Prix_Transportation, String ville_depart, String ville_arrivé, String description, int poids, Date date_depart, String Voiture) {
        this.id = id;
        this.u = u;
        this.Prix_Transportation = Prix_Transportation;
        this.ville_depart = ville_depart;
        this.ville_arrivé = ville_arrivé;
        this.description = description;
        this.poids = poids;
        this.date_depart = date_depart;
        this.Voiture = Voiture;
    }

    public Transportation(User u, double Prix_Transportation, String ville_depart, String ville_arrivé, Date date_depart) {
        this.u = u;
        this.Prix_Transportation = Prix_Transportation;
        this.ville_depart = ville_depart;
        this.ville_arrivé = ville_arrivé;
        this.date_depart = date_depart;
    }

    public Transportation(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public Transportation(User u, double Prix_Transportation, String ville_depart, String ville_arrivé, String description, int poids, String Voiture) {
        this.u = u;
        this.Prix_Transportation = Prix_Transportation;
        this.ville_depart = ville_depart;
        this.ville_arrivé = ville_arrivé;
        this.description = description;
        this.poids = poids;
        this.Voiture = Voiture;
    }

    public double getPrix_Transportation() {
        return Prix_Transportation;
    }

    public void setPrix_Transportation(double Prix_Transportation) {
        this.Prix_Transportation = Prix_Transportation;
    }

    public String getVille_depart() {
        return ville_depart;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public String getVille_arrivé() {
        return ville_arrivé;
    }

    public void setVille_arrivé(String ville_arrivé) {
        this.ville_arrivé = ville_arrivé;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getLivraison_Express() {
        return Livraison_Express;
    }

    public void setLivraison_Express(int Livraison_Express) {
        this.Livraison_Express = Livraison_Express;
    }

    public Biens getB() {
        return b;
    }

    public void setB(Biens b) {
        this.b = b;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public String getVoiture() {
        return Voiture;
    }

    public void setVoiture(String Voiture) {
        this.Voiture = Voiture;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Transportation other = (Transportation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.Prix_Transportation) != Double.doubleToLongBits(other.Prix_Transportation)) {
            return false;
        }
        if (this.poids != other.poids) {
            return false;
        }
        if (this.Livraison_Express != other.Livraison_Express) {
            return false;
        }
        if (!Objects.equals(this.ville_depart, other.ville_depart)) {
            return false;
        }
        if (!Objects.equals(this.ville_arrivé, other.ville_arrivé)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.Voiture, other.Voiture)) {
            return false;
        }
        if (!Objects.equals(this.u, other.u)) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        if (!Objects.equals(this.date_depart, other.date_depart)) {
            return false;
        }
        return true;
    }

    public Transportation(int id, User u) {
        this.id = id;
        this.u = u;
    }
    
   
    
}

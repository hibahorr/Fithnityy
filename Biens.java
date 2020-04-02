/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author HIBA
 */
public class Biens {
    private int id;
    private String Type_colis;

    public Biens(String Type_colis, Double poids, int fragile, String description) {
        this.Type_colis = Type_colis;
        this.poids = poids;
        this.fragile = fragile;
        this.description = description;
    }
    private Double poids ;
    private int fragile;
    private String description;

    public Biens(int id, String Type_colis, Double poids, int fragile, String description) {
        this.id = id;
        this.Type_colis = Type_colis;
        this.poids = poids;
        this.fragile = fragile;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_colis() {
        return Type_colis;
    }

    public void setType_colis(String Type_colis) {
        this.Type_colis = Type_colis;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public int getFragile() {
        return fragile;
    }

    public void setFragile(int fragile) {
        this.fragile = fragile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}

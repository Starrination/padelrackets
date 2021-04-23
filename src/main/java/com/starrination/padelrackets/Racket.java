package com.starrination.padelrackets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Racket {
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Integer id;

    private String brand;
    private String model;
    private String version;
    
    public Racket() {
       
    }

    public Racket(String brand, String model, String version) {
        this.brand = brand;
        this.model = model;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Racket{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}

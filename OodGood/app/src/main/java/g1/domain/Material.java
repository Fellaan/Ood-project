package g1.domain;

import java.io.Serializable;

public class Material implements Serializable {

    String name;
    String recyclingCategory;
    double emissionFactor;    // Tidigare "int environmentalImpact";  (kg CO₂e per kg)

    public Material(String name, String recyclingCategory, double emissionFactor){
        this.name = name;
        this.recyclingCategory = recyclingCategory;
        this.emissionFactor = emissionFactor;     //(kg CO₂e per kg)

    }

    public String getName(){
        return name;
    }

    public String getRecyclingCategory(){
        return recyclingCategory;
    }

    public double getEmissionFactor(){
        return emissionFactor;          //Konstanten för utsläpp för respektive ämne
    }

}

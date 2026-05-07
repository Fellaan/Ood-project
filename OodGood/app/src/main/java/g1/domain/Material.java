package g1.domain;

import java.io.Serializable;

public class Material implements Serializable {

    String name;
    String recyclingCategory;
    double emissionFactor;

    public Material(String name, String recyclingCategory, double emissionFactor){
        this.name = name;
        this.recyclingCategory = recyclingCategory;
        this.emissionFactor = emissionFactor;

    }

    public String getName(){
        return name;
    }

    public String getRecyclingCategory(){
        return recyclingCategory;
    }

    public double getEmissionFactor(){
        return emissionFactor;
    }

}

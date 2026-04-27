package g1.domain;

import java.io.Serializable;

public class Material implements Serializable {

    String name;
    String recyclingCategory;
    int environmentalImpact;

    public Material(String name, String recyclingCategory, int environmentalImpact){
        this.name = name;
        this.recyclingCategory = recyclingCategory;
        this.environmentalImpact = environmentalImpact;

    }

    public String getName(){
        return name;
    }

    public String getrecyclingCategory(){
        return recyclingCategory;
    }

    public int getenvironmentalImpact(){
        return environmentalImpact;
    }

}

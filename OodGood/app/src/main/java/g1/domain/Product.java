package g1.domain;

import java.util.HashMap;

public class Product {

    String name;
    String category;
    HashMap<Material, Double> materials;
    int lifespan;

    public Product(String name, HashMap<Material, Double> materials, int lifespan, String category){
        this.name = name;
        this.materials = materials;
        this.lifespan = lifespan;
        this.category = category;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }
    
    public int getLifespan(){
        return lifespan;
    }

    public HashMap<Material, Double> getMaterials(){ 
        return materials;                          
    
    }
}


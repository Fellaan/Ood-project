package g1.domain;

import java.io.Serializable;
import java.util.HashMap;

public class Product implements Serializable{

    String name;
    CategoryEnum category;
    HashMap<Material, Double> materials;
    int lifespan;

    public Product(String name, HashMap<Material, Double> materials, int lifespan){
        this.name = name;
        this.materials = materials;
        this.lifespan = lifespan;
        this.category = RecyclingGuidance.getGuidance(materials); 
    }

    public String getName(){
        return name;
    }

    public CategoryEnum getCategory(){
        return category;
    }

    public String getCategoryInstruction(){
        return category.getInstruction();
    }
    
    public int getLifespan(){
        return lifespan;
    }

    public HashMap<Material, Double> getMaterials(){ 
        return materials;                          
    
    }
}


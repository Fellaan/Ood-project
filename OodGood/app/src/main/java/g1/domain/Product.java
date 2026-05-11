package g1.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;

public class Product implements Serializable{

    String name;
    CategoryEnum category;
    HashMap<Material, Double> materials;
    int lifespan;

    public Product(String name, HashMap<Material, Double> materials, int lifespan){
        this.name = name;
        this.materials = materials;
        this.lifespan = lifespan;

        ArrayList<Material> materialObjects = new ArrayList<>();
        for (HashMap.Entry<Material, Double> m : materials.entrySet()){
            materialObjects.add(m.getKey());
        }

        this.category = RecyclingGuidance.getGuidance(materialObjects); 
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


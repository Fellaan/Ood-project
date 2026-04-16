package g1.domain;

import java.util.ArrayList;

public class Product {

    String name;
    //Listan kommer innehålla records, inte string.
    ArrayList<String> materials;
    int lifespan;

    public Product(String name, ArrayList<String> materials, int lifespan){
        this.name = name;
        this.materials = materials;
        this.lifespan = lifespan;
    }

}

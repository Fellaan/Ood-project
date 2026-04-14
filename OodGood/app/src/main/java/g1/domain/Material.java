package g1.domain;

public class Material {

    String name;
    String recyclingCategory;
    int environmentalImpact;

    public Material(String name, String recyclingCategory, int environmentalImpact){
        this.name = name;
        this.recyclingCategory = recyclingCategory;
        this.environmentalImpact = environmentalImpact;
        System.out.println("Domain Material");

    }

    public String getName(){
        return name;
    }

}

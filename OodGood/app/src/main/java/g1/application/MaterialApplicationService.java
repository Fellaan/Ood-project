package g1.application;

import g1.domain.Material;


public class MaterialApplicationService {

public Material createMaterial(){
Material material = new Material("plast","Plast", 10 );
System.out.println("Service material");
return material;
}

public String showName(){
    Material material = new Material("Boll","Plast", 10 );
    System.out.println("Service material");
    String name = material.getName();
    return name;
}

}

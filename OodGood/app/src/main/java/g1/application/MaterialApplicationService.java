package g1.application;

public class MaterialApplicationService {

    Repository materialRepository;


public MaterialApplicationService(Repository materialRepository){

this.materialRepository = materialRepository;
    
}
// Method will be finished later
public String createMaterial(String name, String category, int EnvironmentalImpact){
    


    return "Created Material";
}


// Method will be finished later
public String removeMaterial(String name){

    return "Removed Material";
}



// Method will be finished later 
public String listMaterials(){

    return "List of materials";

}
// Method will be finished later 
public String showInfo(String name){

    return "Showing info";
}



}

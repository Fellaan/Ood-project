package g1.application;

import g1.domain.CategoryEnum;
import g1.domain.Material;
import g1.infrastructure.MaterialRepository;
import java.io.IOException;

import java.util.List;

public class MaterialApplicationService {

    private final MaterialRepository materialRepository;


public MaterialApplicationService(MaterialRepository materialRepository){

    this.materialRepository = materialRepository;
    
}
// Method will be finished later
public MaterialDto createMaterial(CreateMaterialRequest request) throws SaveErrorException, IOException{
    Material material = new Material(
        request.name(),
        CategoryEnum.valueOf(request.recyclingCategory()),
        request.emissionFactor()
    );
    materialRepository.add(material); // Sparar materialet i repon
    try {
        materialRepository.save();
    } catch (SaveErrorException e) {
    throw e;
}
    return new MaterialDto( // Returerar ett record som används av menyn för att kunna använda prints
        material.getName(),
        material.getRecyclingCategory().toString(),
        material.getEmissionFactor()
    );
}


// Method will be finished later
public MaterialDto removeMaterial(String name) throws IOException, SaveErrorException{
    Material material = materialRepository.findByName(name);
        
    materialRepository.remove(material); // Tar bort materialet i repon
    try {
        materialRepository.save();
    } catch (SaveErrorException e) {
        throw e;
    }

    return new MaterialDto( // Returerar record till MaterialMenu
        material.getName(),
        material.getRecyclingCategory().toString(),
        material.getEmissionFactor()
    );
}



// Method will be finished later 
public List<MaterialDto> listMaterials(){
    // Hämtar alla Material‑objekt från lagret och omvandlar dem till en lista av MaterialDto
    return materialRepository.findAll()
            // Gör om listan till en stream så att vi kan behandla varje objekt i en pipeline
            .stream()
            // Omvandlar varje Material‑objekt till ett MaterialDto‑objekt
            .map(m -> new MaterialDto(
                m.getName(),
                m.getRecyclingCategory().toString(),
                m.getEmissionFactor()
            ))
            // Samlar tillbaka resultatet till en vanlig lista
            .toList();

}
// Method will be finished later 
public MaterialDto showInfo(String name){
    Material material = materialRepository.findByName(name);

    try {
    return new MaterialDto(
        material.getName(),
        material.getRecyclingCategory().toString(),
        material.getEmissionFactor()
    );
} catch (NullPointerException e) {
    throw e;
}
}

public boolean checkMaterial(String name){
    return materialRepository.findByName(name) != null;
}

public boolean categoryExists(String name){
    try {
        CategoryEnum.valueOf(name);
        return true;
    } catch (IllegalArgumentException e) {
        return false;
    }
}

}

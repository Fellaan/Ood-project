package g1.domain;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RecyclingGuidance {

    public static CategoryEnum getGuidance(HashMap<Material, Double> materials){
        
        Set<CategoryEnum> categorySet = new HashSet<>();
            
        materials.keySet()
        .stream()
        .map(Material::getRecyclingCategory)
        .forEach(categorySet::add);
        
        if (categorySet.size() == 1){
            return categorySet.iterator().next();
        }
        else{
            return CategoryEnum.MixedMaterial; //Finns det material med olika categories så blir kategorien Mixed Material.
        }
    }
}

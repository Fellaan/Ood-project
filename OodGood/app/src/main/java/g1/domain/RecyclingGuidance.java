package g1.domain;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecyclingGuidance {

    public static CategoryEnum getGuidance(ArrayList<Material> materials){
        //Skapar en set som innehåller alla unika recycling categories produktens material består av
        Set<CategoryEnum> categorySet = new HashSet<>();
            
        for (Material m : materials){
            categorySet.add(m.getRecyclingCategory());
        }

        // Om endast en category finns bland alla material i produkten returneras den categoryn.
        if (categorySet.size() == 1){
            return categorySet.iterator().next();
        }

        else{
            return CategoryEnum.MixedMaterial; //Finns det material med olika categories så blir kategorien Mixed Material.
        }

    }
}

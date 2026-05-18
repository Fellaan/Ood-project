import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import g1.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RecyclingGuidanceTest {
    HashMap<Material, Double> mapOfDifferentMaterialsAndCategories = new HashMap<>();
    HashMap<Material, Double> mapWithOneMaterial = new HashMap<>();
    HashMap<Material, Double> mapOfMultipleMaterialsAndSameCategory = new HashMap<>();

    
    @BeforeAll 
    void setup(){
        Material Wood = new Material("Wood", CategoryEnum.Combustible, 10);
        Material Aluminium = new Material("Aluminium", CategoryEnum.Metal, 20);
        Material Plastic = new Material("Plastic", CategoryEnum.Plastic, 5);
        Material Tungsten = new Material("Tungsten", CategoryEnum.Metal, 50);

        mapOfDifferentMaterialsAndCategories.put(Wood, 10.0);
        mapOfDifferentMaterialsAndCategories.put(Aluminium, 10.0);
        mapOfDifferentMaterialsAndCategories.put(Plastic, 10.0);

        mapWithOneMaterial.put(Wood, 10.0);

        mapOfMultipleMaterialsAndSameCategory.put(Tungsten, 10.0);
        mapOfMultipleMaterialsAndSameCategory.put(Aluminium, 10.0);

    }

    @Test void ShouldReturnMixedMaterials(){

        CategoryEnum category = RecyclingGuidance.getGuidance(mapOfDifferentMaterialsAndCategories);

        assertEquals(CategoryEnum.MixedMaterial, category);
        assertNotNull(category);
    }


    @Test void ShouldReturnCombustibleCategory(){

        CategoryEnum category = RecyclingGuidance.getGuidance(mapWithOneMaterial);

        assertEquals(CategoryEnum.Combustible, category);
        assertNotNull(category);
    }

    @Test void ShouldReturnMetalCategory(){

        CategoryEnum category = RecyclingGuidance.getGuidance(mapOfMultipleMaterialsAndSameCategory);

        assertEquals(CategoryEnum.Metal, category);
        assertNotNull(category);
    }

}

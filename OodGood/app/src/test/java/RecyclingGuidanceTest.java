import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import g1.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RecyclingGuidanceTest {
    ArrayList<Material> listOfDifferentMaterialsAndCategories = new ArrayList<>();
    ArrayList<Material> listWithOneMaterial = new ArrayList<>();
    ArrayList<Material> listOfMultipleMaterialsAndSameCategory = new ArrayList<>();

    
    @BeforeAll 
    void setup(){
        Material Wood = new Material("Wood", CategoryEnum.Combustible, 10);
        Material Aluminium = new Material("Aluminium", CategoryEnum.Metal, 20);
        Material Plastic = new Material("Plastic", CategoryEnum.Plastic, 5);
        Material Tungsten = new Material("Tungsten", CategoryEnum.Metal, 50);

        listOfDifferentMaterialsAndCategories.add(Wood);
        listOfDifferentMaterialsAndCategories.add(Aluminium);
        listOfDifferentMaterialsAndCategories.add(Plastic);

        listWithOneMaterial.add(Wood);

        listOfMultipleMaterialsAndSameCategory.add(Tungsten);
        listOfMultipleMaterialsAndSameCategory.add(Aluminium);

    }

    @Test void ShouldReturnMixedMaterials(){

        CategoryEnum category = RecyclingGuidance.getGuidance(listOfDifferentMaterialsAndCategories);

        assertEquals(CategoryEnum.MixedMaterial, category);
        assertNotNull(category);
    }


    @Test void ShouldReturnCombustibleCategory(){

        CategoryEnum category = RecyclingGuidance.getGuidance(listWithOneMaterial);

        assertEquals(CategoryEnum.Combustible, category);
        assertNotNull(category);
    }

    @Test void ShouldReturnMetalCategory(){

        CategoryEnum category = RecyclingGuidance.getGuidance(listOfMultipleMaterialsAndSameCategory);

        assertEquals(CategoryEnum.Metal, category);
        assertNotNull(category);
    }

}

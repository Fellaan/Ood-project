import g1.domain.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import  org.junit.jupiter.api.BeforeEach;
class ProductTest {

    Product product;




    @BeforeEach void setup(){
        
        Material glass = new Material("Glass",CategoryEnum.Glass, 5.0);

        Material electronic = new Material("Electronic",CategoryEnum.Electronic, 12.0);

        HashMap<Material, Double> materials = new HashMap<>();

        materials.put(electronic, 10.0);
        materials.put(glass, 15.0);

        product =  new Product("Window", materials, 24);
    }

    @Test 
    void ProductShouldReturnName(){
        String result = product.getName();

        assertEquals("Window", result);
        assertNotNull(result);

    }
    @Test
    void ProductShouldReturnLifespan(){
        int result = product.getLifespan();

        assertEquals(24, result);
        assertNotNull(result);

    }
    @Test
    void ProductShouldReturnMaterials(){
        HashMap <Material, Double> result = product.getMaterials();

        assertEquals(2, result.size());
        assertNotNull(result);


    }
    @Test 
    
    void ProductShouldReturnCategory(){
        CategoryEnum result = product.getCategory();

        assertEquals(CategoryEnum.MixedMaterial, result);
        assertNotNull(result);

        
    }
    @Test
    void ProductShouldReturnCategoryInstruction(){
        String result = product.getCategoryInstruction();

        assertEquals("Take to a special station", result);
        assertNotNull(result);

    }





}

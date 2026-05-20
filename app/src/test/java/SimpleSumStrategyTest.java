import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import  org.junit.jupiter.api.BeforeEach;

import g1.domain.*;

public class SimpleSumStrategyTest {
ImpactCalculationStrategy strategy;
        HashMap<Material, Double> materials;

    @BeforeEach void setup(){ 
        
         strategy = new SimpleSumStrategy();

          Material plastic = new Material(
                "Plastic",
                CategoryEnum.Plastic,
                5.0
        );

        Material metal = new Material(
                "Metal",
                CategoryEnum.Metal,
                2.5);

        materials = new HashMap<>();

        materials.put(plastic, 2.0);
        materials.put(metal, 4.0);

    }

    @Test
    void shouldCalculateTotalImpactCorrectly() {
        

        // Act
        double result = strategy.calculateImpact(materials, 10);

        // Assert
        assertEquals(20.0, result);
        assertNotNull(result);
    }


    @Test
    void shouldReturnZeroWhenNoMaterialsExist() {

        HashMap<Material, Double> emptyMaterials = new HashMap<>();

        // Act
        double result = strategy.calculateImpact(emptyMaterials, 10);

        // Assert
        assertEquals(0.0, result);
        assertNotNull(result);
    }
}
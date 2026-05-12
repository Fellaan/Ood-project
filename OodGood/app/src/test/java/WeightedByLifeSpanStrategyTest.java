import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import  org.junit.jupiter.api.BeforeEach;

import g1.domain.*;



public class WeightedByLifeSpanStrategyTest {
    ImpactCalculationStrategy strategy;
        HashMap<Material, Double> materials;
        int lifespan;
    @BeforeEach void setup(){ 
        
         strategy = new WeightedByLifespanStrategy();

          Material plastic = new Material(
                "Plastic",
                "Recycle",
                5.0
        );

        Material glass = new Material(
                "Glass",
                "Recycle",
                2.5);

        materials = new HashMap<>();

        materials.put(plastic, 2.0);
        materials.put(glass, 4.0);

        lifespan = 10;
    }

    @Test
    void shouldCalculateTotalImpactCorrectly() {
        
        // Act
        double result = strategy.calculateImpact(materials, lifespan);

        // Assert
        assertEquals(2.0, result);
        assertNotNull(result);
    }


    @Test
    void shouldReturnZeroWhenNoMaterialsExist() {

        HashMap<Material, Double> emptyMaterials = new HashMap<>();

        // Act
        double result = strategy.calculateImpact(emptyMaterials, lifespan);

        // Assert
        assertEquals(0.0, result);
        assertNotNull(result);
    }
}


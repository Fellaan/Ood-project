import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import g1.domain.*;

class MaterialTest {
    Material material;

    @BeforeEach void setUp(){
        material = new Material("Plast", CategoryEnum.Plastic, 2);
    }

    @Test void MaterialShouldReturnName() {
        //ARRANGE
        String actual = material.getName();
        String expected = "Plast";

        //ASSERT
        assertEquals(expected, actual);
        assertNotNull(actual);
    }

    @Test void MaterialShouldReturnCategory() {
        CategoryEnum actual = material.getRecyclingCategory();
        CategoryEnum expected = CategoryEnum.Plastic;

        assertEquals(expected, actual);
        assertNotNull(actual);

    }

    @Test void MaterialShouldReturnEmissionFactor() {
        double actual = material.getEmissionFactor();
        double expected = 2;

        assertEquals(actual, expected);
        assertNotNull(actual);

    }

    @Test void MaterialShouldNotBeNullAtCreation() {
        Material result = material;

        assertNotNull(result);
    }

}

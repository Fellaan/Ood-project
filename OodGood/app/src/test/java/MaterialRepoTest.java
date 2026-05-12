import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import g1.application.CreateMaterialRequest;
import g1.application.LoadErrorException;
import g1.application.MaterialDto;
import g1.application.SaveErrorException;
import g1.domain.Material;
import g1.infrastructure.MaterialRepository;

class MaterialRepoTest {

    MaterialRepository matRepo;

    @BeforeEach
    void setUp() {
        matRepo = new MaterialRepository();
    }



    @Test void matRepoShouldBeAbleToSaveToFile(@TempDir Path tempDir) throws Exception {
        // Arrange
        Path filePath = tempDir.resolve("materials");

        // Use reflection to set private filename field
        Field filenameField = MaterialRepository.class.getDeclaredField("filename");
        filenameField.setAccessible(true);
        filenameField.set(matRepo, filePath.toString());

        // Add materials
        Field materialsField = MaterialRepository.class.getDeclaredField("materials");
        materialsField.setAccessible(true);
        @SuppressWarnings("unchecked")
        ArrayList<Material> materials = (ArrayList<Material>) materialsField.get(matRepo);

        materials.add(new Material("Wood", "Wood", 2));
        materials.add(new Material("Steel","Steel", 10));

        // Act
        matRepo.save();

        // Assert: file exists
        assertTrue(Files.exists(filePath));

        // Deserialize and verify
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(filePath))) {
            @SuppressWarnings("unchecked")
            ArrayList<Material> loaded = (ArrayList<Material>) in.readObject();

            assertEquals(2, loaded.size());
            assertEquals("Wood", loaded.get(0).getName());
            assertEquals("Steel", loaded.get(1).getName());
        }
    }



    @Test void saveShouldThrowSaveErrorExceptionWhenIOExceptionOccurs(@TempDir Path tempDir) throws Exception {
    // Arrange: point filename to a directory (illegal for FileOutputStream)
    Field filenameField = MaterialRepository.class.getDeclaredField("filename");
    filenameField.setAccessible(true);
    filenameField.set(matRepo, tempDir.toString()); // tempDir is a directory

    // Act + Assert
    assertThrows(SaveErrorException.class, () -> matRepo.save());
    }



    @Test void matRepoShouldBeAbleToLoadFromFile(@TempDir Path tempDir) throws Exception {
        Path filePath = tempDir.resolve("materials");

        Field filenamField = MaterialRepository.class.getDeclaredField("filename");
        filenamField.setAccessible(true);
        filenamField.set(matRepo, filePath.toString());

        ArrayList<Material> original = new ArrayList<>();
        original.add(new Material("Wood", "Wood", 2));
        original.add(new Material("Steel", "Steel", 10));

        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(filePath))) {
            out.writeObject(original);
        }

        // ACT
        matRepo.loadFromFile();

        //ASSERT
        Field materialsField = MaterialRepository.class.getDeclaredField("materials");
        materialsField.setAccessible(true);
        @SuppressWarnings("unchecked")
        ArrayList<Material> loaded = (ArrayList<Material>) materialsField.get(matRepo);

        assertEquals(2, loaded.size());
        assertEquals("Wood", loaded.get(0).getName());
        assertEquals("Steel", loaded.get(1).getName());
    }



    @Test void loadShouldThrowWhenFileDoesNotExist(@TempDir Path tempDir) throws Exception {
    // Arrange: point filename to a file that doesn't exist
    Path filePath = tempDir.resolve("materials");

    Field filenameField = MaterialRepository.class.getDeclaredField("filename");
    filenameField.setAccessible(true);
    filenameField.set(matRepo, filePath.toString());

    // Act + Assert
    assertThrows(LoadErrorException.class, () -> matRepo.loadFromFile());
    }



    @Test void loadShouldThrowLoadErrorExceptionWhenFileIsCorrupted(@TempDir Path tempDir) throws Exception {
    // Arrange
    Path filePath = tempDir.resolve("materials");

    Field filenameField = MaterialRepository.class.getDeclaredField("filename");
    filenameField.setAccessible(true);
    filenameField.set(matRepo, filePath.toString());

    // Write garbage instead of serialized data
    Files.writeString(filePath, "this is not serialized data");

    // Act + Assert
    assertThrows(LoadErrorException.class, () -> matRepo.loadFromFile());
    }


    @Test void matRepofindByNameShouldReturnCorrectMaterial() {
    // ARRANGE
    MaterialDto woodData = new MaterialDto("Wood", "Wood", 2);
    MaterialDto steelData = new MaterialDto("Steel", "Steel", 10);
    MaterialDto cottonData = new MaterialDto("Cotton", "Textile", 1);

    Material wood = new Material(woodData.name(), woodData.recyclingCategory(), woodData.emissionFactor());
    Material steel = new Material(steelData.name(), steelData.recyclingCategory(), steelData.emissionFactor());
    Material cotton = new Material(cottonData.name(), cottonData.recyclingCategory(), cottonData.emissionFactor());

    matRepo.add(wood);
    matRepo.add(steel);
    matRepo.add(cotton);

    // ACT
    Material actual = matRepo.findByName("Cotton");

    // ASSERT
    assertNotNull(actual);
    assertEquals("Cotton", actual.getName());
    assertEquals("Textile", actual.getRecyclingCategory());
    assertEquals(1, actual.getEmissionFactor());
}


    
    @Test void matRepofindAllShouldReturnListWithAllMaterials() {
        // ARRANGE
        Material wood = new Material("Wood", "Wood", 2);
        Material steel = new Material("Steel", "Steel", 10);
        Material cotton = new Material("Cotton", "Textile", 1);

        matRepo.add(wood);
        matRepo.add(steel);
        matRepo.add(cotton);

        // ACT
        List<Material> actual = matRepo.findAll();

        // ASSERT
        List<Material> expected = List.of(wood, steel, cotton);
        assertEquals(expected, actual);
    }


    @Test void matRepoRemoveShouldBeAbleToRemoveObjectFromList() {
        //ARRANGE
        Material wood = new Material("Wood", "Wood", 2);
        Material steel = new Material("Steel", "Steel", 10);
        Material cotton = new Material("Cotton", "Textile", 1);

        matRepo.add(wood);
        matRepo.add(steel);
        matRepo.add(cotton);


        //ACT
        matRepo.remove(cotton);

        //ASSERT
        ArrayList<Material> actual = matRepo.findAll();

        assertEquals(2, actual.size());
        assertFalse(actual.contains(cotton));
        assertTrue(actual.contains(wood));
        assertTrue(actual.contains(steel));
    }

    @Test void matRepoAddShouldAddMaterialToList() {
        //ARRANGE
        CreateMaterialRequest data = new CreateMaterialRequest("Wood", "Wood", 2);
        Material wood = new Material(data.name(), data.recyclingCategory(), data.emissionFactor());

        // ACT
        matRepo.add(wood);

        // ASSERT
        ArrayList<Material> actual = matRepo.findAll();

        assertEquals(1, actual.size());
        assertTrue(actual.contains(wood));
    }

}


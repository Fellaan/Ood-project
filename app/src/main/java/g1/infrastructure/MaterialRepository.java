package g1.infrastructure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import g1.application.LoadErrorException;
import g1.application.Repository;
import g1.application.SaveErrorException;
import g1.domain.Material;

public class MaterialRepository implements Repository<Material> , Serializable{
    private ArrayList<Material> materials = new ArrayList<>();

    String filename = "materials";

    @Override
    public void save() throws IOException, SaveErrorException {

        try (FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(materials);   // write the entire list
            out.close();
            fileOut.close();
    } catch (IOException e) {
        throw new SaveErrorException("Failed to save to material file.");
    }
}
    @SuppressWarnings("unchecked")
    @Override
    public void loadFromFile() throws IOException, ClassNotFoundException, LoadErrorException, SaveErrorException {
        File file = new File(filename);

        try (FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
                materials = (ArrayList<Material>) in.readObject();
    } catch (IOException e) {
        throw new LoadErrorException("Failed to load from material file");
    } 


    }

    @Override
    public Material findByName(String name){
        // Söker igenom listan av material och returnerar det första vars namn matchar det givna namnet
        return materials.stream()
                // Gå igenom varje Material‑objekt i listan ett i taget
                .filter(m -> m.getName().equals(name))
                // Behåll endast de Material‑objekt där namnet matchar söksträngen
                .findFirst()
                // Returnera det första matchande Material‑objektet om det finns
                .orElse(null);
                // Om inget matchande objekt hittas, returnera null istället för att kasta ett undantag
    }

    @Override
    public ArrayList<Material> findAll(){  // Returnerar listan med material för att vi ska kunna hitta specifika material
        return materials;
    }

    public void remove(Material material){  // Tar bort ett material från listan
        materials.remove(material);
    }

    public void add(Material material){     // Lägger till ett skapat material till listan
        materials.add(material);
    }
    

}
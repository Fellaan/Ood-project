package g1.infrastructure;

import java.util.ArrayList;

import g1.application.Repository;
import g1.domain.Material;

public class MaterialRepository implements Repository<Material>{
    private ArrayList<Material> materials = new ArrayList<>();

    @Override
    public void save(){

        // Kod för att spara ner skapat material till en fil
    }

    public void loadFromFile(){
        // Kod för att hämta data från fil

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

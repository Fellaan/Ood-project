package g1.application;

import java.util.HashMap;
import java.util.ArrayList;
import g1.domain.Product;
import g1.infrastructure.ProductRepository;


public class ProductApplicationService {
    
    public record productRecord(String name, ArrayList<materialRecord> materials, String category, int lifespan){};
    public record materialRecord(String name, double quantity){};
    public record productDTO(String name, String category, int lifespan){};

    HashMap<String, Double> map = new HashMap<>();
    ProductRepository repo;

    public ProductApplicationService(ProductRepository repo){
        this.repo = repo;
    }

    public boolean createProduct(productRecord createRequest){
        for (materialRecord m : createRequest.materials()){
            map.put(m.name(), m.quantity());
        }
        Product product = new Product(createRequest.name(), map, createRequest.lifespan(), createRequest.category());
        repo.add(product);

        try {
            repo.save();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String removeProduct(String name){
        Product p = repo.findByName(name);
        if (p.equals(null)){
            return "Cannot be removed, product does not exist";
        }
        else{
            repo.remove(p);
            return "Product removed successfully";
        }
    }

    public ArrayList<String> showList(){
        ArrayList<String> nameList = new ArrayList<>();
        for (String name : repo.listAll()){
            nameList.add(name);
        }
        return nameList;
    }

    public productDTO getDetails(String name){
        Product p = repo.findByName(name);
        return new productDTO(p.getName(), p.getCategory(), p.getLifespan());
    }

    // Metoder nedan behöver implementeras, har med guidance och impact strategies att göra.
    public String calcImpact(String name, String strategyName){
        return "";
    }

    public String showGuidance(String name){

        return "Guidance";
    }

    public ArrayList<String> loadImpactStrategies(){
        return null;
    }






}

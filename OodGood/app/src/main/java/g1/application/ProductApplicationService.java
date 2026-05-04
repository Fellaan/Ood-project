package g1.application;

import java.util.HashMap;
import java.util.ArrayList;

import g1.domain.Product;
import g1.domain.Material;
import g1.domain.ImpactCalculationStrategy;
import g1.domain.SimpleSumStrategy;
import g1.domain.WeightedByLifespanStrategy;
import g1.domain.MaterialImpactRecord;

import g1.infrastructure.ProductRepository;
import g1.infrastructure.MaterialRepository;



public class ProductApplicationService {
    
    public record productRecord(String name, ArrayList<materialRecord> materials, String category, int lifespan){};
    public record materialRecord(String name, double quantity){};
    public record productDTO(String name, String category, int lifespan){};

    private MaterialRepository materialRepo;

    HashMap<Material, Double> map = new HashMap<>();
    ProductRepository repo;

    public ProductApplicationService(ProductRepository productRepo, MaterialRepository materialRepo){
        this.repo = productRepo;
        this.materialRepo = materialRepo;
    }

    public boolean createProduct(productRecord createRequest){
        for (materialRecord m : createRequest.materials()){
            map.put(materialRepo.findByName(m.name()), m.quantity());
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

    public double calcImpact(String productName, String strategyName){ //bara use-cases

        Product product = repo.findByName(productName);
        HashMap<Material, Double> materials = product.getMaterials();
        int lifespan = product.getLifespan();
        return strategy.calculateImpact(materials, lifespan);
        
    }

    public String showGuidance(String name){

        return "Guidance";
    }

    public ArrayList<String> loadImpactStrategies(){
        return null;
    }






}

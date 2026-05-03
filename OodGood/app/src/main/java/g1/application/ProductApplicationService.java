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

    private ProductRepository productRepo;
    private MaterialRepository materialRepo;

    HashMap<String, Double> map = new HashMap<>();
    ProductRepository repo;

    public ProductApplicationService(ProductRepository productRepo, MaterialRepository materialRepo){
        this.productRepo = productRepo;
        this.materialRepo = materialRepo;
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

    public double calcImpact(String productName, String strategyName){

        Product product = productRepo.findByName(productName);

        ArrayList<MaterialImpactRecord> impactRecords = new ArrayList<>();


        for (String materialName : product.getMaterials().keySet()) {
            double mass = product.getMaterials().get(materialName);
            Material material = materialRepo.findByName(materialName);
            impactRecords.add(new MaterialImpactRecord(mass, material.getEmissionFactor()));

        }
        ImpactCalculationStrategy strategy;
        if (strategyName.equals("1"))
            strategy = new SimpleSumStrategy();
        else
            strategy = new WeightedByLifespanStrategy();

        return strategy.calculateImpact(impactRecords, product.getLifespan());

    }

    public String showGuidance(String name){

        return "Guidance";
    }

    public ArrayList<String> loadImpactStrategies(){
        return null;
    }






}

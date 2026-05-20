package g1.application;

import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;
import g1.domain.Product;
import g1.domain.ImpactCalculationStrategy;
import g1.domain.ImpactStrategyFactory;
import g1.domain.Material;
import g1.infrastructure.ProductRepository;
import g1.infrastructure.MaterialRepository;


public class ProductApplicationService {
    
    public record productRecord(String name, ArrayList<materialRecord> materials, int lifespan){};
    public record materialRecord(String name, double quantity){};
    public record productDTO(String name, String category, int lifespan){};

    private ProductRepository prodRepo;
    private MaterialRepository materialRepo;
    private ImpactStrategyFactory impactStrategyFactory;

    public ProductApplicationService(ProductRepository productRepo, MaterialRepository materialRepo, ImpactStrategyFactory impactStrategyFactory){
        this.prodRepo = productRepo;
        this.materialRepo = materialRepo;
        this.impactStrategyFactory = impactStrategyFactory;
    }

    public boolean createProduct(productRecord createRequest) throws SaveErrorException, IOException{
        HashMap<Material, Double> map = new HashMap<>();
        for (materialRecord m : createRequest.materials()){
            map.put(materialRepo.findByName(m.name()), m.quantity());
            if (materialRepo.findByName(m.name()) == null){
                return false;
            }
        }
        Product product = new Product(createRequest.name(), map, createRequest.lifespan());
        prodRepo.add(product);

        try {
            prodRepo.save();
        } catch (SaveErrorException e) {
            return false;
        }
        return true;
    }

    public String removeProduct(String name) throws IOException, SaveErrorException{
        Product p = prodRepo.findByName(name);
        if (p == null){
            return "Cannot be removed, product does not exist";
        }
        else{
            prodRepo.remove(p);
            try {
                prodRepo.save();
            } catch (SaveErrorException e) {
                throw e;
            }
            return "Product removed successfully";
        }
    }

    public boolean productExists(String name){
        Product p = prodRepo.findByName(name);
        if (p == null){
            return false;
        }
        else{
            return true;
        }
    }

    public ArrayList<String> showList(){
        ArrayList<String> nameList = new ArrayList<>();
        for (String name : prodRepo.listAll()){
            nameList.add(name);
        }
        return nameList;
    }

    public productDTO getDetails(String name){
        Product p = prodRepo.findByName(name);
        return new productDTO(p.getName(), p.getCategory().toString(), p.getLifespan());
    }

    public double calcImpact(String productName, String strategyName){ //bara use-cases

        Product product = prodRepo.findByName(productName);
        ImpactCalculationStrategy strategy = impactStrategyFactory.findByName(strategyName);
        HashMap<Material, Double> materials = product.getMaterials();
        int lifespan = product.getLifespan();
        return strategy.calculateImpact(materials, lifespan);
        
    }

    public ArrayList<String> loadImpactStrategies(){
        ArrayList<String> strategyList = new ArrayList<>();
        for (ImpactCalculationStrategy i : impactStrategyFactory.getStrategies()){
            strategyList.add(i.getName());
        }
        return strategyList;
    }

    public String showGuidance(String name){
        Product p = prodRepo.findByName(name);
        return p.getCategoryInstruction();
    }

    






}

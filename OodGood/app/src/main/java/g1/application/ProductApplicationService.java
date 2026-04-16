package g1.application;

import java.util.ArrayList;


public class ProductApplicationService {

    Repository productRepository;
     //ArrayList<Product> products = new ArrayList<Product>();


    public ProductApplicationService(Repository productRepository){
        this.productRepository = productRepository;

    }

    public String createProduct(String name, ArrayList<String> materials, int lifespan){

        return "Creating product";
    }

    public String removeProduct(String name){


        return "Removed product";
    }

    public String showList(){

        return "List of products";
    }

    public String getDetails(String name){

        return "Showing details";
    }

    public String calcImpact(String name){

        return "42";
    }

    public String showGuidance(String name){

        return "Guidance";
    }






}

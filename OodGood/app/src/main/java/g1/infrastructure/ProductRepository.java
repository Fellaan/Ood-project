package g1.infrastructure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import g1.application.Repository;
import g1.domain.Product;

public class ProductRepository implements Repository<Product>, Serializable {
    private ArrayList<Product> products = new ArrayList<>();

    String filename = "products";

    public void save() throws IOException{
        try (FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(products);   // write the entire list
            out.close();
            fileOut.close();
    }
}

    @SuppressWarnings("unchecked")
    @Override
    public void loadFromFile() throws IOException, ClassNotFoundException{
        File file = new File(filename);

        try (FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
                products = (ArrayList<Product>) in.readObject();
            }
    }

    public Product findByName(String name){
        //kollar genom listan av produkter och returnerar produkten med rätt namn
        for (Product p : products){
            if (p.getName().equals(name)){
                return p;
            }
        }
        //hittas inget namn returneras null för att hanteras i Application lager. 
        return null;
    }

    public void add(Product p){
        products.add(p);
    }

    public void remove(Product p){
        products.remove(p);
    }

    public List<Product> findAll(){
        return products;
    }

    public ArrayList<String> listAll(){
        ArrayList<String> productNames = new ArrayList<>();
        for (Product p : products){
            productNames.add(p.getName());
        }
        return productNames;
    }

}

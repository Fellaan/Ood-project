package g1.domain;

import java.util.HashMap;

public class WeightedByLifespanStrategy implements ImpactCalculationStrategy {

   @Override 
    public double calculateImpact(HashMap<Material, Double> materials, int lifespan){
        double totalImpact = 0;

        for (HashMap.Entry<Material, Double> m : materials.entrySet()) {            
           
            totalImpact += m.getValue() * m.getKey().getEmissionFactor();
        } 
        return totalImpact / lifespan; //Miljlöpåverkan /livslängden
    }
    @Override
    public String getName(){
        return "Weighted by Lifespan";
    }
}

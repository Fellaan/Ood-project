package g1.domain;

import java.util.ArrayList;

public class SimpleSumStrategy implements ImpactCalculationStrategy {

        
    @override 
    public double calculateImpactImpact(ArrayList<MaterialImpactRecord> materials, int lifespan){
        double totalImpact = 0;

        for (MaterialImpactRecord m : materials) {            
           
            totalImpact += m.mass() * m.emissionFactor();
        } 
        return totalImpact;
    }

}

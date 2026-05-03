package g1.domain;

import java.util.ArrayList;

public class WeightedByLifespanStrategy implements ImpactCalculationStrategy {

    @override
    public double calculateImpact(ArrayList<MaterialImpactRecord> materials, int lifespan) {
        
        double totalImpact = 0;
        
        for (materialImpactRecord m : materials) {
            total += m.mass() * m.emissionFactor();
        }

        return totalImpact / lifespan; //Miljlöpåverkan /livslängden
    }
}

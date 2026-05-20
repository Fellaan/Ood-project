package g1.domain;

import java.util.HashMap;

public interface ImpactCalculationStrategy {

    double calculateImpact(HashMap<Material, Double> materials, int lifespan);        //All strategier kmr veta hur man gör beräkningar
    
    String getName();
}

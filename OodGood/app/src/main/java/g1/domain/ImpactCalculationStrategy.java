package g1.domain;

import java.util.ArrayList;

public interface ImpactCalculationStrategy {

    double calculateImpact(ArrayList<MaterialImpactRecord> materials, int lifespan);        //All strategier kmr veta hur man gör beräkningar

}

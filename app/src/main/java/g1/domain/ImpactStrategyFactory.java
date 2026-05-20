package g1.domain;

import java.util.ArrayList;

public class ImpactStrategyFactory {

    ArrayList<ImpactCalculationStrategy> strategies;

    public ImpactStrategyFactory(){
        strategies = new ArrayList<ImpactCalculationStrategy>();
        strategies.add(new SimpleSumStrategy());
        strategies.add(new WeightedByLifespanStrategy());
    }

    public ArrayList<ImpactCalculationStrategy> getStrategies(){
        return strategies;
    }

    public ImpactCalculationStrategy findByName(String name){
        for (ImpactCalculationStrategy i : strategies){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
}

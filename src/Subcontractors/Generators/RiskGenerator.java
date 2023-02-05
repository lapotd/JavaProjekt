package Subcontractors.Generators;

import java.util.Random;

public class RiskGenerator {
    public static Double GenerateRisk(Random randomizer){
        return 0.1 * randomizer.nextInt(4);
    }
}

package Subcontractors.Generators;

import java.util.Random;

public class WorkerPayGenerator {

    public static Double GeneratePay(Random randomizer){
        return 2000.0 + (2000 * randomizer.nextInt(1,4));
    }

    public static Double GenerateHireFee(Double pay){
        return pay * 0.1;
    }

    public static Double GenerateFireFee(Double pay){
        return pay * 0.1;
    }
}

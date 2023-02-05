package Subcontractors.Generators;

import java.util.Random;

public class WorkerPayGenerator {

    public static Double GeneratePay(Random randomizer){
        return 200.0 * (100 * randomizer.nextInt(3));
    }

    public static Double GenerateHireFee(Double pay){
        return pay * 0.1;
    }

    public static Double GenerateFireFee(Double pay){
        return pay * 0.1;
    }
}

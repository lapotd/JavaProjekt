package ProjectGenerator.SubGenerators;

import ProjectGenerator.Enums.ProjectDifficulty;
import jdk.jfr.Unsigned;

import java.util.Random;

public class PayGenerator {
    public static Double GeneratePay(Random randomizer, ProjectDifficulty difficulty){
        int randomNumber = randomizer.nextInt(3) +1;
        return 500.0 * randomNumber * (randomizer.nextInt(difficulty.ordinal()+1)+1);
    }

    public static Double GenerateLateFee(Double pay){
        return pay * 0.2;
    }
}

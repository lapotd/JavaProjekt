package ProjectGenerator.SubGenerators;

import ProjectGenerator.Enums.ProjectDifficulty;

import java.util.Random;

public class PayGenerator {
    public static Double GeneratePay(Random randomizer, ProjectDifficulty difficulty){
        return 500.0 * (randomizer.nextInt(3) + 1) * (randomizer.nextInt(difficulty.ordinal()));
    }

    public static Double GenerateLateFee(Double pay){
        return pay * 0.2;
    }
}

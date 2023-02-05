package ProjectGenerator.SubGenerators;

import ProjectGenerator.Enums.ProjectDifficulty;
import ProjectGenerator.Models.WorkDays;

import java.util.Random;

public class WorkDaysGenerator {
    public static WorkDays Generate(Random randomizer, ProjectDifficulty difficulty){
        switch(difficulty){
            case easy -> {
                return WorkDaysGenerator.GenerateEasyWork(randomizer);
            }
            case  medium -> {
                return WorkDaysGenerator.GenerateMediumWork(randomizer);
            }
            case complex -> {
                return WorkDaysGenerator.GenerateComplexWork(randomizer);
            }
            default -> {
                return null;
            }
        }
    }

    private static WorkDays GenerateEasyWork(Random randomizer){
        Integer[] easyWorkDays = new WorkDays().ToArray();
        easyWorkDays[randomizer.nextInt(6)] = randomizer.nextInt(3) + 1;
        return WorkDays.ArrayToWorkDays(easyWorkDays);
    }

    private static WorkDays GenerateMediumWork(Random randomizer){
        Integer randomWorkType = randomizer.nextInt(5);
        Integer randomWorkDays = randomizer.nextInt(3) + 1;
        Integer[] mediumWorkDays = new WorkDays().ToArray();

        mediumWorkDays[randomWorkType] = randomWorkDays;
        mediumWorkDays[randomWorkType + 1] = randomWorkDays;

        return WorkDays.ArrayToWorkDays(mediumWorkDays);
    }
    private static WorkDays GenerateComplexWork(Random randomizer){
        Integer randomWorkType = randomizer.nextInt(4);
        Integer randomWorkDays = randomizer.nextInt(3) + 1;
        Integer[] complexWorkDays = new WorkDays().ToArray();

        complexWorkDays[randomWorkType] = randomWorkDays;
        complexWorkDays[randomWorkType + 1] = randomWorkDays;
        complexWorkDays[randomWorkType + 2] = randomWorkDays;

        return WorkDays.ArrayToWorkDays(complexWorkDays);
    }

}

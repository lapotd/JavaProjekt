package ProjectGenerator.SubGenerators;

import ProjectGenerator.Enums.ProjectDifficulty;
import ProjectGenerator.Models.WorkDay;
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
        WorkDay[] easyWorkDays = new WorkDays().ToArray();
        easyWorkDays[randomizer.nextInt(6)].amount = randomizer.nextInt(3) + 1;
        return WorkDays.ArrayToWorkDays(easyWorkDays);
    }

    private static WorkDays GenerateMediumWork(Random randomizer){
        Integer randomWorkType = randomizer.nextInt(5);
        Integer randomWorkDays = randomizer.nextInt(3) + 1;
        WorkDay[] mediumWorkDays = new WorkDays().ToArray();

        mediumWorkDays[randomWorkType].amount = randomWorkDays;
        mediumWorkDays[randomWorkType + 1].amount = randomWorkDays;

        return WorkDays.ArrayToWorkDays(mediumWorkDays);
    }
    private static WorkDays GenerateComplexWork(Random randomizer){
        Integer randomWorkType = randomizer.nextInt(4);
        Integer randomWorkDays = randomizer.nextInt(3) + 1;
        WorkDay[] complexWorkDays = new WorkDays().ToArray();

        complexWorkDays[randomWorkType].amount = randomWorkDays;
        complexWorkDays[randomWorkType + 1].amount = randomWorkDays;
        complexWorkDays[randomWorkType + 2].amount = randomWorkDays;

        return WorkDays.ArrayToWorkDays(complexWorkDays);
    }

}

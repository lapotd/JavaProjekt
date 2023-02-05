package ProjectGenerator;

import ProjectGenerator.Enums.ProjectDifficulty;
import ProjectGenerator.Models.WorkDays;
import ProjectGenerator.SubGenerators.DifficultyGenerator;
import ProjectGenerator.SubGenerators.NameGenerator;
import ProjectGenerator.SubGenerators.WorkDaysGenerator;

import java.util.Random;

public class ProjectGenerator {

    public void GenerateProject(){
        Random randomizer = new Random();
        String projectName = NameGenerator.GenerateProjectName(randomizer);
        String clientName = NameGenerator.GenerateClientName(randomizer);
        ProjectDifficulty difficulty = DifficultyGenerator.Generate(randomizer);
        WorkDays workDays = WorkDaysGenerator.Generate(randomizer, difficulty);
    }

}

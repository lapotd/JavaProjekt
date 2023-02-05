package ProjectGenerator;

import ProjectGenerator.Enums.ProjectDifficulty;
import ProjectGenerator.Models.Client;
import ProjectGenerator.Models.Project;
import ProjectGenerator.Models.WorkDays;
import ProjectGenerator.SubGenerators.*;

import java.util.Date;
import java.util.Random;

public class ProjectGenerator {

    public void GenerateProject(Date gameDate){
        Random randomizer = new Random();
        String projectName = NameGenerator.GenerateProjectName(randomizer);
        ProjectDifficulty difficulty = DifficultyGenerator.Generate(randomizer);
        WorkDays workDays = WorkDaysGenerator.Generate(randomizer, difficulty);
        Client client = ClientGenerator.GenerateClient(randomizer);
        Date deadline = DateGenerator.GenerateDeadline(randomizer,difficulty,gameDate);
        Integer daysToPayAfterFinish = DateGenerator.GenerateDaysToPayAfterFinish(randomizer);
        Double pay = PayGenerator.GeneratePay(randomizer,difficulty);
        Double lateFee = PayGenerator.GenerateLateFee(pay);

        Project project = new Project(projectName,client,workDays,deadline,daysToPayAfterFinish,lateFee,pay,difficulty);
    }

}

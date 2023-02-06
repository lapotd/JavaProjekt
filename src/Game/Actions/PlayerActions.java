package Game.Actions;

import Game.Models.Game;
import Game.Models.ProjectSearch;
import ProjectGenerator.Models.Project;
import ProjectGenerator.Models.WorkDay;
import Subcontractors.Enums.Skills;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class PlayerActions {
    public static void signContract(Project project){
        Game.getGame().projects.add(project);
        Game.getGame().availableProjects.remove(project);
    }

    public static void spendDaySearchingForProject(ProjectSearch projectSearch, Game game){
        projectSearch.SpendDaySearching();
        Game.getGame().dayEnd.DayEnds();
    }

    public static boolean spendDayWorking(Project project, Skills skill){
        Optional<WorkDay> optional = Arrays.stream(project.workDays.ToArray())
                .filter(x -> x.skillRequired == skill).findFirst();
        if(optional.isPresent() && optional.get().amount>0){
            optional.get().amount-=1;
            Game.getGame().dayEnd.DayEnds();
            return true;
        }
        else{
            return false;
        }
    }

    public static void spendDayTesting(Project project){
        if(project.isProjectBuggy){
            project.isProjectBuggyAndDetected = true;
        }
        Game.getGame().dayEnd.DayEnds();
    }

    public static void returnProject(Project project){
        Random randomizer = new Random();
        Double d100Throw = randomizer.nextDouble(0,1);

    }
}

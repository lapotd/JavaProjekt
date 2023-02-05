package Game.Actions;

import Game.Models.Game;
import ProjectGenerator.Models.Project;
import ProjectGenerator.Models.WorkDay;
import Subcontractors.Models.Programmer;

import java.util.Arrays;
import java.util.Optional;

public class WorkerActions {
    public static void WorkOnProjects(Programmer programmer, Game game){
        for(Project project : game.projects){
            Optional<WorkDay> optional = Arrays.stream(project.workDays.ToArray())
                    .filter(workDay ->
                            Arrays.stream(programmer.skillSet)
                                    .filter(y -> y == workDay.skillRequired).findAny().isPresent())
                    .findFirst();
            if(optional.isPresent() && optional.get().amount>0){
                optional.get().amount-=1;
                Game.getGame().dayEnd.DayEnds();
            }
        }

    }

}

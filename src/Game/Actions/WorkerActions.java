package Game.Actions;

import Game.Models.Game;
import ProjectGenerator.Models.Project;
import ProjectGenerator.Models.WorkDay;
import Subcontractors.Models.Programmer;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class WorkerActions {
    public static void WorkOnProjects(Programmer programmer){
        Double d100 = new Random().nextDouble(0,1);

        for(Project project : Game.getGame().projects){
            Optional<WorkDay> optional = Arrays.stream(project.workDays.ToArray())
                    .filter(workDay ->
                            Arrays.stream(programmer.skillSet)
                                    .anyMatch(y -> y == workDay.skillRequired))
                    .findFirst();
            if(optional.isPresent() && optional.get().amount>0){
                if(project.isProjectBuggyAndDetected){
                    project.isProjectBuggyAndDetected = false;
                    project.isProjectBuggy = false;
                }
                else if(d100 > programmer.lateRisk){
                    if(d100 < programmer.badCodeRisk){
                        project.isProjectBuggy = true;
                    }
                    optional.get().amount-=1;
                }
            }
        }

    }

}

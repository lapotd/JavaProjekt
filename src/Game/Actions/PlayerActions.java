package Game.Actions;

import Game.Models.Game;
import ProjectGenerator.Models.Project;
import ProjectGenerator.Models.WorkDay;
import Subcontractors.Enums.Skills;
import Subcontractors.Models.Worker;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class PlayerActions {
    public static void SignContract(Project project){
        Game game = Game.getGame();
        game.projects.add(project);
        game.availableProjects.remove(project);
    }

    public static void SpendDaySearchingForProject(){
        Game game = Game.getGame();
        game.projectSearch.SpendDaySearching();
        game.dayEnd.DayEnds();
    }

    public static void HireWorker(Worker worker){
        Game game = Game.getGame();
        if(game.balance < worker.hireFee){
            System.out.println("Nie stac cie na oplate zatrudnienia!");
            return;
        }
        game.balance -= worker.hireFee;
        game.workers.add(worker);
        game.availableWorkers.remove(worker);
    }

    public static void SpendDayFilingTaxes(){
        Game game = Game.getGame();
        game.taxFill.SpendDayFilingTaxes();
        game.dayEnd.DayEnds();
        System.out.println("Do spelnienia obowiazku zglaszania podatkow zostalo: "
                + game.taxFill.daysToFillTax + "dni");
    }

    public static void FireWorker(Worker worker){
        Game game = Game.getGame();
        if(game.balance < worker.fireFee){
            System.out.println("Nie stac cie na oplate zwolnienia!");
            return;
        }
        game.balance -= worker.fireFee;
        game.workers.remove(worker);

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

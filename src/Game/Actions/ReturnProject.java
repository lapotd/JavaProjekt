package Game.Actions;

import Game.Models.BlockedBudget;
import Game.Models.Game;
import ProjectGenerator.Models.Project;
import Subcontractors.Enums.WorkerType;

import java.util.Calendar;
import java.util.Date;

public class ReturnProject {
    public static void Return(Double d100Throw, Project project){
        if(!project.isProjectFinished()){
            System.out.println("Nie mozesz oddac nieukonczonego projektu!");
            return;
        }

        if(project.isProjectBuggy){
            if(Game.getGame().workers.stream().anyMatch(worker -> worker.workerType == WorkerType.tester)){
                System.out.println("Projekt jest zbugowany! Twoj tester to wykryl i nie pozwala ci oddac projektu");
                project.isProjectBuggyAndDetected = true;
            }
            if(d100Throw < project.client.consequencesForNonWorkingProject){
                Game.getGame().projects.remove(project);
                System.out.println("Klient zauwazyl bugi i zabral ci projekt");
            }
        }

        if(project.deadline.getTime() < Game.getGame().currentGameDate.getTime()){
            if(d100Throw >= project.client.avoidAfterDeadlineFeeChance){
                System.out.println("Klient zauwazyl spoznienie i zabiera czesc wynagrodzenia");
                project.pay -= project.lateFee;
            }
        }

        if(d100Throw < project.client.payMonthLateChance){
            System.out.println("Klient zaplaci po dodatkowym miesiacu :(");
            ReturnProject.PostponePayDate(30,project.pay, project.daysToPayAfterFinish);
        }else if(d100Throw < project.client.payWeekLateChance){
            System.out.println("Klient zaplaci po dodatkowym tygodniu :(");
            ReturnProject.PostponePayDate(7,project.pay, project.daysToPayAfterFinish);
        }
        else{
            ReturnProject.PostponePayDate(0,project.pay, project.daysToPayAfterFinish);
        }

        Game game = Game.getGame();
        game.projects.remove(project);
        game.projectsPassed += 1;
        System.out.println("Zdano projekt!");

    }

    public static void PostponePayDate(Integer daysAmount, Double pay, Integer daysToPayAfterFinish){
        Calendar c = Calendar.getInstance();
        c.setTime(Game.getGame().currentGameDate);
        c.add(Calendar.DATE, daysAmount + daysToPayAfterFinish);
        Date latePayDate = c.getTime();

        Game.getGame().blockedBudgets.add(new BlockedBudget(pay,latePayDate));
    }
}

package Game.Actions;

import Game.Models.BlockedBudget;
import Game.Models.Game;
import ProjectGenerator.Models.Project;

import java.util.Calendar;
import java.util.Date;

public class ReturnProject {
    public static void Return(Double d100Throw, Project project){
        if(project.isProjectBuggy){
            if(d100Throw < project.client.consequencesForNonWorkingProject){
                Game.getGame().projects.remove(project);
            }
        }

        if(project.deadline.getTime() < Game.getGame().currentGameDate.getTime()){
            if(d100Throw >= project.client.avoidAfterDeadlineFeeChance){
                project.pay -= project.lateFee;
            }
        }

        if(d100Throw < project.client.payMonthLateChance){
            ReturnProject.PostponePayDate(30,project.pay, project.daysToPayAfterFinish);
        }else if(d100Throw < project.client.payWeekLateChance){
            ReturnProject.PostponePayDate(7,project.pay, project.daysToPayAfterFinish);
        }
        else{
            ReturnProject.PostponePayDate(0,project.pay, project.daysToPayAfterFinish);
        }

    }

    public static void PostponePayDate(Integer daysAmount, Double pay, Integer daysToPayAfterFinish){
        Calendar c = Calendar.getInstance();
        c.setTime(Game.getGame().currentGameDate);
        c.add(Calendar.DATE, daysAmount + daysToPayAfterFinish);
        Date latePayDate = c.getTime();

        Game.getGame().blockedBudgets.add(new BlockedBudget(pay,latePayDate));
    }
}

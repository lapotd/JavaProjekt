package Game.Actions;

import Game.Models.BlockedBudget;
import Game.Models.Game;
import Subcontractors.Models.Programmer;
import Subcontractors.Models.Worker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DayEnd {

    public void DayCycle(){
        this.CheckBlockedAmounts();
        this.workersWork();
        Boolean monthEnded = this.CheckForEndOfMonth();


        if(monthEnded){
            this.CheckFiledTaxes();
            this.EndMonth();
        }

        this.AddDay();
    }

    private void workersWork() {
        Game game = Game.getGame();
        for(Worker worker : game.workers){
            switch (worker.workerType){
                case programmer -> {
                    WorkerActions.WorkOnProjects(((Programmer)worker));
                }
                case seller -> {
                    PlayerActions.SpendDaySearchingForProject();
                }
            }
        }
    }

    private void CheckFiledTaxes() {
        Game game = Game.getGame();
        if(!game.taxesDone){
            game.gameOver = true;
        }
    }

    private void EndMonth(){
        Game game = Game.getGame();

        for(Worker worker : game.workers){
            game.balance -= worker.pay;
        }

        game.balance -= game.taxesToPay;
        game.taxesToPay = 0.0;

        if(game.balance < 0){
            game.gameOver = true;
        }

    }

    private Boolean CheckForEndOfMonth() {
        Game game = Game.getGame();
        Calendar c = Calendar.getInstance();
        c.setTime(game.currentGameDate);
        c.add(Calendar.DATE,1);
        return c.getTime().getDate() == 1;
    }

    private void AddDay(){
        Calendar c = Calendar.getInstance();
        c.setTime(Game.getGame().currentGameDate);
        c.add(Calendar.DATE, 1);
        Game.getGame().currentGameDate = c.getTime();
    }

    private void CheckBlockedAmounts() {
        Game game = Game.getGame();
        Calendar c = Calendar.getInstance();
        c.setTime(Game.getGame().currentGameDate);
        c.add(Calendar.DATE, 1);
        Date datePlusOneDay = c.getTime();
        List<BlockedBudget> budgetsCopy = new ArrayList<>();
        budgetsCopy.addAll(Game.getGame().blockedBudgets);
       for(BlockedBudget budget : budgetsCopy) {
           if(budget != null){
               if(datePlusOneDay.getTime() >= budget.dateOfPayment.getTime()){
                   game.balance += budget.amount;
                   game.taxesToPay += budget.amount/10;
                   game.blockedBudgets.remove(budget);
               }
           }

       }
    }

}

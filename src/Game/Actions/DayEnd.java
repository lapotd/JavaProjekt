package Game.Actions;

import Game.Models.BlockedBudget;
import Game.Models.Game;
import Subcontractors.Models.Worker;

import java.util.Calendar;
import java.util.Date;

public class DayEnd {

    public void DayEnds(){
        this.CheckBlockedAmounts();
        Boolean monthEnded = this.CheckForEndOfMonth();

        if(monthEnded){
            this.CheckFiledTaxes();
            this.EndMonth();
        }

        this.AddDay();
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

        if(game.balance < 0){
            game.gameOver = true;
        }

    }

    private Boolean CheckForEndOfMonth() {
        Game game = Game.getGame();
        Calendar c = Calendar.getInstance();
        c.setTime(game.currentGameDate);
        c.add(Calendar.DATE,1);
        return Calendar.DAY_OF_MONTH == 1;
    }

    private void AddDay(){
        Calendar c = Calendar.getInstance();
        c.setTime(Game.getGame().currentGameDate);
        c.add(Calendar.DATE, 1);
        Game.getGame().currentGameDate = c.getTime();
    }



    private void CheckBlockedAmounts() {
        Calendar c = Calendar.getInstance();
        c.setTime(Game.getGame().currentGameDate);
        c.add(Calendar.DATE, 1);
        Date datePlusOneDay = c.getTime();
       for(BlockedBudget budget : Game.getGame().blockedBudgets) {
           if(datePlusOneDay.getTime() <= budget.dateOfPayment.getTime()){
               Game.getGame().blockedBudgets.remove(budget);
           }
       }
    }

}

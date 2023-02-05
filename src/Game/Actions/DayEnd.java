package Game.Actions;

import Game.Models.BlockedBudget;
import Game.Models.Game;

import java.util.Calendar;
import java.util.Date;

public class DayEnd {

    public void DayEnds(){
        this.CheckBlockedAmounts();
        this.AddDay();
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

package Menus;

import Game.Models.Game;

public class StatisticsTab {
    public static String GetStatistics(){
         Game game = Game.getGame();

         return "\n\nBilans konta: " + game.balance
                 + "\nData: " + game.currentGameDate
                 + "\nPodatki: " + (game.taxesDone ? "Rozliczone" : "Nierozliczone");
    }
}

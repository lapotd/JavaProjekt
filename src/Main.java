import Game.Models.Game;
import Menus.IMenu;
import Menus.MainMenu;
import Menus.StatisticsTab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = Game.getGame();
        IMenu menu = new MainMenu();
        Scanner scanner = new Scanner(System.in);
        String decision = "";
        while(!game.gameOver || game.gameWon){
            System.out.println(StatisticsTab.GetStatistics() + "\n\n");
            System.out.print(menu.ShowMenu());
            System.out.println("\nCo wybierasz? : ");
            decision = scanner.nextLine();
            menu = menu.HandleDecision(decision);
            game.CheckWinConditions();
        }
        if(game.gameOver){
            System.out.println("PRZEGRALES");
            System.out.println("balans" + game.balance);
            System.out.println("rozliczenie z zusem?: " + (game.taxesDone ? "tak" : "nie"));

        }else{
            System.out.println("WYGRALES");
        }
    }
}
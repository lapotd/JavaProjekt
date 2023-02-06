import Game.Models.Game;
import Menus.IMenu;
import Menus.MainMenu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = Game.getGame();
        IMenu menu = new MainMenu();
        Scanner scanner = new Scanner(System.in);
        String decision = "";
        while(true){
            System.out.print(menu.ShowMenu());
            System.out.println("\nCo wybierasz? : ");
            decision = scanner.nextLine();
            menu = menu.HandleDecision(decision);
        }
    }
}
package Menus;

import Game.Actions.PlayerActions;
import Game.Models.Game;
import Menus.AvailableWorkers.AvailableWorkersMenu;
import Menus.YourProjects.YourProjectsMenu;
import Menus.AvailableProjects.AvailableProjectsMenu;
import Menus.YourWorkers.YourWorkersMenu;

public class MainMenu implements IMenu{
    @Override
    public java.lang.String ShowMenu() {
        return
                "Wybierz akcje: \n" +
                        "1. Sprawdz nowe projekty\n" +
                        "2. Sprawdz aktywne projekty\n" +
                        "3. Spedz dzien na szukaniu projektow\n" +
                        "4. Sprawdz wolnych pracownikow\n" +
                        "5. Sprawdz obecnych pracownikow\n" +
                        "6. Przeznacz dzień na rozliczenia z urzędami\n" +
                        "7. Pomin dzien\n";
    }

    @Override
    public IMenu HandleDecision(String decision) {
        switch (decision){
            case "1" ->{
                return new AvailableProjectsMenu();
            }
            case "2" ->{
                return new YourProjectsMenu();
            }
            case "3" ->{
                PlayerActions.SpendDaySearchingForProject();
                return new MainMenu();
            }
            case "4" ->{
                return new AvailableWorkersMenu();
            }
            case "5" ->{
                return new YourWorkersMenu();
            }
            case "6" ->{
                PlayerActions.SpendDayFilingTaxes();
                return new MainMenu();
            }
            case "7" ->{
                Game.getGame().dayEnd.DayCycle();
                return this;
            }
            default -> {
                return this;
            }
        }
    }
}

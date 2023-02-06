package Menus;

import Game.Actions.PlayerActions;
import Menus.AvailableWorkers.AvailableWorkersMenu;
import Menus.YourProjects.YourProjectsMenu;
import Menus.AvailableProjects.AvailableProjectsMenu;

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
                        "6. przeznacz dzień na rozliczenia z urzędami\n";
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
                return new AvailableProjectsMenu();
            }
            case "4" ->{
                return new AvailableWorkersMenu();
            }
            default -> {
                return new AvailableProjectsMenu();
            }
        }
    }
}

package Menus;

import Menus.AvailableProjects.AvailableProjectsMenu;
import Menus.NewProjects.NewProjectsMenu;

public class MainMenu implements IMenu{
    @Override
    public java.lang.String ShowMenu() {
        return
                "Wybierz akcje: \n" +
                        "1. Sprawdz nowe projekty\n" +
                        "2. Sprawdz aktywne projekty\n" +
                        "3. Spedz dzien na szukaniu projektow\n" +
                        "4. Sprawdz nowych pracownikow\n" +
                        "5. Sprawdz obecnych pracownikow\n" +
                        "6. przeznacz dzień na rozliczenia z urzędami\n";
    }

    @Override
    public IMenu HandleDecision(String decision) {
        switch (decision){
            case "1" ->{
                return new NewProjectsMenu();
            }
            case "2" ->{
                return new AvailableProjectsMenu();
            }
            default -> {
                return new NewProjectsMenu();
            }
        }
    }
}

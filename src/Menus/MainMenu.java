package Menus;

public class MainMenu implements IMenu{
    @Override
    public java.lang.String ShowMenu() {
        return
                "Wybierz akcje: \n" +
                        "1. Sprawdz nowe projekty\n" +
                        "2. Sprawdz aktywne projekty" +
                        "3. Sprawdz dzien na szukanie projektow\n" +
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
            default -> {
                return new NewProjectsMenu();
            }
        }
    }
}

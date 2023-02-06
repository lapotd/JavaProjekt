package Menus.AvailableProjects;

import Game.Models.Game;
import Menus.IMenu;
import Menus.MainMenu;
import Menus.NewProjects.NewProjectTabMenu;
import ProjectGenerator.Models.Project;

public class AvailableProjectsMenu implements IMenu {

    @Override
    public String ShowMenu() {
        Game game = Game.getGame();
        if(game.projects.isEmpty()){
            return "Lista projektow jest pusta! Zakontraktuj nowy - wroc komenda back";
        }

        String menuContent = "Wybierz projekt przez wpisanie pelnej nazwy" + "\n";
        for(Project project : game.projects){
            menuContent = menuContent + "- " + project.name + "\n";
        }
        menuContent = menuContent + "Wpisz back i zatwierdz by wyjsc do glownego menu";

        return menuContent;
    }

    @Override
    public IMenu HandleDecision(String decision) {
        if(decision.equals("back")){
            return new MainMenu();
        }
        else{
            return new AvailableProjectTabMenu(decision);
        }
    }
}

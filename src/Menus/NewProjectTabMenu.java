package Menus;


import Game.Actions.PlayerActions;
import Game.Models.Game;
import ProjectGenerator.Models.Project;

import java.util.Arrays;

public class NewProjectTabMenu implements IMenu {
    public String projectName;
    public Project project;

    public NewProjectTabMenu(String projectName){
        this.projectName = projectName;
    }

    @Override
    public String ShowMenu() {
        for(Project project : Game.getGame().availableProjects){
            if(project.name.equals(this.projectName)){
                this.project = project;
            }
        }

        if (this.project == null){
            return "Nie znaleziono takiego projektu! Wpisz back aby wrocic";
        }

        String MenuDisplay = "Nazwa Projektu: " + this.project.name + "\n" +
                "Stawka za projekt: " + this.project.pay + "\n" +
                "Dni wymagane: " + this.project.workDays.ToString() + "\n" +
                "Oplata za opoznienie: " + this.project.lateFee + "\n" +
                "Deadline: " + this.project.deadline.toString() + "\n" +
                "Aby wybrac projekt i podpisac kontrakt wpisz wybieram, aby wrocic wpisz back" + "\n";

        return MenuDisplay;
    }

    @Override
    public IMenu HandleDecision(String decision) {
        if(decision.equals("back")){
            return new NewProjectsMenu();
        }
        else if(decision.equals("wybieram")){
            PlayerActions.signContract(this.project);
            return new NewProjectsMenu();
        }
        return new NewProjectsMenu();
    }
}

package Menus.AvailableProjects;


import Game.Actions.PlayerActions;
import Game.Models.Game;
import Menus.IMenu;
import ProjectGenerator.Models.Project;

public class AvailableProjectTabMenu implements IMenu {
    public String projectName;
    public Project project;

    public AvailableProjectTabMenu(String projectName){
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
            return new AvailableProjectsMenu();
        }
        else if(decision.equals("wybieram")){
            PlayerActions.SignContract(this.project);
            return new AvailableProjectsMenu();
        }
        return new AvailableProjectsMenu();
    }
}

package Menus.YourProjects;


import Game.Actions.PlayerActions;
import Menus.IMenu;
import ProjectGenerator.Models.Project;
import ProjectGenerator.Models.WorkDay;
import Subcontractors.Enums.Skills;

public class WorkOnProjectTab implements IMenu {
    public String skillName;
    public Project project;

    public WorkOnProjectTab(Project project){
        this.project = project;
    }

    @Override
    public String ShowMenu() {
        if (this.project == null){
            return "Nie znaleziono takiego projektu! Wpisz back aby wrocic";
        }

        String menuDisplay = "Nazwa Projektu: " + this.project.name + "\n" +
                "Nad czym chcesz pracowac?: \n";
        for(WorkDay workDay : this.project.workDays.ToArray()){
            menuDisplay += workDay.skillRequired + " zostalo " + workDay.amount + " dni \n";
        }
        menuDisplay += "\nAby wrocic wpisz back";

        return menuDisplay;
    }

    @Override
    public IMenu HandleDecision(String decision) {
        if(decision.equals("back")){
            return new YourProjectTabMenu(this.project.name);
        }
        else{
            for(Skills skill : Skills.values()){
                if(decision.equals(skill.toString())){
                    if(PlayerActions.spendDayWorking(this.project, skill)){
                        System.out.println("Pracowano!");
                    }else{
                        System.out.println("Nie ma nad czym pracowac!");
                    }

                }
                else{
                    System.out.println("Nie masz takiego skilla! wpisz back aby wrocic");
                }
                return this;
            }
        }

        return new YourProjectsMenu();
    }
}

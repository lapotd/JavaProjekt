package Menus.AvailableWorkers;


import Game.Actions.PlayerActions;
import Menus.AvailableProjects.AvailableProjectsMenu;
import Menus.IMenu;
import Subcontractors.Enums.WorkerType;
import Subcontractors.Models.Programmer;
import Subcontractors.Models.Worker;

public class AvailableWorkerTabMenu implements IMenu {
    public Worker worker;

    public AvailableWorkerTabMenu(Worker worker){
        this.worker = worker;
    }

    @Override
    public String ShowMenu() {
        if(this.worker == null){
            return "Nie znaleziono takiego pracownika, wpisz i zatwierdz back aby powrocic";
        }

        String menuDisplay = "Typ pracownika: " + worker.workerType.toString() + "\n" +
                "Wyplata: " + worker.pay + "\n" +
                "Oplata za zatrudnienie: " + worker.hireFee + "\n" +
                "Oplata za zwolnienie: " + worker.fireFee + "\n";
        if(worker.workerType == WorkerType.programmer){
            menuDisplay = menuDisplay + ((Programmer)worker).skillsToString();
        }

        return menuDisplay;
    }

    @Override
    public IMenu HandleDecision(String decision) {
        if(decision.equals("back")){
            return new AvailableWorkersMenu();
        }
        else if(decision.equals("wybieram")){
            PlayerActions.HireWorker(this.worker);
            return new AvailableWorkersMenu();
        }
        return new AvailableWorkersMenu();
    }
}

package Menus.YourWorkers;


import Game.Actions.PlayerActions;
import Menus.IMenu;
import Subcontractors.Enums.WorkerType;
import Subcontractors.Models.Programmer;
import Subcontractors.Models.Worker;

public class YourWorkerTabMenu implements IMenu {
    public Worker worker;

    public YourWorkerTabMenu(Worker worker){
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
        menuDisplay = menuDisplay + "\nAby zwolnic pracownika wpisz zwalniam, aby wrocic wpisz back";

        return menuDisplay;
    }

    @Override
    public IMenu HandleDecision(String decision) {
        if(decision.equals("back")){
            return new YourWorkersMenu();
        }
        else if(decision.equals("zwalniam")){
            PlayerActions.FireWorker(this.worker);
            return new YourWorkersMenu();
        }
        return new YourWorkersMenu();
    }
}

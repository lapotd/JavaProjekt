package Menus.AvailableWorkers;

import Game.Models.Game;
import Menus.IMenu;
import Menus.MainMenu;
import Subcontractors.Models.Worker;

import java.util.List;

public class AvailableWorkersMenu implements IMenu {

    public List<Worker> workers;

    @Override
    public String ShowMenu() {
        Game game = Game.getGame();
        Integer workerIterator = 1;
        this.workers = game.availableWorkers;

        if(workers.isEmpty()){
            return "Nie ma wolnych pracownikow! Wpisz back aby wrocic";

        }

        String menuContent = "Wybierz pracownika" + "\n";
        for(Worker worker : game.availableWorkers){
            menuContent = menuContent + workerIterator.toString() + "." + worker.workerType + "\n";
            workerIterator +=1;
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
            return new AvailableWorkerTabMenu(workers.get(Integer.parseInt(decision)-1));
        }
    }
}

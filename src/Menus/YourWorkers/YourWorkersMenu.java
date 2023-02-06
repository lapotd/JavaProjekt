package Menus.YourWorkers;

import Game.Models.Game;
import Menus.IMenu;
import Menus.MainMenu;
import Subcontractors.Models.Worker;

import java.util.List;

public class YourWorkersMenu implements IMenu {

    public List<Worker> workers;

    @Override
    public String ShowMenu() {
        Game game = Game.getGame();
        Integer workerIterator = 1;
        this.workers = game.workers;

        if(workers.isEmpty()){
            return "Nie masz pracownikow! Wpisz back aby wrocic";

        }

        String menuContent = "Wybierz pracownika" + "\n";
        for(Worker worker : game.workers){
            menuContent = menuContent + workerIterator + "." + worker.workerType + "\n";
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
            return new YourWorkerTabMenu(workers.get(Integer.parseInt(decision)-1));
        }
    }
}

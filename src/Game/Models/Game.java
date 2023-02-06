package Game.Models;

import Game.Actions.DayEnd;
import Game.Models.ProjectSearch;
import ProjectGenerator.Models.Project;
import ProjectGenerator.ProjectGenerator;
import Subcontractors.Enums.WorkerType;
import Subcontractors.Generators.WorkerGenerator;
import Subcontractors.Models.Friend;
import Subcontractors.Models.Player;
import Subcontractors.Models.Worker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Game {
    private static Game game;
    public Player player;
    public Date currentGameDate;
    public DayEnd dayEnd;
    public Double balance;
    public List<BlockedBudget> blockedBudgets;
    public List<Worker> workers;
    public List<Worker> availableWorkers;
    public List<Friend> friends;
    public List<Project> projects;
    public List<Project> availableProjects;
    public ProjectSearch projectSearch;

    private Game(){
        this.currentGameDate = new Date(2020,1,1);
        this.player = WorkerGenerator.GeneratePlayer();
        this.balance = 2000.0;
        this.friends = WorkerGenerator.GenerateFriends();
        this.projectSearch = ProjectSearch.getProjectSearch();
        this.availableWorkers = new ArrayList<Worker>();
        this.availableProjects = new ArrayList<Project>();
        this.projects = new ArrayList<Project>();
        this.workers = new ArrayList<Worker>();

        this.availableWorkers.add(WorkerGenerator.GenerateCompanyWorker(WorkerType.programmer));
        this.availableWorkers.add(WorkerGenerator.GenerateCompanyWorker(WorkerType.programmer));
        this.availableWorkers.add(WorkerGenerator.GenerateCompanyWorker(WorkerType.tester));
        this.availableWorkers.add(WorkerGenerator.GenerateCompanyWorker(WorkerType.seller));

        this.availableProjects.add(ProjectGenerator.GenerateProject(this.currentGameDate));
        this.availableProjects.add(ProjectGenerator.GenerateProject(this.currentGameDate));
        this.availableProjects.add(ProjectGenerator.GenerateProject(this.currentGameDate));
    }

    public static Game getGame(){
        if(game == null){
            game = new Game();
        }
        return game;
    }
}

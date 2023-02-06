package Game.Models;

import Game.Actions.DayEnd;
import ProjectGenerator.Models.Project;
import ProjectGenerator.ProjectGenerator;
import Subcontractors.Enums.WorkerType;
import Subcontractors.Generators.WorkerGenerator;
import Subcontractors.Models.Friend;
import Subcontractors.Models.Player;
import Subcontractors.Models.Worker;

import java.util.*;

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
    public Boolean taxesDone;
    public TaxFill taxFill;
    public Double taxesToPay;
    public Boolean gameOver;

    private Game(){
        this.currentGameDate = new GregorianCalendar(2020,Calendar.JANUARY,1).getTime();
        this.balance = 2000.0;
        this.player = WorkerGenerator.GeneratePlayer();
        this.friends = WorkerGenerator.GenerateFriends();
        this.projectSearch = ProjectSearch.getProjectSearch();
        this.taxFill = TaxFill.getTaxFill();
        this.blockedBudgets = new ArrayList<BlockedBudget>();
        this.dayEnd = new DayEnd();
        this.availableWorkers = new ArrayList<Worker>();
        this.availableProjects = new ArrayList<Project>();
        this.projects = new ArrayList<Project>();
        this.workers = new ArrayList<Worker>();
        this.taxesDone = false;
        this.gameOver = false;

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

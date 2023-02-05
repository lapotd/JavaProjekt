package Game.Models;

import Game.Models.ProjectSearch;
import ProjectGenerator.Models.Project;
import ProjectGenerator.ProjectGenerator;
import Subcontractors.Enums.WorkerType;
import Subcontractors.Generators.WorkerGenerator;
import Subcontractors.Models.Friend;
import Subcontractors.Models.Worker;

import java.util.Date;

public class Game {
    public Date currentGameDate;
    public Double balance;
    public Worker[] workers;
    public Worker[] availableWorkers;
    public Friend[] friends;
    public Project[] projects;
    public Project[] availableProjects;
    public ProjectSearch projectSearch;

    public Game(){
        this.currentGameDate = new Date(2020,1,1);
        this.balance = 2000.0;
        this.availableWorkers = new Worker[]{
                WorkerGenerator.GenerateCompanyWorker(WorkerType.programmer),
                WorkerGenerator.GenerateCompanyWorker(WorkerType.programmer),
                WorkerGenerator.GenerateCompanyWorker(WorkerType.tester),
                WorkerGenerator.GenerateCompanyWorker(WorkerType.seller)
        };
        this.friends = WorkerGenerator.GenerateFriends();
        this.availableProjects = new Project[]{
                ProjectGenerator.GenerateProject(currentGameDate),
                ProjectGenerator.GenerateProject(currentGameDate),
                ProjectGenerator.GenerateProject(currentGameDate),
        };
        this.projectSearch = ProjectSearch.getProjectSearch();
    }
}

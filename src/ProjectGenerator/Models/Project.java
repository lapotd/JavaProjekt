package ProjectGenerator.Models;

import ProjectGenerator.Enums.ProjectDifficulty;

import java.util.Date;

public class Project {
    public Project(String name, Client client, WorkDays workDays, Date deadline, Integer daysToPayAfterFinish,
                   Double lateFee, Double pay, ProjectDifficulty projectDifficulty) {
        this.name = name;
        this.client = client;
        this.workDays = workDays;
        this.deadline = deadline;
        this.daysToPayAfterFinish = daysToPayAfterFinish;
        this.lateFee = lateFee;
        this.pay = pay;
        this.projectDifficulty = projectDifficulty;
        this.isProjectBuggyAndDetected = false;
        this.isProjectBuggy = false;
    }

    public String name;
    public Client client;
    public WorkDays workDays;
    public Date deadline;
    public Integer daysToPayAfterFinish;
    public Double lateFee;
    public Double pay;
    public ProjectDifficulty projectDifficulty;
    public Boolean isProjectBuggy;
    public Boolean isProjectBuggyAndDetected;
    public Boolean isProjectFinished(){
        return this.workDays.isProjectFinished();
    }
}

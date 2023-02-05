package ProjectGenerator.Models;

import ProjectGenerator.Enums.ProjectDifficulty;

import java.util.Date;

public class Project {

    public String name;
    public String client;
    public WorkDays workDays;
    public Date deadline;
    public Integer daysToPayAfterFinish;
    public Double lateFee;
    public Double pay;
    public ProjectDifficulty projectDifficulty;
}

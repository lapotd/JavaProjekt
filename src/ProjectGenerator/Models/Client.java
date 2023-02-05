package ProjectGenerator.Models;

public class Client {
    public Client(String clientName, Double payWeekLateChance, Double payMonthLateChance, Double avoidAfterDeadlineFeeChance,
                  Double consequencesForNonWorkingProject, Double neverPayingChance) {
        this.clientName = clientName;
        this.payWeekLateChance = payWeekLateChance;
        this.payMonthLateChance = payMonthLateChance;
        this.avoidAfterDeadlineFeeChance = avoidAfterDeadlineFeeChance;
        this.consequencesForNonWorkingProject = consequencesForNonWorkingProject;
        this.neverPayingChance = neverPayingChance;
    }

    public String clientName;
    public Double payWeekLateChance;
    public Double payMonthLateChance;
    public Double avoidAfterDeadlineFeeChance;
    public Double consequencesForNonWorkingProject;
    public Double neverPayingChance;
}

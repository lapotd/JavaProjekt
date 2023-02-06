package ProjectGenerator.Models;

import Subcontractors.Enums.Skills;

import java.util.Arrays;
import java.util.List;

public class WorkDays {
    public WorkDay frontEndWorkDays;
    public WorkDay backEndWorkDays;
    public WorkDay databaseWorkDays;
    public WorkDay mobileWorkDays;
    public WorkDay wordpressWorkDays;
    public WorkDay prestashopWorkDays;

    public WorkDays() {
        this.frontEndWorkDays = new WorkDay(0,Skills.frontEnd);
        this.backEndWorkDays = new WorkDay(0,Skills.backEnd);
        this.databaseWorkDays = new WorkDay(0,Skills.database);
        this.mobileWorkDays = new WorkDay(0,Skills.mobile);
        this.wordpressWorkDays = new WorkDay(0,Skills.wordpress);
        this.prestashopWorkDays = new WorkDay(0,Skills.prestashop);
    }

    private WorkDays(WorkDay[] array) {
        this.frontEndWorkDays = array[0];
        this.backEndWorkDays = array[1];
        this.databaseWorkDays = array[2];
        this.mobileWorkDays = array[3];
        this.wordpressWorkDays = array[4];
        this.prestashopWorkDays = array[5];
    }

    public WorkDay[] ToArray(){
        return new WorkDay[]{this.frontEndWorkDays, this.backEndWorkDays, this.databaseWorkDays, this.mobileWorkDays,
                this.wordpressWorkDays, this.prestashopWorkDays};
    }

    public Boolean isProjectFinished(){
        Boolean finished = true;
        for(WorkDay workDay : this.ToArray()){
            if (workDay.amount > 0){
                finished = false;
            }
        }
        return finished;
    }

    public String ToString(){
        WorkDay[] tableOfWorkDays = this.ToArray();
        String output = "\n";
        for(WorkDay day : tableOfWorkDays){
            output = output + day.skillRequired.toString() + " " +day.amount + "dni do ukonczenia" + "\n";
        }
        return output;
    }

    public List<WorkDay> ToList(){
        return Arrays.stream(this.ToArray()).toList();
    }

    public static WorkDays ArrayToWorkDays(WorkDay[] array){
        return new WorkDays(array);
    }
}

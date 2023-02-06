package Subcontractors.Models;

import ProjectGenerator.Models.Project;
import Subcontractors.Enums.Skills;
import Subcontractors.Enums.WorkerType;

public class Programmer extends Worker{
    public Programmer(Double lateRisk, Double badCodeRisk, Skills[] skillSet,
                      Double pay, Double hireFee, Double fireFee) {
        super(pay,hireFee,fireFee);
        this.lateRisk = lateRisk;
        this.badCodeRisk = badCodeRisk;
        this.skillSet = skillSet;
        super.workerType = WorkerType.programmer;
    }
    public Double lateRisk;
    public Double badCodeRisk;
    public Skills[] skillSet;

    public void Work(Project project){
        if(project.isProjectBuggyAndDetected){
            project.isProjectBuggy = false;
            project.isProjectBuggyAndDetected = false;
        }else{

        }
    }

    public String skillsToString(){
        String output = "";
        for(Skills skill : skillSet){
            output += skill.toString() + "\n";
        }
        return output;
    }
}

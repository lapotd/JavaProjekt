package Subcontractors.Models;

import Subcontractors.Enums.Skills;
import Subcontractors.Enums.WorkerType;

public class Friend {

    public WorkerType workerType = WorkerType.friend;

    public Double lateRisk;
    public Double pay;
    public Double badCodeRisk;
    public Skills[] skillSet;
    public Friend(Double badCodeRisk, Double lateRisk, Skills[] skillSet, Double pay) {
        this.badCodeRisk = badCodeRisk;
        this.lateRisk = lateRisk;
        this.skillSet = skillSet;
        this.pay = pay;
    }
}

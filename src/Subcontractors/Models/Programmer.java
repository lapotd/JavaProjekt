package Subcontractors.Models;

import Subcontractors.Enums.Skills;
import Subcontractors.Enums.WorkerType;

public class Programmer extends Worker{
    public WorkerType workerType = WorkerType.programmer;
    public Programmer(Double lateRisk, Double badCodeRisk, Skills[] skillSet,
                      Double pay, Double hireFee, Double fireFee) {
        super(pay,hireFee,fireFee);
        this.lateRisk = lateRisk;
        this.badCodeRisk = badCodeRisk;
        this.skillSet = skillSet;
    }
    public Double lateRisk;
    public Double badCodeRisk;
    public Skills[] skillSet;
}

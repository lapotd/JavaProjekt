package Subcontractors.Models;

import Subcontractors.Enums.WorkerType;

public class Tester extends Worker{
    public WorkerType workerType = WorkerType.tester;

    public Tester(Double pay, Double hireFee, Double fireFee){
        super(pay,hireFee,fireFee);
    }

}

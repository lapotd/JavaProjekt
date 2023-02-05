package Subcontractors.Models;

import Subcontractors.Enums.WorkerType;

public class Seller extends Worker{
    public WorkerType workerType = WorkerType.seller;

    public Seller(Double pay, Double hireFee, Double fireFee){
        super(pay,hireFee,fireFee);
    }
}

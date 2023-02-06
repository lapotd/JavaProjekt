package Subcontractors.Models;

import Subcontractors.Enums.WorkerType;

public class Worker {
    public WorkerType workerType;
    public Double pay;
    public Double hireFee;
    public Double fireFee;

    public Worker(Double pay, Double hireFee, Double fireFee){
        this.pay = pay;
        this.hireFee = hireFee;
        this.fireFee = fireFee;
    }

    public void Work(){};


}

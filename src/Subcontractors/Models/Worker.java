package Subcontractors.Models;

import Subcontractors.Enums.Skills;
import Subcontractors.Enums.WorkerType;

public class Worker {
    public Double pay;
    public Double hireFee;
    public Double fireFee;

    public Worker(Double pay, Double hireFee, Double fireFee){
        this.pay = pay;
        this.hireFee = hireFee;
        this.fireFee = fireFee;
    }


}

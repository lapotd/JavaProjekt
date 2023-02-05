package ProjectGenerator.Models;

import Subcontractors.Enums.Skills;

public class WorkDay {
    public Integer amount;
    public Skills skillRequired;
    public WorkDay(Integer amount, Skills skillRequired){
        this.amount = amount;
        this.skillRequired = skillRequired;
    }
}

package Game.Models;

import java.util.Date;

public class BlockedBudget {
    public Double amount;
    public Date dateOfPayment;

    public  BlockedBudget(Double amount, Date dateOfPayment){
        this.amount = amount;
        this.dateOfPayment = dateOfPayment;
    }
}

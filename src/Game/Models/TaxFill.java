package Game.Models;

public class TaxFill {
    private static TaxFill taxFill;
    public Integer daysToFillTax;

    public static TaxFill getTaxFill(){
        if(taxFill == null){
            taxFill = new TaxFill();
        }
        return taxFill;
    }

    private TaxFill(){
        this.daysToFillTax = 2;
    }

    public Boolean SpendDayFilingTaxes(){
        //returns true if taxes were filled enough times
        if(this.daysToFillTax == 1){
            Game.getGame().taxesDone = true;
            return true;
        }else{
            return false;
        }
    }
}

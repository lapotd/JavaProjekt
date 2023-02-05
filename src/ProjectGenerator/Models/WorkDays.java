package ProjectGenerator.Models;

public class WorkDays {
    public Integer frontEndWorkDays;
    public Integer backEndWorkDays;
    public Integer databaseWorkDays;
    public Integer mobileWorkDays;
    public Integer wordpressWorkDays;
    public Integer prestashopWorkDays;

    public WorkDays() {
        this.frontEndWorkDays = 0;
        this.backEndWorkDays = 0;
        this.databaseWorkDays = 0;
        this.mobileWorkDays = 0;
        this.wordpressWorkDays = 0;
        this.prestashopWorkDays = 0;
    }

    private WorkDays(Integer[] array) {
        this.frontEndWorkDays = array[0];
        this.backEndWorkDays = array[1];
        this.databaseWorkDays = array[2];
        this.mobileWorkDays = array[3];
        this.wordpressWorkDays = array[4];
        this.prestashopWorkDays = array[5];
    }

    public Integer[] ToArray(){
        return new Integer[]{this.frontEndWorkDays, this.backEndWorkDays, this.databaseWorkDays, this.mobileWorkDays,
                this.wordpressWorkDays, this.prestashopWorkDays};
    }

    public static WorkDays ArrayToWorkDays(Integer[] array){
        return new WorkDays(array);
    }
}

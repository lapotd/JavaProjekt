package Game.Models;

public class ProjectSearch {
    private static ProjectSearch projectSearch;
    private Integer daysToNewProject;

    public static ProjectSearch getProjectSearch(){
        if(projectSearch == null){
            projectSearch = new ProjectSearch();
        }
        return projectSearch;
    }

    private ProjectSearch(){
        this.daysToNewProject = 5;
    }

    public Boolean SpendDaySearching(){
        //returns true if research time is enough and a new project was found
        if(this.daysToNewProject == 1){
            this.daysToNewProject = 5;
            return true;
        }else{
            return false;
        }
    }
}

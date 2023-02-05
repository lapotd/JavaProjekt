package ProjectGenerator.SubGenerators;

import ProjectGenerator.Enums.ProjectDifficulty;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateGenerator {
    public Date GenerateDeadline(Random randomizer, ProjectDifficulty difficulty){
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        Integer addedDays = 7 * (difficulty.ordinal() + 1);

        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE,addedDays);
        return  calendar.getTime();
    }

}

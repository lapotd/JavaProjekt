package ProjectGenerator.SubGenerators;

import ProjectGenerator.Enums.ProjectDifficulty;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateGenerator {
    public static Date GenerateDeadline(Random randomizer, ProjectDifficulty difficulty, Date gameDate){
        Date currentDate = gameDate;
        Calendar calendar = Calendar.getInstance();
        Integer addedDays = 7 * (difficulty.ordinal() + 1);

        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE,addedDays);
        return  calendar.getTime();
    }

    public static Integer GenerateDaysToPayAfterFinish(Random randomizer){
        return 3 * (randomizer.nextInt(3) + 1);
    }

}

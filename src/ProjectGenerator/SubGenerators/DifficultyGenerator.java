package ProjectGenerator.SubGenerators;

import ProjectGenerator.Enums.ProjectDifficulty;

import java.util.Arrays;
import java.util.Random;

public class DifficultyGenerator {
    public static ProjectDifficulty Generate(Random randomizer){
       return ProjectDifficulty.values()[randomizer.nextInt(3)];
    }
}

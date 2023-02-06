package ProjectGenerator.SubGenerators;

import java.util.Random;

public class NameGenerator {

    private static final String[] firstColumn =
            {"sticky ","super ","futuristic "};
    private static final String[] secondColumn =
            {"client ","agent ","management "};
    private static final String[] thirdColumn =
            {"site","database","app"};
    private static final String[] clientName =
            {"intel","microsoft","zabka","FBI","KGB"};
    public static String GenerateProjectName(Random randomizer){
        int firstChoice = randomizer.nextInt(1000) % 3;
        int secondChoice = randomizer.nextInt(10000) % 3;
        int thirdChoice = randomizer.nextInt(100000) % 3;

        return firstColumn[firstChoice]+secondColumn[secondChoice]+thirdColumn[thirdChoice];
    }

    public static String GenerateClientName(Random randomizer){
        return clientName[randomizer.nextInt(5)];
    }



}

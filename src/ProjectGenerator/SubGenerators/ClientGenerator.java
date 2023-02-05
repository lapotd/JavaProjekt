package ProjectGenerator.SubGenerators;

import ProjectGenerator.Enums.ClientType;
import ProjectGenerator.Models.Client;

import java.util.Random;

public class ClientGenerator {
    public Client GenerateClient(Random randomizer){
        ClientType clientType = ClientType.values()[randomizer.nextInt(3)];

        switch (clientType){
            case chilledOut -> {
                return GenerateChilledOutClient(randomizer);
            }
            case needy -> {
                return GenerateNeedyClient(randomizer);
            }
            case worst -> {
                return GenerateWorstClient(randomizer);
            }
            default -> {
                return null;
            }
        }
    }

    private Client GenerateChilledOutClient(Random randomizer) {
        return new Client(NameGenerator.GenerateClientName(randomizer),
                0.3, 0.0, 0.2, 0.0, 0.0);
    }

    private Client GenerateNeedyClient(Random randomizer) {
        return new Client(NameGenerator.GenerateClientName(randomizer),
                0.0, 0.0, 0.0, 50.0, 0.0);
    }

    private Client GenerateWorstClient(Random randomizer) {
        return new Client(NameGenerator.GenerateClientName(randomizer),
                0.3, 0.05,0.2, 100.0, 0.01);
    }
}

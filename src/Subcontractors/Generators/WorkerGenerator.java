package Subcontractors.Generators;

import Subcontractors.Enums.Skills;
import Subcontractors.Enums.WorkerType;
import Subcontractors.Models.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WorkerGenerator {
    public static Worker GenerateCompanyWorker(WorkerType type){
        switch (type){
            case programmer -> {
                return WorkerGenerator.GenerateProgrammer();
            }
            case tester -> {
                return WorkerGenerator.GenerateTester();
            }
            case seller -> {
                return WorkerGenerator.GenerateSeller();
            }
            default -> {
                return null;
            }
        }
    }

    public static Player GeneratePlayer(){
        return new Player();
    }

    public static List<Friend> GenerateFriends(){
        Friend[] friends = new Friend[]{
                WorkerGenerator.GenerateAllKnowingFriend(),
                WorkerGenerator.GenerateMediocreStudent(),
                WorkerGenerator.GenerateBestStudent()
        };
        return Arrays.asList(friends);
    }

    private static Programmer GenerateProgrammer(){
        Random randomizer = new Random();
        Double lateRisk = RiskGenerator.GenerateRisk(randomizer);
        Double badCodeRisk = RiskGenerator.GenerateRisk(randomizer);
        Skills[] skillSet = SkillSetGenerator.GenerateSkills();
        Double pay = WorkerPayGenerator.GeneratePay(randomizer);
        Double hireFee = WorkerPayGenerator.GenerateHireFee(pay);
        Double fireFee = WorkerPayGenerator.GenerateFireFee(pay);

        return new Programmer(lateRisk,badCodeRisk,skillSet, pay, hireFee,fireFee);
    }

    private static Tester GenerateTester(){
        Random randomizer = new Random();
        Double pay = WorkerPayGenerator.GeneratePay(randomizer);
        Double hireFee = WorkerPayGenerator.GenerateHireFee(pay);
        Double fireFee = WorkerPayGenerator.GenerateFireFee(pay);

        return new Tester(pay,hireFee,fireFee);
    }

    private static Seller GenerateSeller(){
        Random randomizer = new Random();
        Double pay = WorkerPayGenerator.GeneratePay(randomizer);
        Double hireFee = WorkerPayGenerator.GenerateHireFee(pay);
        Double fireFee = WorkerPayGenerator.GenerateFireFee(pay);

        return new Seller(pay,hireFee,fireFee);
    }

    private static Friend GenerateAllKnowingFriend() {
        return new Friend(0.2,0.2,SkillSetGenerator.GenerateSkills(),150.0);
    }
    private static Friend GenerateBestStudent() {
        return new Friend(0.0,0.0,SkillSetGenerator.GenerateSkills(),250.0);

    }
    private static Friend GenerateMediocreStudent() {
        return new Friend(0.1,0.1,SkillSetGenerator.GenerateSkills(),200.0);

    }
}

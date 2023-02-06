package Subcontractors.Generators;

import Subcontractors.Enums.Skills;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SkillSetGenerator {
    public static Skills[] GenerateSkills(){
        Random randomizer = new Random();
        Integer firstSkill = (randomizer.nextInt(2)+1)*3-1;
        Integer secondSkill = (randomizer.nextInt(2)+1)*2-1;
        Integer thirdSkill = (randomizer.nextInt(2)+1)-1;

        List<Skills> skills = Arrays.stream(Skills.values()).toList();
        return new Skills[]{skills.get(firstSkill),skills.get(secondSkill),skills.get(thirdSkill)};
    }
}

package Subcontractors.Generators;

import Subcontractors.Enums.Skills;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SkillSetGenerator {
    public static Skills[] GenerateSkills(){
        List<Skills> skills = Arrays.stream(Skills.values()).toList();
        Collections.shuffle(skills);
        return new Skills[]{skills.get(0),skills.get(1),skills.get(2)};
    }
}

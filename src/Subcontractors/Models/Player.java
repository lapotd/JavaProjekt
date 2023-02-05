package Subcontractors.Models;

import Subcontractors.Enums.Skills;
import Subcontractors.Enums.WorkerType;

public class Player {
    WorkerType workerType = WorkerType.player;
    public Skills[] skillSet;

    public Player(){
        this.skillSet = new Skills[]{
                Skills.backEnd,
                Skills.frontEnd,
                Skills.prestashop,
                Skills.wordpress,
                Skills.database
        };
    }
}

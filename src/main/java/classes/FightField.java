package classes;
import lombok.Data;

@Data
public class FightField {

    private Warrior humanHero, botHero;
    private int roundNum;
    private FIGHT_STATUS currentFightStatus;

    public FightField(){
        this.roundNum = 0;
    }

    public void initFight(Warrior humanHero, Warrior botHero){
        this.humanHero = humanHero;
        this.botHero = botHero;
        this.currentFightStatus = FIGHT_STATUS.FIGHT_BEGINS;
    }

    public void startRound(Warrior.BODY_PARTS kickZone, Warrior.BODY_PARTS blockZone){
        this.roundNum++;
        System.out.println("============================================");
        System.out.println("Round " + this.roundNum + " starts");
        System.out.println("Before round your Health is " + humanHero.getHealth());
        System.out.println("Before round enemy Health is " + botHero.getHealth());
        System.out.println("You kick in "+ kickZone.name());
        System.out.println("You blocked " + blockZone.name());
        humanHero.setKickZone(kickZone);
        humanHero.setBlockZone(blockZone);
        int botKickZone = (int) (Math.random() * Warrior.partsNum);
        int botBlockZone = (int) (Math.random() * Warrior.partsNum);
        botHero.setKickZone(Warrior.BODY_PARTS.values()[botKickZone]);
        botHero.setBlockZone(Warrior.BODY_PARTS.values()[botBlockZone]);
        makeKick(humanHero, botHero);
        makeKick(botHero, humanHero);
        System.out.println("Enemy kicked in " + Warrior.BODY_PARTS.values()[botKickZone].name());
        System.out.println("Enemy blocked " + Warrior.BODY_PARTS.values()[botBlockZone].name());
        System.out.println("After round your Health is " + humanHero.getHealth());
        System.out.println("After round enemy Health is " + botHero.getHealth());
        if (botHero.getHealth() <= 0){
            humanHero.setWinner(true);
            currentFightStatus = FIGHT_STATUS.FIGHT_ENDS;
        }
        else if (humanHero.getHealth() <= 0){
            botHero.setWinner(true);
            currentFightStatus = FIGHT_STATUS.FIGHT_ENDS;
        }
        else currentFightStatus = FIGHT_STATUS.NEXT_ROUND;
        System.out.println("============================================");
    }


    private void makeKick(Warrior firstWarrior, Warrior secondWarrior){
        if (firstWarrior.getKickZone() != secondWarrior.getBlockZone()) secondWarrior.punch();
    }

    public enum FIGHT_STATUS {
        FIGHT_BEGINS, NEXT_ROUND, FIGHT_ENDS
    }
}

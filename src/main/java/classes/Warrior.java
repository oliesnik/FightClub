package classes;
import lombok.Data;

@Data
public class Warrior {

    private final String name;
    private int health;
    private BODY_PARTS kickZone;
    private BODY_PARTS blockZone;
    public static final int partsNum = 4;
    private boolean isPickedByHuman;
    private boolean isWinner;

    public Warrior(String name){
        this.name = name;
        this.health = 100;
    }

    public void punch(){
        this.health -= 20;
    }

    public void setKickZone(BODY_PARTS kickZone){
        this.kickZone = kickZone;
    }

    public void setBlockZone(BODY_PARTS blockZone){
        this.blockZone = blockZone;
    }

    public void setPickedByHuman(){
        this.isPickedByHuman = true;
    }

    public enum BODY_PARTS{
        HEAD, BODY, GROIN, LEGS
    }
}

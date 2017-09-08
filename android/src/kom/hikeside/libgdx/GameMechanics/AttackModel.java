package kom.hikeside.libgdx.GameMechanics;

/**
 * Created by Koma on 07.09.2017.
 */

public class AttackModel {
    int lowestDamage;

    int highestDamage;

    boolean isPiercing;

    float chanceToHit;

    public AttackModel(int lowestDamage, int highestDamage, boolean isPiercing, float chanceToHit) {
        this.lowestDamage = lowestDamage;
        this.highestDamage = highestDamage;
        this.isPiercing = isPiercing;
        this.chanceToHit = chanceToHit;
    }
}
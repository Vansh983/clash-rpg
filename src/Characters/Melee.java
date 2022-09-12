package Characters;
import Attacks.Attack;
import java.awt.*;

/**
 * Concrete implementation of Melee, that is, characters that deals melee attacks
 *
 * @author Vansh Sood
 */

public abstract class Melee extends RPGCharacter {
    private int maxEnergy;
    private int currentEnergy;

    /**
     * Creates a new Caster
     * @param name the name of the character
     * @param strength the strength of the character
     * @param maxHP maximum HP of the character
     * @param position the current position of the character. Point class object
     */
    public Melee(String name, int strength, int maxHP, Point position, int maxEnergy) {
        super(name, 1, strength, maxHP, position);
        this.maxEnergy = maxEnergy;
        this.currentEnergy = maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    /**
     * Concrete implementation of the attack to a specific target
     *
     * @param target the RPGCharacter target of the attack
     * @param attackIndex the index of the attack to be dealt
     * @return the current hp of the target
     */
    @Override
    public int attack(RPGCharacter target, int attackIndex){
        // if attack not in the list return -1
        if(attackIndex > attackList.size() || attackIndex < 0) {
            return -1;
        } else {
            Attack attack = (Attack) attackList.get(attackIndex);
            // if attack out of range return -2
            if (super.getPosition().distance(target.getPosition()) > attack.getRange()) {
                return -2;
            }
            // if attack costs more than energy return -3
            if (currentEnergy < attack.getCost()) {
                return -3;
            }
            // Interact with the target with the attacker's strength
            currentEnergy -= attack.getCost();
            attack.interactWithTarget(target, strength);
            return target.currentHP;
        }
    }

    // Convert to String
    public String toString() {
        return super.toString() + "\n" + "Energy " + currentEnergy + "/" + maxEnergy;
    }
}
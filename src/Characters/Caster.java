package Characters;
import Attacks.Attack;
import Attacks.HealingSpell;
import Attacks.Spell;
import java.awt.*;

/**
 * Concrete implementation of Caster, that is, characters that cast Spells
 *
 * @author Vansh Sood
 */

public abstract class Caster extends RPGCharacter {
    private int maxMana;
    private int currentMana;

    /**
     * Creates a new Caster
     * @param name the name of the character
     * @param intellect the intellect of the character
     * @param maxHP maximum HP of the character
     * @param position the current position of the character. Point class object
     */
    public Caster(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, 1, maxHP, position);
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
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
        if(attackIndex > attackList.size() || attackIndex < 0) return -1;
        Attack attack = (Attack) attackList.get(attackIndex);

        // if attack out of range return -2
        if(super.getPosition().distance(target.getPosition()) > attack.getRange()) {
            return -2;
        } else if(currentMana < attack.getCost()) {
            // if attack costs more than energy return -3
            return -3;
        } else {
            // Check if attack is Spell or not
            if (attack instanceof Spell) {
                if (attack instanceof HealingSpell) {
                    // Heal the caster with the caster's intellect
                    attack.interactWithTarget(this, intellect);
                } else {
                    // Interact with the target with the caster's intellect
                    attack.interactWithTarget(target, intellect);
                }
                currentMana -= attack.getCost();
            } else {
                attack.interactWithTarget(target, 0);
            }
            return target.currentHP;
        }

    }

    // Convert to string
    public String toString() {
        return super.toString() + "\n" + "Mana: " + currentMana + "/" + maxMana;
    }
}
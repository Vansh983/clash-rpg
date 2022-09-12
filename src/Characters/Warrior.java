
package Characters;
import Attacks.MeleeAttack;

import java.awt.*;

/**
 * Specialization of the Melee class.
 * Warrior can only deal MeleeAttacks
 *
 * @author Vansh Sood
 */
public class Warrior extends Melee {

    /**
     * Creates a new Warrior character.
     * Add attacks to the character attack list.
     *
     * @param name the name of the character
     * @param strength the strength of the character
     * @param maxHP maximum HP of the character
     * @param position the current position of the character. Point class object
     * @param maxEnergy maximum energy of the character
     */
    public Warrior(String name, int strength, int maxHP, Point position, int maxEnergy) {
        super(name, strength, maxHP, position, maxEnergy);
        super.attackList.add(new MeleeAttack(0, "Punch", 5, 3));
        super.attackList.add(new MeleeAttack(3, "Slam", 5, 3));
        super.attackList.add(new MeleeAttack(20, "Charge", 30, 15));
    }
}
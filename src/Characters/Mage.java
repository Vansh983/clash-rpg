package Characters;
import Attacks.*;
import java.awt.*;

/**
 * Specialization of the Caster class.
 * Mage can deal DamageSpells and MeleeAttacks
 *
 * @author Vansh Sood
 */
public class Mage extends Caster {

    /**
     * Creates a new Mage character.
     * Add attacks to the character attack list.
     *
     * @param name the name of the character
     * @param intellect the intellect of the character
     * @param maxHP maximum HP of the character
     * @param position the current position of the character. Point class object
     * @param maxMana maximum energy of the character
     */
    public Mage(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position, maxMana);
        super.attackList.add(new MeleeAttack(0, "Staff", 3, 3));
        super.attackList.add(new DamageSpell(20, "Fire Ball", 10, 20));
        super.attackList.add(new DamageSpell(15, "Frost Ball", 7, 15));
        super.attackList.add(new DamageSpell(30, "Lightning", 15, 20));
    }
}
package Characters;


import Attacks.*;

import java.awt.*;

/**
 * Specialization of the Caster class.
 * Priest can deal DamageSpells and MeleeAttacks, and HealingSpells
 *
 * @author Vansh
 */
public class Priest extends Caster {

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
    public Priest(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position, maxMana);
        super.attackList.add(new MeleeAttack(0, "Wand", 3, 3));
        super.attackList.add(new DamageSpell(10, "Smite", 10, 7));
        super.attackList.add(new HealingSpell(20, "Flash Heal", 15, 15));
        super.attackList.add(new Resurrection());
    }
}
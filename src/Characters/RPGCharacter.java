package Characters;
import Attacks.Attack;
import java.awt.*;
import java.util.ArrayList;

/***
 * Base Character class. It creates the foundation for all characters such as Caster and Melee.
 *
 * @author Vansh Sood
 */

public abstract class RPGCharacter<T> implements Comparable<T>{
    private String name;
    private int maxHP;
    private Point position;

    protected int currentHP;
    protected int intellect;
    protected int strength;
    protected ArrayList<Attack> attackList;

    /**
     * Creates a new character object
     * @param name the name of the character
     * @param intellect the intellect of the character
     * @param strength the strength of the character
     * @param maxHP maximum HP of the character
     * @param position the current position of the character. Point class object
     */
    public RPGCharacter (String name, int intellect, int strength, int maxHP, Point position) {
        this.name = name;
        this.strength = strength;
        this.maxHP = maxHP;
        this.position = position;
        this.intellect = intellect;
        this.currentHP = this.maxHP;
        attackList = new ArrayList<Attack>();
    }
    public String getName () {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public Point getPosition() {
        return position;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void move(int x, int y) {
        position.translate(x,y);
    }

    /**
     * Method used to deal damage
     * @param attackModifier the damage to be dealt
     * @return false if currentHP is less than 0 and true for successfully attacking
     */
    public boolean takeDamage(int attackModifier){
        currentHP -= attackModifier;
        if (currentHP < 0) {
            currentHP = 0;
            return false;
        }
        return true;
    }

    /**
     * Method used to heal the character
     * @param modifier the amount of healing to be done
     * @return true if currentHP and maxHP are equal and false for successfully healing
     */
    public boolean heal(int modifier){
        if(currentHP < maxHP) {
            currentHP += modifier;
        }
        if(currentHP == maxHP) return true;
        if(currentHP + modifier > maxHP) {
            currentHP = maxHP;
            return true;
        }
        return false;
    }

    public abstract int attack(RPGCharacter character, int x);


    @Override
    public int compareTo(Object obj) {
        RPGCharacter character = (RPGCharacter) obj;
        if(character.getCurrentHP() > this.currentHP) return 1;
        if(character.getCurrentHP() == this.currentHP) return 0;
        return -1;
    }

    public String getAttacks() {
        String output = "";
        for(int i = 0; i < attackList.size(); i++){
            output += i  + " - " + attackList.get(i).toString() + "\n";
        }
        return output;
    }

    public String toString() {
        return name + " (" + getClass() + ") - " + currentHP + "/" + maxHP;
    }
}
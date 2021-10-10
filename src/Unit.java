

import java.util.ArrayList;

public class Unit {
    String name;
    int amount;
    boolean finished;
    String weapon;
    String movement;
    int stars;
    ArrayList<String> has;
    ArrayList<String > needs;

    public Unit(String name, int amount, boolean finished, String weapon, String movement, int stars){
        this.name=name;
        this.amount=amount;
        this.finished=finished;
        this.stars=stars;
        this.weapon=weapon;
        this.movement=movement;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ArrayList<String> getHas() {
        return has;
    }

    public void setHas(ArrayList<String> has) {
        this.has = has;
    }

    public ArrayList<String> getNeeds() {
        return needs;
    }

    public void setNeeds(ArrayList<String> needs) {
        this.needs = needs;
    }
}

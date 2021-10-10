

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Unit {
    String name;
    int amount;
    boolean finished;
    String weapon;
    String movement;
    int stars;
    ObservableList<String> has;
    ObservableList<String > needs;

    public Unit(String name, int amount, boolean finished, String weapon, String movement, int stars){
        this.name=name;
        this.amount=amount;
        this.finished=finished;
        this.stars=stars;
        this.weapon=weapon;
        this.movement=movement;
        has = FXCollections.observableArrayList();
        needs = FXCollections.observableArrayList();
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

    public ObservableList<String> getHas() {
        return has;
    }

    public void setHas(ObservableList<String> has) {
        this.has = has;
    }

    public ObservableList<String> getNeeds() {
        return needs;
    }

    public void setNeeds(ObservableList<String> needs) {
        this.needs = needs;
    }
}

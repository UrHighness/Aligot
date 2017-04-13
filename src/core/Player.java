package core;

import physics.RigidBody;

import java.util.ArrayList;

public class Player extends GameObject{
    private String name;
    private int health, maxHealth;
    private ArrayList<Item> inventory;

    public Player(RigidBody rigidBody, String texture, String name, int health) {
        super(rigidBody, texture);
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

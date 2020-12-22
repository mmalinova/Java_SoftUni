package viceCity.models.guns;

import viceCity.common.ExceptionMessages;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun{
    private	String name;
    //o	All names are unique
    private	int bulletsPerBarrel;
    //o	The initial BulletsInBarrel count is the actual capacity of the barrel!
    private	int totalBullets;
    private	boolean canFire;
    private int capacity;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
        canFire = canFire();
        this.capacity = bulletsPerBarrel;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(NAME_NULL);
        }
        this.name = name;
    }

    public void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0) {
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    public void setTotalBullets(int totalBullets) {
        if (totalBullets < 0) {
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public boolean canFire() {
        return totalBullets > 0 || bulletsPerBarrel > 0;
    }

    @Override
    public abstract int fire();
    //It shoots bullets and returns the number of bullets that were shot. Here is how it works:
    //•	Your guns have a barrel, which have a certain capacity for bullets and you shoot a different count of bullets when you pull the trigger.
    //•	If your barrel becomes empty, you need to reload before you can shoot again.
    //•	Reloading is done by refilling the whole barrel of the gun (Keep in mind, that every barrel has capacity).
    //•	The bullets you take for reloading are taken from the gun's total bullets stock.


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }

    protected void reload() {
        if (totalBullets >= capacity) {
            bulletsPerBarrel = capacity;
            totalBullets -= capacity;
        }
    }

    protected int decreaseBullets(int bullets) {
        bulletsPerBarrel -= bullets;
        int firedBullets = bullets;
        if (bulletsPerBarrel < 0) {
            bulletsPerBarrel = 0;
            firedBullets = 0;
        }
        return firedBullets;
    }
}

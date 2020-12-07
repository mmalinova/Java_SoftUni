package CounterStriker.models.players;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

public abstract class PlayerImpl implements Player{
    private String username;
    //o	All names are unique
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl (String username, int health, int armor, Gun gun){
        setUsername(username);
        setHealth(health);
        setAlive(health);
        setArmor(armor);
        setGun(gun);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    public void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    public void setAlive(int health) {
        if (health < 0) {
            isAlive = false;
        }
        isAlive = true;
    }

    public void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        decreaseArmor(points);
    }

    protected void decreaseArmor(int points) {
        if (this.armor >= points) {
            this.armor -= points;
        } else {
            decreaseHealth(points);
        }
    }

    protected void decreaseHealth(int points) {
        this.health -= points;
        if (this.health <= 0) {
            this.isAlive = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //"{player type}: {player username}
        //--Health: {player health}
        //--Armor: {player armor}
        //--Gun: {player gun name}"
        sb.append(getClass().getSimpleName()).append(": ").append(username)
                .append(System.lineSeparator())
                .append("--Health: ").append(health)
                .append(System.lineSeparator())
                .append("--Armor: ").append(armor)
                .append(System.lineSeparator())
                .append("--Gun: ").append(gun.getName());
        return sb.toString().trim();
    }
}

package robotService.models.robots;

import robotService.common.ExceptionMessages;
import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot {
    private	String name;
    private	int happiness;
    private	int energy;
    private	int procedureTime;
    private	String owner;
    private	boolean isBought;
    private	boolean isRepaired;

    protected BaseRobot(String name, int energy, int happiness, int procedureTime) {
        setName(name);
        setHappiness(happiness);
        setEnergy(energy);
        setProcedureTime(procedureTime);
        this.owner = "Service";
        this.isBought = false;
        this.isRepaired = false;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHappiness() {
        return happiness;
    }

    @Override
    public void setHappiness(int happiness) {
        if (this.happiness < 0 || this.happiness > 100) {
            throw new IllegalArgumentException(INVALID_HAPPINESS);
        }
        this.happiness = happiness;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void setEnergy(int energy) {
        if (this.energy < 0 || this.energy > 100) {
            throw new IllegalArgumentException(INVALID_ENERGY);
        }
        this.energy = energy;
    }

    @Override
    public int getProcedureTime() {
        return procedureTime;
    }

    @Override
    public void setProcedureTime(int procedureTime) {
        this.procedureTime = procedureTime;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isBought() {
        return isBought;
    }

    @Override
    public void setBought(boolean bought) {
        isBought = bought;
    }

    @Override
    public boolean isRepaired() {
        return isRepaired;
    }

    @Override
    public void setRepaired(boolean repaired) {
        isRepaired = repaired;
    }
}

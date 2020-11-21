package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    public Add() {

    }

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = data[1];
        Unit unitToAdd = unitFactory.createUnit(unitType);
        repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}

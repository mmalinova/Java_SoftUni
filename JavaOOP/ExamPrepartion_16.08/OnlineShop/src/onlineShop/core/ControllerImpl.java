package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    List<Computer> computers;
    List<Component> components;
    List<Peripheral> peripherals;

    public ControllerImpl() {
        computers = new ArrayList<>();
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        for (Computer computer : computers) {
            if (computer.getId() == id) {
                throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
            }
        }

        Computer computer;
        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            case"Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        computers.add(computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer,
                                String model, double price, double overallPerformance, String connectionType) {
        checkComputerId(computerId);

        boolean match = peripherals.stream().anyMatch(per -> per.getId() == id);
        if (match) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }

        Peripheral peripheral;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                computer.addPeripheral(peripheral);
                break;
            }
        }

        peripherals.add(peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        checkComputerId(computerId);

        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                computer.removePeripheral(peripheralType);
                break;
            }
        }

        Peripheral per = peripherals.stream().filter(peripheral -> peripheral.getClass().getSimpleName()
                .equals(peripheralType)).findFirst().orElse(null);

        peripherals.remove(per);
        if (per != null) {
            return String.format(REMOVED_PERIPHERAL, peripheralType, per.getId());
        } else {
            return null;
        }
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer,
                               String model, double price, double overallPerformance, int generation) {
        checkComputerId(computerId);

        boolean match = components.stream().anyMatch(comp -> comp.getId() == id);
        if (match) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                computer.addComponent(component);
                break;
            }
        }

        components.add(component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        checkComputerId(computerId);

        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                computer.removeComponent(componentType);
                break;
            }
        }

        Component comp = components.stream().filter(component -> component.getClass().getSimpleName()
                .equals(componentType)).findFirst().orElse(null);

        components.remove(comp);
        if(comp != null) {
            return String.format(REMOVED_COMPONENT, componentType, comp.getId());
        } else {
            return null;
        }
    }

    @Override
    public String buyComputer(int id) {
        checkComputerId(id);

        Computer computer = computers.stream().filter(comp -> comp.getId() == id)
                .findFirst().orElse(null);

        if (computer != null) {
            computers.remove(computer);
            return computer.toString();
        } else {
            return null;
        }
    }

    @Override
    public String BuyBestComputer(double budget) {
        /*List<Computer> filteredComputers = computers.stream().filter(c -> c.getPrice() <= budget)
                .sorted(Comparator.comparing(Computer::getOverallPerformance).reversed())
                .collect(Collectors.toList());

        if (filteredComputers.isEmpty()) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        Computer computer = filteredComputers.get(0);
        computers.remove(computer.getId());

        return computer.toString();

         */
        List<Computer> sorted = computers.stream().sorted(Comparator.comparing(Computer::getOverallPerformance))
                .collect(Collectors.toList());

        Computer computerAccordingBudget;
        for (Computer computer : sorted) {
            if (computer.getPrice() <= budget) {
                computerAccordingBudget = computer;
                computers.remove(computerAccordingBudget);
                return computerAccordingBudget.toString();
            }
        }
        throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
    }

    @Override
    public String getComputerData(int id) {
        checkComputerId(id);

        Computer computer = computers.stream().filter(comp -> comp.getId() == id).findFirst().orElse(null);
        if (computer != null) {
            return computer.toString();
        } else {
            return null;
        }
    }

    private void checkComputerId(int computerId) {
        boolean anyMatch = computers.stream().anyMatch(computer -> computer.getId() == computerId);
        if (!anyMatch) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }
}

package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer{
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (components.stream().anyMatch(comp -> comp.getClass().getSimpleName()
                .equals(component.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(),
                    this.getClass().getSimpleName(), this.getId()));
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (components.stream().noneMatch(component -> component.getClass().getSimpleName()
                .equals(componentType))) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType,
                    this.getClass().getSimpleName(), this.getId()));
        }
        Component component = components.stream().filter(comp -> comp.getClass().getSimpleName()
                .equals(componentType)).findFirst().orElse(null);
        components.remove(component);

        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.stream().anyMatch(per -> per.getClass().getSimpleName()
                .equals(peripheral.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(),
                    this.getClass().getSimpleName(), this.getId()));
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (peripherals.stream().noneMatch(per -> per.getClass().getSimpleName()
                .equals(peripheralType))) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType,
                    this.getClass().getSimpleName(), this.getId()));
        }
        Peripheral peripheral = peripherals.stream().filter(per -> per.getClass().getSimpleName()
                .equals(peripheralType)).findFirst().orElse(null);
        peripherals.remove(peripheral);

        return peripheral;
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()) {
            return super.getOverallPerformance();
        } else {
            return components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0) +
                    super.getOverallPerformance();
        }
    }

    @Override
    public double getPrice() {
        return super.getPrice() + components.stream().mapToDouble(Component::getPrice).sum() +
                peripherals.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(super.toString()).append(System.lineSeparator());
        output.append(String.format(OutputMessages.COMPUTER_COMPONENTS_TO_STRING, components.size())).append(System.lineSeparator());
        components.forEach(component -> output.append("  ").append(component.toString()).append(System.lineSeparator()));

        output.append(String.format(OutputMessages.COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(),
                peripherals.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0)))
                .append(System.lineSeparator());
        peripherals.forEach(peripheral -> output.append("  ").append(peripheral.toString()).append(System.lineSeparator()));

        return output.toString().trim();
    }
}

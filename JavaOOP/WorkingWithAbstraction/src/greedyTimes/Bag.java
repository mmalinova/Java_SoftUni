package greedyTimes;

import java.util.*;

public class Bag {
    private List<Gold> gold;
    private List<Gem> gems;
    private List<Cash> cash;
    private long capacity;
    private long amount;

    public Bag(long capacity) {
        this.gold = new ArrayList<>();
        this.gems = new ArrayList<>();
        this.cash = new ArrayList<>();
        this.capacity = capacity;
        this.amount = 0;
    }

    public void addGold(Gold gold) {
        boolean toAdd = true;
        if (capacity >= amount + gold.getAmount()) {
            for (Gold item : this.gold) {
                if (item.getName().equals(gold.getName())) {
                    item.setAmount(item.getAmount() + gold.getAmount());
                    toAdd = false;
                }
            }
            if (toAdd) {
                this.gold.add(gold);
            }
            amount += gold.getAmount();
        }
    }

    public void addGem(Gem gem) {
        boolean toAdd = true;
        if (capacity >= amount + gem.getAmount()) {
            long goldAmount = this.gold.stream().mapToLong(Gold::getAmount).sum();
            long gemsAmount = this.gems.stream().mapToLong(Gem::getAmount).sum() + gem.getAmount();
            if (gemsAmount <= goldAmount) {
                for (Gem item : this.gems) {
                    if (item.getName().equals(gem.getName())) {
                        item.setAmount(item.getAmount() + gem.getAmount());
                        toAdd = false;
                    }
                }
                if (toAdd) {
                    this.gems.add(gem);
                }
                amount += gem.getAmount();
            }
        }
    }

    public void addCash(Cash cash) {
        boolean toAdd = true;
        if (capacity >= amount + cash.getAmount()) {
            long gemsAmount = this.gems.stream().mapToLong(Gem::getAmount).sum();
            long cashAmount = this.cash.stream().mapToLong(Cash::getAmount).sum() + cash.getAmount();
            if (cashAmount <= gemsAmount) {
                for (Cash item : this.cash) {
                    if (item.getName().equals(cash.getName())) {
                        item.setAmount(item.getAmount() + cash.getAmount());
                        toAdd = false;
                    }
                }
                if (toAdd) {
                    this.cash.add(cash);
                }
                amount += cash.getAmount();
            }
        }
    }

    public String printGold() {
        StringBuilder sb = new StringBuilder();
        this.gold.stream().sorted((v1, v2) -> v2.getName().compareTo(v1.getName()))
                .sorted(Comparator.comparingLong(Gold::getAmount))
                .forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    public String printGems() {
        StringBuilder sb = new StringBuilder();
        this.gems.stream().sorted((v1, v2) -> v2.getName().compareTo(v1.getName()))
                .sorted(Comparator.comparingLong(Gem::getAmount))
                .forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    public String printCash() {
        StringBuilder sb = new StringBuilder();
        this.cash.stream().sorted(Comparator.comparingLong(Cash::getAmount))
                .sorted((v1, v2) -> v2.getName().compareTo(v1.getName()))
                .forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.gold.size() > 0) {
            sb.append(String.format("<Gold> $%d", this.gold.stream().mapToLong(Gold::getAmount).sum())).append(System.lineSeparator());
            sb.append(printGold()).append(System.lineSeparator());
        }
        if (this.gems.size() > 0) {
            sb.append(String.format("<Gem> $%d", this.gems.stream().mapToLong(Gem::getAmount).sum())).append(System.lineSeparator());
            sb.append(printGems()).append(System.lineSeparator());
        }
        if (this.cash.size() > 0) {
            sb.append(String.format("<Cash> $%d", this.cash.stream().mapToLong(Cash::getAmount).sum())).append(System.lineSeparator());
            sb.append(printCash()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

package bakery.repositories;

import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl<Table> implements TableRepository<Table> {
    private Collection<Table> models;

    @Override
    public Table getByNumber(int number) {
        for (Table model : models) {
            if (model instanceof InsideTable) {
                if (((InsideTable) model).getTableNumber() == number) {
                    return model;
                }
            }
            if (model instanceof OutsideTable) {
                if (((OutsideTable) model).getTableNumber() == number) {
                    return model;
                }
            }
        }
        return null;
    }

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAll() {
        return this.models;
    }

    @Override
    public void add(Table table) {
        this.models.add(table);
    }
}

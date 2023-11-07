package ro.fasttrackit.course17.homework.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.unmodifiableList;

public class Shop<T extends ShopItem> {
    private final List<T> items;

    public Shop(List<T> items) {
        this.items = new ArrayList<>(items);
    }

    public T addItem(T newItem) {
        validateItem(newItem);
        items.add(newItem);
        return newItem;
    }

    public List<T> findByCategory(Category category) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (item.category() == category) {
                result.add(item);
            }
        }
        return result;
    }

    public Optional<T> findByName(String name) {
        for (T item : items) {
            if (item.name().equalsIgnoreCase(name)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public List<T> getItems() {
        return unmodifiableList(items);
    }

    private void validateItem(T item) {
        if (item.name().isEmpty() || item.name() == null) {
            throw new RuntimeException("Invalid name was introduced: %s".formatted(item.name()));
        }

        if (item.price() <= 0) {
            throw new RuntimeException("Invalid price was introduced: %s".formatted(item.price()));
        }

        if (item.category() == null) {
            throw new RuntimeException("Please provide a category");
        }
    }
}

package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;

public record Stock(Integer price) implements Comparable {
    @Override
    public int compareTo(@NotNull Object o) {
        if (this.equals((Stock) o)) {
            return 0;
        }
        return this.price() > ((Stock) o).price() ? 1 : -1;
    }
}

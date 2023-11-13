package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class BackwardIterator<T> implements Iterator<T> {
    BackwardIterator(List<T> list) {
        this.realIterator = list.listIterator();
        while (this.realIterator.hasNext()) {
            this.realIterator.next();
        }
    }

    private final ListIterator<T> realIterator;

    @Override
    public boolean hasNext() {
        return realIterator.hasPrevious();
    }

    @Override
    public T next() {
        return realIterator.previous();
    }

    @Override
    public void remove() {
        realIterator.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        realIterator.forEachRemaining(action);
    }
}

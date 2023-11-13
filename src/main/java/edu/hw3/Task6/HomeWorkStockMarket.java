package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HomeWorkStockMarket implements StockMarket {
    private final PriorityQueue<Stock> stocks = new PriorityQueue<Stock>(Comparator.reverseOrder());

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}

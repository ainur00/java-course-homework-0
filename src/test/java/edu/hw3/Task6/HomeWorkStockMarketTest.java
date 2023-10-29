package edu.hw3.Task6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeWorkStockMarketTest {
    @Test
    void giveCommandsShouldWorkCorrect() {
        HomeWorkStockMarket market = new HomeWorkStockMarket();
        market.add(new Stock(7));
        market.add(new Stock(5));
        market.add(new Stock(9));
        market.remove(new Stock(9));
        Assertions.assertThat(market.mostValuableStock()).isEqualTo(new Stock(7));
    }
}

package edu.hw3.Task8;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BackwardIteratorTest {
    @Test
    void giveListShouldIterateItBackward() {
        BackwardIterator<Integer> bIter = new BackwardIterator<>(List.of(1, 2, 3));
        ArrayList<Integer> bIterReturns = new ArrayList<>();
        while (bIter.hasNext()) {
            bIterReturns.add(bIter.next());
        }
        Assertions.assertThat(bIterReturns).isEqualTo(new ArrayList<Integer>(Arrays.asList(3, 2, 1)));
    }
}

package edu.hw2.Task3;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class FaultyConnectionTest {
    @Test
    void faultyConnectionShouldCanThrowConnectionEx() {
        Connection faultyConnection = new FaultyConnection();
        Assertions.assertThatThrownBy(() -> {
            faultyConnection.execute("test");
        }).isExactlyInstanceOf(ConnectionException.class);
    }
}

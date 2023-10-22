package edu.hw2.Task3;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class FaultyConnectionManagerTest {

    @Test
    void faultyConnectionManagerShouldReturnFaultyConnection() {
        ConnectionManager faultyConnectionManager = new DefaultConnectionManager();
        Connection returnedConnection = faultyConnectionManager.getConnection();
        Assertions.assertThat(returnedConnection).isExactlyInstanceOf(FaultyConnection.class);
    }
}

package edu.hw2.Task3;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class DefaultConnectionManagerTest {

    @Test
    void defaultConnectionManagerShouldCanReturnFaultyConnection() {
        ConnectionManager defaultConnectionManager = new DefaultConnectionManager();
        Connection returnedConnection = defaultConnectionManager.getConnection();
        Assertions.assertThat(returnedConnection).isExactlyInstanceOf(FaultyConnection.class);
    }
}

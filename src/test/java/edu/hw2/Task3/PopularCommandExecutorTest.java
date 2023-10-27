package edu.hw2.Task3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PopularCommandExecutorTest {

    @Test
    void tryUpdatePackagesShouldCanThrowConnectionEx() {
        PopularCommandExecutor popularCommandExecutor = new PopularCommandExecutor(new FaultyConnectionManager(), 5);
        Assertions.assertThatThrownBy(() -> {
            popularCommandExecutor.updatePackages();
        }).hasCause(new ConnectionException());
    }
}

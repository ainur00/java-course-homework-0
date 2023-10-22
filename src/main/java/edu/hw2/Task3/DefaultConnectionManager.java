package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager {
    private final static Double STABLE_CONNECTION_CHANCE = 0.0;

    public Connection getConnection() {
        return (Math.random() >= STABLE_CONNECTION_CHANCE ? new FaultyConnection() : new StableConnection());
    }
}

package edu.hw2.Task3;

public class FaultyConnection implements Connection {
    private final static Double SUCCESS_CHANCE = 0.0;

    public void execute(String command) {
        if (Math.random() >= SUCCESS_CHANCE) {
            throw new ConnectionException();
        }
    }

    public void close() {}
}

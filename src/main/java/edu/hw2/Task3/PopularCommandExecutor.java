package edu.hw2.Task3;

public final class PopularCommandExecutor {
    PopularCommandExecutor(ConnectionManager connectionManager, int maxAttempts) {
        this.connectionManager = connectionManager;
        this.maxAttempts = maxAttempts;
    }

    private final ConnectionManager connectionManager;

    private final int maxAttempts;

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        int attempt = 0;
        Connection connection = connectionManager.getConnection();
        while (true) {
            try {
                connection.execute(command);
                connection.close();
                break;
            } catch (ConnectionException connectionException) {
                if (attempt > maxAttempts) {
                    connection.close();
                    throw new RuntimeException("Connection exception", connectionException);
                }
            }
            ++attempt;
        }
    }
}

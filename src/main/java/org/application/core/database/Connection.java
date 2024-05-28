package org.application.core.database;

import org.application.core.Native;
import org.application.core.util.List;

public class Connection extends Native {
    protected static List<Connection> connections = new List<>();
    protected String storage;

    public static Connection getConnection(String storage) {
        if (connections.size() > 0) {
            for (Connection connection : connections) {
                if (connection.storage.equals(storage)) {
                    return connection;
                }
            }
        }
        return new Connection(storage);
    }

    private Connection(String storage) {
        this.storage = storage;
        connections.add(this);
    }
}

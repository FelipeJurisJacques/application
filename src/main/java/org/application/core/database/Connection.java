package org.application.core.database;

import org.application.core.directrix.Directrix;
import org.application.core.util.List;

public class Connection extends Directrix {
    // protected static List<Connection> connections = new List<>();
    protected String storage;

    // public static Connection getConnection(String storage) {
    //     if (connections.size() > 0) {
    //         for (Connection connection : connections) {
    //             if (connection.storage.equals(storage)) {
    //                 return connection;
    //             }
    //         }
    //     }
    //     return new Connection(storage);
    // }

    public Connection(String storage) {
        this.storage = storage;
        // connections.add(this);
    }
}

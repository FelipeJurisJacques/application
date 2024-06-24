package org.application.core;

import org.application.core.directrix.Property;

public class Location {
    private static Property property = Property.global("location");

    public static String path() {
        return property.get("pathname").asString();
    }
}

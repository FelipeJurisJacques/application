package org.application.core.draw;

import java.util.List;
import java.util.ArrayList;

public class ClipPatch {
    private List<Vector2> path = new ArrayList<>();

    public void move(float x, float y) {
        path.add(new Vector2(x, y));
    }

    public void move(float x, float y, boolean relative) {
        path.add(new Vector2(x, y, relative));
    }
}

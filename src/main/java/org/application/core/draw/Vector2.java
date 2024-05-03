package org.application.core.draw;

public class Vector2 {    
    float x;
    float y;
    boolean relative;
    
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
        this.relative = false;
    }

    public Vector2(float x, float y, boolean relative) {
        this.x = x;
        this.y = y;
        this.relative = relative;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isRelative() {
        return relative;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setRelative(boolean relative) {
        this.relative = relative;
    }
}

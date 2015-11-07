package com.gangaraju.battleship;

/**
 * Created by gangaraju on 7/11/15.
 */

// ship with 1X3
// __________
// |  |  |  | width
// ----------
//    length

public class Ship {

    private int width;

    private int length;

    private int x,y;

    public Ship(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

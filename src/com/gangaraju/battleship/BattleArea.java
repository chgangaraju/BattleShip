package com.gangaraju.battleship;

import com.gangaraju.battleship.exception.InvalidShipPlacementException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gangaraju on 7/11/15.
 */
public class BattleArea {

    private int width;
    private int length;

    private List<Ship> ships;

    public char[][] getCells() {
        return cells;
    }

    public void setCells(char[][] cells) {
        this.cells = cells;
    }

    private char[][] cells;

    public BattleArea() {

    }

    public BattleArea(int width, int length) {
        this.width = width;
        this.length = length;
        this.cells = new char[width][length];
        ships = new ArrayList<>();
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < length; col++) {
                cells[row][col] = '*';
            }
        }

    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
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

    public void draw() {
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < length; col++) {
                System.out.print(cells[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void placeShip(Ship ship, int x, int y, int shipNumber) {
        ships.add(ship);
        for (int i = y; i < y + ship.getWidth(); i++) {
            for (int j = x; j < x + ship.getLength(); j++) {
                if(i < getLength() && j< getWidth()) {
                    if ((this.getCells()[i][j]) == '*') {
                        this.getCells()[i][j] = Character.forDigit(shipNumber + 1, 10);
                    } else {
                        throw new InvalidShipPlacementException("Ship was overlapped on existing ship");
                    }
                } else {
                    throw new InvalidShipPlacementException("Ship X,Y cordinates crossing the BattleArea");
                }

            }
        }

    }
}

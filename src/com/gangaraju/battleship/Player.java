package com.gangaraju.battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by gangaraju on 7/11/15.
 */
public class Player {

    private String name;

    private BattleArea battleArea;


    public Player(String name) {
        this.name=name;
        this.battleArea=new BattleArea();
    }

    public BattleArea getBattleArea() {
        return battleArea;
    }

    public void setBattleArea(BattleArea battleArea) {
        this.battleArea = battleArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void fire(BattleArea battleArea) throws IOException {
        System.out.println("Enter location to fire");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dimensions = br.readLine();
        String[] dimension = dimensions.split(" ");
        int x = Integer.parseInt(dimension[0].toString());
        int y = Integer.parseInt(dimension[1].toString());
        fire(x, y, battleArea);
    }

    public void fire(int length, int width, BattleArea battleArea) throws IOException {
        if(battleArea.getCells()[width][length] !='*') {
            battleArea.getCells()[width][length] = '*';
            fire(battleArea);
        }
    }

}

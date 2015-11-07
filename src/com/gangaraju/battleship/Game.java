package com.gangaraju.battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gangaraju on 7/11/15.
 */
public class Game {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter player name");
        String player1Name = br.readLine();
        Player player1 = new Player(player1Name);
        BattleArea battleArea1 = game.createBattleArea();
        player1.setBattleArea(battleArea1);

        System.out.println("Enter player name");
        String player2Name = br.readLine();
        Player player2 = new Player(player2Name);
        BattleArea battleArea2 = game.createBattleArea();
        player1.setBattleArea(battleArea2);

        while (true) {
            System.out.println("Player1 turn");
            player1.fire(battleArea2);
            battleArea2.draw();

            System.out.println("Player2 turn");
            player2.fire(battleArea1);
            battleArea1.draw();
        }
    }

    public BattleArea createBattleArea() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Creating BattleArea

        System.out.println("Enter size of Battele Area M x N");

        String dimensions = br.readLine();
        String[] dimension = dimensions.split(" ");
        int m = Integer.parseInt(dimension[0].toString());
        int n = Integer.parseInt(dimension[1].toString());
        BattleArea battleArea = new BattleArea(m, n);
        battleArea.draw();

        // Creating ships
        System.out.println("Enter number of ships");
        int numberOfShips = Integer.parseInt(br.readLine());
        List<Ship> ships = new ArrayList<>(numberOfShips);
        battleArea.setShips(ships);
        System.out.println("Enter ship sizes:");
        for (int i = 0; i < numberOfShips; i++) {
            System.out.println("Enter " + (i + 1) + " th ship in A x B");
            dimension = dimensions.split(" ");
            dimensions = br.readLine();
            dimension = dimensions.split(" ");
            int a = Integer.parseInt(dimension[0].toString());
            int b = Integer.parseInt(dimension[1].toString());
            Ship ship = new Ship(a, b);
            System.out.println("Enter x,y position of ship");
            dimensions = br.readLine();
            dimension = dimensions.split(" ");
            int x = Integer.parseInt(dimension[0].toString());
            int y = Integer.parseInt(dimension[1].toString());
            battleArea.placeShip(ship, x, y, i);
            battleArea.draw();
        }
        return battleArea;
    }
}

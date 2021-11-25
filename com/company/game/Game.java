package com.company.game;

import com.company.characters.Character;
import com.company.characters.Hero;
import com.company.classes.Archer;
import com.company.classes.Knight;
import com.company.classes.Wizard;
import com.company.enemies.AttackMagic;
import com.company.enemies.AttackSword;
import com.company.enemies.Enemy;

import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    private static Game instance;
    private Character hero;
    private LinkedList<Event> events;

    private Game() {
        events = new LinkedList<>();
    }

    public static Game getInstance() {
        if(instance == null) {
            instance = new Game();
        }
        return instance;
    }

    private void script() {
        Enemy boss1 = new Enemy("Crazy Knight", 150, 40, new AttackSword(20));
        Event event1 = new Event("First round", boss1, 1);
        event1.generateEnemies(3);

        Enemy boss2 = new Enemy("Crazy Wizard", 150, 40, new AttackMagic(40));
        Event event2 = new Event("Second round", boss2, 2);
        event2.generateEnemies(2);

        events.add(event1);
        events.add(event2);
    }

    public void play() {
        script();

        System.out.println("Welcome!\n" +
                "Please enter your name!");
        Scanner scanner = new Scanner(System.in);
        String heroName = scanner.nextLine();
        hero = new Hero(heroName, 200, 200, 1, 20, 5);

        System.out.println("Please choose you class: " +
                "\n1)Wizard" +
                "\n2)Knight" +
                "\n3)Archer");
        int classNum = 0;
        while (!(classNum >= 1 && classNum <= 3)) {
            classNum = scanner.nextInt();
        }

        if(classNum == 1)
            hero = new Wizard(hero);
        else if(classNum == 2)
            hero = new Knight(hero);
        else
            hero = new Archer(hero);

        for(int i = 0; i < 5; i++)
            hero.addHealingItem();

        for (Event event: events) {
            boolean result = event.playEvent(hero);
            if(result)
                for(int i = 0; i < 3; i++)
                    hero.addHealingItem();
            else {
                System.out.println("You have lost.");
                return;
            }
        }

        System.out.println("Congratulations!\n" +
                "You have beaten the game!");
    }
}

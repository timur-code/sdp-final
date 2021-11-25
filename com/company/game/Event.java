package com.company.game;

import com.company.characters.Character;
import com.company.enemies.Enemy;
import com.company.factories.EnemyFactory;
import com.company.helpers.Messages;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Scanner;

public class Event {
    private String eventName;
    private List<Enemy> enemies;
    private Enemy boss;
    private EnemyFactory enemyFactory;
    private Integer difficulty;

    public Event(String eventName, Enemy boss, Integer difficulty) {
        this.eventName = eventName;
        this.boss = boss;
        this.difficulty = difficulty;
        enemyFactory = EnemyFactory.getInstance();
    }

    public void generateEnemies(Integer count) {
        int randomType = (int) (Math.random() * 3 + 1); //Will generate random number from 1 to 3

        if(randomType == 1)
            enemies = enemyFactory.generateEnemies(count, Messages.MAGIC, difficulty);
        else if(randomType == 2)
            enemies = enemyFactory.generateEnemies(count, Messages.SWORD, difficulty);
        else
            enemies = enemyFactory.generateEnemies(count, Messages.BOW, difficulty);
    }

    public boolean playEvent(Character hero) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have stated an event.");

        while(!enemies.isEmpty()) {
            System.out.println("Fight " + enemies.get(0).getName());
            boolean defeated = false;
            int turn = 0;

            while(!defeated) {
                if(turn % 2 == 0) {
                    System.out.println("Enemy hp: " + enemies.get(0).getHp());
                    System.out.println("Your hp :" + hero.getHp());
                    System.out.println("Choose your action: \n" +
                            "1) Attack \n" +
                            "2) Heal");

                    try {
                        choice = scanner.nextInt();
                    } catch (Exception ex) {
                        System.out.println("Enter a number!");
                        turn--;
                    }

                    if(choice == 1) {
                        System.out.println(hero.attack(enemies.get(0)));
                        if(enemies.get(0).getStatus().equals(Messages.ENEMY_DIED)) {
                            defeated = true;
                            enemies.remove(0);
                            System.out.println(hero.addLevel() + '\n');
                        }
                    } else if(choice == 2) {
                        System.out.println(hero.useHeal());
                    }
                } else {
                    String result = enemies.get(0).attackCharacter(hero);
                    System.out.println(result + '\n');
                    if (result.equals(Messages.DIED))
                        return false;
                }

                turn++;
            }
        }

        System.out.println("\nNow you will encounter a boss of the level.\n" +
                "You will fight a " + boss.getName() + "\n");

        int turn = 0;
        boolean defeatedBoss = false;

        while (!defeatedBoss) {
            if(turn % 2 == 0) {
                System.out.println("Enemy hp: " + boss.getHp());
                System.out.println("Your hp :" + hero.getHp());
                System.out.println("Choose your action: \n" +
                        "1) Attack \n" +
                        "2) Heal");

                try {
                    choice = scanner.nextInt();
                } catch (Exception ex) {
                    System.out.println("Enter a number!");
                    turn--;
                }

                if(choice == 1) {
                    System.out.println(hero.attack(boss));
                    if(boss.getStatus().equals(Messages.ENEMY_DIED)) {
                        defeatedBoss = true;
                    }
                } else if(choice == 2) {
                    System.out.println(hero.useHeal());
                }
            } else {
                String result = boss.attackCharacter(hero);
                System.out.println(result);
                if (result.equals(Messages.DIED))
                    return false;
            }

            turn++;
        }

        System.out.println("Congratulations!\n" +
                "You have cleared this level!");
        return true;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public Enemy getBoss() {
        return boss;
    }

    public void setBoss(Enemy boss) {
        this.boss = boss;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public EnemyFactory getEnemyFactory() {
        return enemyFactory;
    }

    public void setEnemyFactory(EnemyFactory enemyFactory) {
        this.enemyFactory = enemyFactory;
    }
}

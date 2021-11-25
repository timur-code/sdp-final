package com.company.factories;

import com.company.enemies.AttackBow;
import com.company.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class BowFactory implements Factory{
    public BowFactory() {

    }

    @Override
    public List<Enemy> generateEnemies(Integer count, String name, Integer hp, Integer attack) {
        ArrayList<Enemy> enemyList = new ArrayList<>(count);

        for(int i = 0; i < count; i++) {
            enemyList.add(new Enemy(name, hp, attack, new AttackBow(attack)));
        }

        return enemyList;
    }
}

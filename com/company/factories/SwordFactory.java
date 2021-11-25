package com.company.factories;

import com.company.enemies.AttackSword;
import com.company.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class SwordFactory implements Factory{
    public SwordFactory() {

    }

    @Override
    public List<Enemy> generateEnemies(Integer count, String name, Integer hp, Integer attack) {
        ArrayList<Enemy> enemyList = new ArrayList<>(count);

        for(int i = 0; i < count; i++) {
            enemyList.add(new Enemy(name, hp, attack, new AttackSword(attack)));
        }

        return enemyList;
    }
}

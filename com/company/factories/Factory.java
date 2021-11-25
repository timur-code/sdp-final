package com.company.factories;

import com.company.enemies.Enemy;

import java.util.List;

public interface Factory {
    public List<Enemy> generateEnemies(Integer count, String name, Integer hp, Integer attack);
}

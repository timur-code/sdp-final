package com.company.factories;

import com.company.enemies.Enemy;
import com.company.helpers.Messages;

import java.util.List;

public class EnemyFactory {
    private static EnemyFactory instance;
    private MagicFactory magicFactory;
    private BowFactory bowFactory;
    private SwordFactory swordFactory;

    private EnemyFactory() {
        magicFactory = new MagicFactory();
        bowFactory = new BowFactory();
        swordFactory = new SwordFactory();
    }

    public static EnemyFactory getInstance() {
        if(instance == null) {
            instance = new EnemyFactory();
        }
        return instance;
    }

    public List<Enemy> generateEnemies(Integer count, String attackType, Integer difficulty) {
        Integer hp = (int) (difficulty * 100);
        Integer attack = (int) (difficulty * 15);
        if (difficulty != 1){
            hp = (int) (1.5 * 100);
            attack = (int) (1.5 * 15);
        }

        if(attackType.equals(Messages.MAGIC)) {
            return magicFactory.generateEnemies(count, "Evil Magician", hp, attack);
        } else if(attackType.equals(Messages.SWORD)) {
            return swordFactory.generateEnemies(count, "Evil Knight", hp, attack);
        } else {
            return bowFactory.generateEnemies(count, "Evil Archer", hp, attack);
        }
    }
}

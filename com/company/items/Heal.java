package com.company.items;

import com.company.characters.Character;
import com.company.characters.Hero;

public class Heal {
    private final String name = "potion";
    private final Integer recoverHP = 100;

    public Heal() {
    }

    public String use(Hero hero) {
        hero.setHp(hero.getHp() + recoverHP);
        return "Recovered " + recoverHP + '\n' +
                "Current hp is " + hero.getHp();
    }

    public String getName() {
        return name;
    }

    public Integer getRecoverHP() {
        return recoverHP;
    }
}

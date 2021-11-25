package com.company.enemies;

import com.company.characters.Character;

public class AttackBow implements AttackStrategy{
    private Integer attack;

    public AttackBow(Integer attack) {
        this.attack = attack;
    }

    @Override
    public String attack(Character hero) {
        Integer damage = attack;

        if (hero.getClass().getName().equals("com.company.classes.Wizard"))
            damage = (int)(attack * 1.5);

        return hero.takeDamage(damage);
    }
}

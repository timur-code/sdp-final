package com.company.classes;

import com.company.characters.Character;
import com.company.enemies.Enemy;
import com.company.items.Heal;

public abstract class BaseClass implements Character {
    private Character hero;

    @Override
    public abstract String addLevel();

    @Override
    public abstract String attack(Enemy enemy);

    @Override
    public abstract String addHealingItem();

    @Override
    public abstract String useHeal();

    @Override
    public abstract Integer getAttack();

    @Override
    public abstract Integer getHp();

    @Override
    public abstract String takeDamage(Integer damage);
}

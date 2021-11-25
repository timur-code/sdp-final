package com.company.characters;

import com.company.enemies.Enemy;
import com.company.helpers.Messages;
import com.company.helpers.Messages.*;
import com.company.items.Heal;

public interface Character {
    public String addLevel();

    public String attack(Enemy enemy);

    public String addHealingItem();

    public String useHeal();

    public Integer getAttack();

    public Integer getHp();

    public String takeDamage(Integer damage);
}

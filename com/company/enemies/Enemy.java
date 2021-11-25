package com.company.enemies;

import com.company.characters.Character;
import com.company.helpers.Messages;

public class Enemy {
    private String name;
    private Integer hp;
    private Integer attack;
    private AttackStrategy attackStrategy;

    public Enemy(String name, Integer hp, Integer attack, AttackStrategy attackStrategy) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.attackStrategy = attackStrategy;
    }

    public String attackCharacter(Character hero) {
        return attackStrategy.attack(hero);
    }

    public String getStatus() {
        if(hp <= 0)
            return Messages.ENEMY_DIED;
        else
            return Messages.ENEMY_ALIVE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }


    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }


    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
}

package com.company.characters;

import com.company.enemies.Enemy;
import com.company.helpers.Messages;
import com.company.items.Heal;

import java.util.ArrayList;

public class Hero implements Character{
    private String name;
    private Integer maxHP;
    private Integer hp;
    private Integer level;
    private Integer attack;
    private Integer defense;
    private final ArrayList<Heal> healItems;

    public Hero(String name, Integer maxHP, Integer hp, Integer level, Integer attack, Integer defense) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = hp;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        healItems = new ArrayList<>();
    }

    @Override
    public String addLevel() {
        setLevel(level + 1);
        setMaxHP(maxHP + 5);
        setAttack(attack + 3);
        setDefense(defense + 2);
        return getName() + " has leveled up.";
    }

    public String attack(Enemy enemy) {
        return null;
    }

    public String addHealingItem() {
        Heal item = new Heal();
        healItems.add(item);
        return item.getName() + " was added.";
    }

    public String useHeal() {
        if(healItems.isEmpty())
            return "You don't have heals";

        Heal heal = healItems.remove(healItems.size() - 1);
        this.setHp(this.getHp() + heal.getRecoverHP());
        return this.getName() + " recovered " + heal.getRecoverHP();
    }

    @Override
    public String takeDamage(Integer damage) {
        Integer actualDamage = damage - defense;
        setHp(hp - actualDamage);

        if(hp > 0)
            return getName() + " received " + actualDamage + " damage.";
        else
            return Messages.DIED;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        if(hp <= maxHP)
            this.hp = hp;
        else
            this.hp = maxHP;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }
}

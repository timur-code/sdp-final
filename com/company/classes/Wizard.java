package com.company.classes;

import com.company.characters.Character;
import com.company.enemies.Enemy;

public class Wizard extends BaseClass{
    private Character hero;

    public Wizard(Character hero) {
        this.hero = hero;
    }

    @Override
    public String addLevel() {
        return hero.addLevel();
    }

    @Override
    public String attack(Enemy enemy) {
        int damage = getAttack();

        if(enemy.getAttackStrategy().getClass().getName().equals("com.company.enemies.AttackSword"))
            damage = (int)(getAttack() * 1.5);

        Integer hpAfterDamage = enemy.getHp() - damage;

        enemy.setHp(hpAfterDamage);
        return enemy.getName() + " received " + damage + " damage.";
    }

    @Override
    public String addHealingItem() {
        return hero.addHealingItem();
    }

    @Override
    public String useHeal() {
        return hero.useHeal();
    }

    @Override
    public Integer getAttack() {
        return hero.getAttack();
    }

    @Override
    public Integer getHp() {
        return hero.getHp();
    }

    @Override
    public String takeDamage(Integer damage) {
        return hero.takeDamage(damage);
    }
}

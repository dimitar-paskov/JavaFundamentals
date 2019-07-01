package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {


    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {

        if (attackPlayer.isDead() || enemyPlayer.isDead()){
            throw new IllegalArgumentException("Player is dead!");
        }

        if (attackPlayer.getClass().getSimpleName().equals("Beginner")){
            int attackerHealthPoints = attackPlayer.getHealth();
            attackPlayer.setHealth(attackerHealthPoints + 40);

            attackPlayer.getCardRepository().getCards().forEach(c->c.setDamagePoints(c.getDamagePoints()+30));
        }

        if (enemyPlayer.getClass().getSimpleName().equals("Beginner")){
            int enemyHealthPoints = enemyPlayer.getHealth();
            enemyPlayer.setHealth(enemyHealthPoints + 40);

            enemyPlayer.getCardRepository().getCards().forEach(c->c.setDamagePoints(c.getDamagePoints()+30));

        }

        int attackerBonusPoints = attackPlayer.getCardRepository().getCards().stream().mapToInt(Card::getHealthPoints).sum();
        int attackerHealthPoints = attackPlayer.getHealth();
        attackPlayer.setHealth(attackerHealthPoints + attackerBonusPoints);

        int enemyBonusPoints = enemyPlayer.getCardRepository().getCards().stream().mapToInt(Card::getHealthPoints).sum();
        int enemyHealthPoints = enemyPlayer.getHealth();
        enemyPlayer.setHealth(enemyHealthPoints + enemyBonusPoints);


        while((!attackPlayer.isDead()) && (!enemyPlayer.isDead())) {


            int attackPoints = attackPlayer.getCardRepository()
                    .getCards()
                    .stream()
                    .mapToInt(Card::getDamagePoints).sum();

            enemyHealthPoints = enemyPlayer.getHealth();

            if (enemyHealthPoints - attackPoints <= 0) {
                enemyPlayer.setHealth(0);
            } else {
                enemyPlayer.setHealth(enemyHealthPoints - attackPoints);
            }


            if (enemyPlayer.isDead()) {
                return;
            }

            attackPoints = enemyPlayer.getCardRepository()
                    .getCards()
                    .stream()
                    .mapToInt(Card::getDamagePoints).sum();

            attackerHealthPoints = attackPlayer.getHealth();

            if (attackerHealthPoints - attackPoints <= 0) {
                attackPlayer.setHealth(0);
            } else {
                attackPlayer.setHealth(attackerHealthPoints - attackPoints);
            }
        }


    }
}

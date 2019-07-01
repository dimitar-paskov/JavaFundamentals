package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {

    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.setUsername(username);
        this.setHealth(health);
        this.cardRepository = cardRepository;
        this.isDead = false;
    }


    private void setUsername(String username) {
        if (username==null || username.isEmpty()){
            throw new IllegalArgumentException("Player's username cannot be null or an empty string. ");
        }
        this.username = username;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0){
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero. ");
        }
        this.health = healthPoints;
        if (this.health==0){
            this.isDead = true;
        }

    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0){
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }

        this.health -=damagePoints;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Username: %s - Health: %d - Cards %d",this.username, this.health, this.cardRepository.getCount()));
        sb.append(System.lineSeparator());
        this.cardRepository.getCards().stream().forEach(c->sb.append(c.toString()).append(System.lineSeparator()));
        sb.append("###");
        return sb.toString();
    }
}

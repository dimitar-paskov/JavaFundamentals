package models.players;

import repositories.interfaces.CardRepository;

public class Beginner extends BasePlayer {
    private static final int BEGGINER_DEFAULT_HEALTH_POINTS = 50;
    public Beginner(CardRepository cardRepository, String username) {
        super(cardRepository, username, BEGGINER_DEFAULT_HEALTH_POINTS);
    }
}

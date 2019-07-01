package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardRepositoryImpl implements CardRepository {

    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        }

        for (Card existingCard :
                this.cards) {
            if (existingCard.getName().equals(card.getName())) {
                throw new IllegalArgumentException(String.format("Card %s already exists!", card.getName()));
            }
        }

        this.cards.add(card);

    }

    @Override
    public boolean remove(Card card) {

        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        }

        int size = this.getCount();

        this.cards = this.cards.stream()
                .filter(c->!c.getName().equals(card.getName()))
                .collect(Collectors.toList());

        if (size > this.getCount()){
            return true;
        }

        return false;
    }

    @Override
    public Card find(String name) {
        Card card = null;
        for (Card existingCard :
                this.cards) {
            if (existingCard.getName().equals(name)) {
                card = existingCard;
            }
        }
        return card;
    }
}

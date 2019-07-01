package core;

import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;


public class ManagerControllerImpl implements ManagerController {

    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
         this.playerRepository = new PlayerRepositoryImpl();
         this.cardRepository = new CardRepositoryImpl();
         this.battlefield = new BattleFieldImpl();


    }

    @Override
    public String addPlayer(String type, String username) {

        Player player = null;
        CardRepository cardRepository = new CardRepositoryImpl();
        switch (type){
            case "Beginner":{
                player = new Beginner(cardRepository,username);
            }break;
            case "Advanced":{
                player = new Advanced(cardRepository,username);
            }break;

        }

        this.playerRepository.add(player);

       return  String.format("Successfully added player of type %s with username: %s", type, username);
    }

    @Override
    public String addCard(String type, String name) {

        Card card = null;

        switch (type){
            case "Magic":{
                card = new MagicCard(name);
            }break;
            case "Trap":{
                card = new TrapCard(name);
            }break;
        }

        this.cardRepository.add(card);


        return  String.format("Successfully added card of type %sCard with name: %s", type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {

        Player player = this.playerRepository.find(username);
        Card card = this.cardRepository.find(cardName);

        player.getCardRepository().add(card);

        return  String.format("Successfully added card: %s to user: %s", cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {

        Player attacker = this.playerRepository.find(attackUser);
        Player enemy = this.playerRepository.find(enemyUser);

        this.battlefield.fight(attacker, enemy);



        return  String.format("Attack user health %s - Enemy user health %s", attacker.getHealth(), enemy.getHealth());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Player player :
                this.playerRepository.getPlayers()) {
            sb.append(player.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

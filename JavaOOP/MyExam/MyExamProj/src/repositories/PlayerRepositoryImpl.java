package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerRepositoryImpl implements PlayerRepository {


    private List<Player> players;


    public PlayerRepositoryImpl() {
        this.players = new LinkedList<>();
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public void add(Player player) {
        if (player==null){
            throw new IllegalArgumentException("Player cannot be null");
        }

        for (Player existentPlayer :
                this.players) {
            if (existentPlayer.getUsername().equals(player.getUsername())){
                throw new IllegalArgumentException(String.format("Player %s already exists!",player.getUsername()));
            }

        }

        this.players.add(player);

    }

    @Override
    public boolean remove(Player player) {

        if (player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }

        int size = this.getCount();

        this.players = this.players.stream()
                .filter(p->!p.getUsername().equals(player.getUsername()))
                .collect(Collectors.toList());

        if (size > this.getCount()){
            return true;
        }



        return false;
    }

    @Override
    public Player find(String name) {

        Player player = null;
        for (Player existingPlayer :
                this.players) {
            if (existingPlayer.getUsername().equals(name)) {
                player = existingPlayer;
            }
            }

        return player;
    }
}

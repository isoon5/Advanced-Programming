package com.example.demo;

import java.util.List;

public class Game{
    List<Player> players;

    public Game(List<Player> players){
        this.players = players;
    }

    public List<Player>  getPlayers(){
        return players;
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }
}
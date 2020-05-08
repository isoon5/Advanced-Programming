package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player{
    @Id @GeneratedValue

    Integer id;

    String name;

    public Player(){

    }

    public Player(String name){
        this.name = name;
    }

    public Player(Integer id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

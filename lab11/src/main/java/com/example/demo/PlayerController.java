package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    @PostMapping("/players")
    public Player insertPlayer(@Valid @RequestParam String name){
        Player player = new Player();
        player.setName(name);
        playerRepository.save(player);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable(value = "id") int id, @Valid @RequestParam String name) throws  PlayerException{
        Player player = playerRepository.findById(id)
                .orElseThrow(()->new PlayerException());

        player.setName(name);
        playerRepository.save(player);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable(value = "id") int id) throws PlayerException{
        Player player =  playerRepository.findBy(id)
                .orElseThrow(() -> new PlayerException());

        playerRepository.delete(player);
        return ResponseEntity.ok().build();
    }

}

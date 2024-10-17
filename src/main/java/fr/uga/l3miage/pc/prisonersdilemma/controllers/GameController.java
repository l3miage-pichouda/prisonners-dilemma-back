package fr.uga.l3miage.pc.prisonersdilemma.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.uga.l3miage.pc.prisonersdilemma.requests.PseudoRequest;

@RestController
@RequestMapping("/api") 
public class GameController {

    @PostMapping("/join-game")
    public ResponseEntity<Map<String, String>> joinGame(@RequestBody PseudoRequest request) {
        String pseudo = request.getPseudo();
        System.out.println("Player joined with pseudo: " + pseudo);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Player joined successfully with pseudo: " + pseudo);

        return ResponseEntity.ok(response);
    }
}
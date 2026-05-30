package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@CrossOrigin("*")
public class FutController {

    private final FutRepository repository;

    public FutController(FutRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Fut> getPlayers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Fut getPlayerById(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Jogador não encontrado"));
    }

    @PostMapping
    public Fut createPlayer(@RequestBody Fut player) {
        return repository.save(player);
    }

    @PutMapping("/{id}")
    public Fut updatePlayer(
            @PathVariable Long id,
            @RequestBody Fut newPlayer
    ) {

        return repository.findById(id)
                .map(player -> {

                    player.setName(newPlayer.getName());
                    player.setPosition(newPlayer.getPosition());
                    player.setTeam(newPlayer.getTeam());
                    player.setAge(newPlayer.getAge());

                    return repository.save(player);

                }).orElseThrow(() ->
                        new RuntimeException("Jogador não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}